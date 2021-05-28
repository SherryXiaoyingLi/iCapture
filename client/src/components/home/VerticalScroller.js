import axios from 'axios';
import React from 'react'
import PostContainer from "./PostContainer";


class VerticalScroller extends React.Component {
    constructor(props) {
        super(props)
        this.state = { postList: [] }
    } 

    async componentDidMount() {
        const response = await axios.get('http://localhost:8080/api/photos/public', {
            headers: {
                "Content-Type": "application/json",
                "Authorization":
                `${process.env.REACT_APP_BEARER_TOKEN}`
            }
        })

        this.setState({postList: response.data})
        
    }


    render() {

        let postList = this.state.postList.map((post) =>
            <li key={post.photoId}><PostContainer post={post}/></li>
        )

        return <ul>{postList}</ul>;
    }
}

export default VerticalScroller;