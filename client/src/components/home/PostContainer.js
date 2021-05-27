import React from 'react';
import PostHeader from './postHeader';
import PostView from './postView';
import PostFooter from './PostFooter';
import './../../styles.css';

class PostContainer extends React.Component {
    render() {
        return (
            <div>
                <PostHeader />
                <PostView url={this.props.url}/>
                <PostFooter />
            </div>
        );
    }
}

export default PostContainer;