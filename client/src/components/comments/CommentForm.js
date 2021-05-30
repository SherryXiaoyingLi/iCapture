import React, { useState, useContext } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';
import { Context } from './../../context'

function CommentForm(props) {

    const [stateValue, setStateValue] = useState('Add a comment')
    let auth = useContext(Context);

    var handleChange = (event) => {
        setStateValue(event.target.value);
    };

    var handleSubmit = async (event) => {
        
        let obj = {"commentId": 1, "content": stateValue, "userId": auth.user.userId}
        let photoId = '3';

        // place before axios.post, by default re-render the page
        event.preventDefault();

        const response = await axios.post('http://localhost:8080/api/comments/'+ photoId, obj, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + auth.token
            }
        })
        let commentid = response.data;
        console.log(commentid)

        // use this.state.value set previously to handle submission
        props.handleNewComment(stateValue);
        
    }

        return (
            <form onSubmit={handleSubmit}>
                <textarea value={stateValue} onChange={handleChange} />
                <input type="submit" value="Post" />
            </form>

        );
}

CommentForm.propTypes = {
    handleNewComment: PropTypes.func.isRequired
}

export default CommentForm;