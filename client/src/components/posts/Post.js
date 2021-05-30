import React from 'react';
import PostHeader from './postHeader';
import PostMain from './postMain';
import PostFooter from './PostFooter';
import './../../styles.css'

class Post extends React.Component {
    render() {
        let post = this.props.post;
        return (
            <div>
                <PostHeader user={post.userId}/>
                <PostMain url={post.s3Url} text={post.text}/>
                <PostFooter likes={post.likedBy.length} time={post.timePosted}/>
            </div>
        );
    }
}

export default Post;