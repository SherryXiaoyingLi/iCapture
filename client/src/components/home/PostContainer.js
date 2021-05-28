import React from 'react';
import PostHeader from './postHeader';
import PostView from './postView';
import PostFooter from './PostFooter';
import './../../styles.css';

class PostContainer extends React.Component {
    render() {
        let post = this.props.post;
        return (
            <div>
                <PostHeader user={post.userId}/>
                <PostView url={post.s3Url} text={post.text}/>
                <PostFooter likes={post.likedBy.length} time={post.timePosted}/>
            </div>
        );
    }
}

export default PostContainer;