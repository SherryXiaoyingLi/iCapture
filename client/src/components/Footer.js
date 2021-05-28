import React from 'react';
import { Link } from 'react-router-dom';
import './../styles.css';

class Footer extends React.Component {
    render() {
        return (
            <div className="footer">
                <ul>
                    <li><Link to="/" className="react-link">home</Link></li>
                    <li><Link to="/profile" className="react-link">profile</Link></li>
                </ul>
            </div>
        );
    }
}

export default Footer;