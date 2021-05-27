import React from 'react';
import { Link } from 'react-router-dom';
import './../styles.css';

class Header extends React.Component {
    render() {
        return (
            <div class="header">
                <ul>
                    <li><img src={`${process.env.PUBLIC_URL}/assets/icon.png`} alt=""/></li>
                    <li><Link to="/post" class="react-link">add</Link></li>
                </ul>
            </div>
        )
    }
}

export default Header;