import React from 'react';
import { Link } from 'react-router-dom';
import './../../post.css';

class PostFooter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {likes: 0};
        this.handleLike = this.handleLike.bind(this);
    }

    handleLike() {
        this.setState((state) => ({
            likes: state.likes + 1
        }));
    }


    render() {
        return (<div class="post-footer">
                    <ul>
                        <li onClick={this.handleLike}>like this post</li>
                        <li><Link to="/likes">{this.state.likes}</Link></li>
                        <li><Link to="/comments">comments</Link></li>
                    </ul>
                </div>);
    }
} 

export default PostFooter;