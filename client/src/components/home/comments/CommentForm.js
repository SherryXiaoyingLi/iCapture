import React from 'react';
import axios from 'axios';

class CommentForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {value: 'Add a comment...'}
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    async handleSubmit(event) {
        
        let obj = {"commentId": 1, "content": this.state.value, "userId": 1}
        let photoId = '1';

        // place before axios.post, by default re-render the page
        event.preventDefault();

        const response = await axios.post('http://localhost:8080/api/comments/'+ photoId, obj, {
            headers: {
                "Content-Type": "application/json",
                "Authorization":
                `${process.env.bearerToken}`
            }
        })
        let commentid = response.data;
        console.log(commentid)

        // use this.state.value set previously to handle submission
        this.props.handleNewComment(this.state.value);
        
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <textarea value={this.state.value} onChange={this.handleChange} />
                <input type="submit" value="Post" />
            </form>

        );
    }
}

export default CommentForm;