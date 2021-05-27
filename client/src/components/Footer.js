import React from 'react';
import { Link } from 'react-router-dom';
import './../styles.css';

class Footer extends React.Component {
    render() {
        return (
            <div class="footer">
                <ul>
                    <li><Link to="/" class="react-link">home</Link></li>
                    <li><Link to="/profile" class="react-link">profile</Link></li>
                </ul>
            </div>
        );
    }
}

export default Footer;