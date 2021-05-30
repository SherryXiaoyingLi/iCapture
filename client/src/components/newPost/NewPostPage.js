import './../../styles.css';
import { useState, useContext} from 'react';
import { Context } from './../../context';
import axios from 'axios';
import { Redirect } from 'react-router-dom';

function NewPostPage() {

        const [fileValue, setFileValue] = useState();
        const [textValue, setTextValue] = useState("");
        const [photoId, setPhotoId] = useState();

        let auth = useContext(Context)
    

        var onSubmitHandler = async (e) => {
            e.preventDefault()
            const formData = new FormData()
            formData.append('file', fileValue)
            formData.append('text', textValue)

            let response = await axios.post("http://localhost:8080/api/photos/upload/" +  auth.user.userId, formData,
            { 
                headers: {
                    "Authorization": "Bearer " + auth.token
                }
            })

            setPhotoId(response.data)
        }

        if (!photoId) {
            return (
                <div>
                    <form onSubmit={onSubmitHandler} enctype="multipart/form-data">
                        <label>
                            Upload your file
                            <input type="file" onChange={(e) => setFileValue(e.target.files[0])} />
                        </label>
                        <label>
                            Enter text here
                            <input type="text/" value={textValue} onChange={(e) => setTextValue(e.target.value)} />
                        </label>
                        <div><button type="submit">Submit</button></div>
                    </form>
                </div>
            );
        } else {
            return <Redirect to = "/" />
        }
    
}

export default NewPostPage;