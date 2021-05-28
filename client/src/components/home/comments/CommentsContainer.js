import React from 'react';
import CommentForm from './CommentForm'

class CommentsContainer extends React.Component {
    constructor(props) {
        super(props)
        this.state = {comments: []}
        this.onNewComment = this.onNewComment.bind(this)
    }

    onNewComment(value) {
        // treat this.state as if they were immutable
        this.setState((state) => ({comments: [...state.comments, value]}))
    }

    render() {
        //TODO: add key here!
        let commentList = this.state.comments.map((comment) => <li>{comment}</li>)
        return (<div>
                    <ul>
                    {commentList}
                    </ul>
                    <hr />
                    <CommentForm handleNewComment={this.onNewComment} />
                </div>);
    }
}

export default CommentsContainer;