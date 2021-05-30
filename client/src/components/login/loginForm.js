import { useState } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';

function LoginForm({setAuth}) {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    var handleSubmit = async (event) =>  {
        event.preventDefault();
        let data = {"username": username, "password": password}
        let response = await axios.post('http://localhost:8080/api/users/login', data)
        setAuth(response.data)

    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                <p>Username</p>
                <input type="text" onChange={event => setUsername(event.target.value)}/>
            </label>
            <label>
                <p>Password</p>
                <input type="password" onChange={event => setPassword(event.target.value)}/>
            </label>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    )
}

LoginForm.propTypes = {
    setAuth: PropTypes.func.isRequired
}

export default LoginForm;