import React from 'react'
import PostContainer from "./PostContainer";


class VerticalScroller extends React.Component {
    constructor(props) {
        super(props)
        this.state = {postUrls: [`${process.env.PUBLIC_URL}/assets/pic.jpg`, `${process.env.PUBLIC_URL}/assets/pic.jpg`]}
    } 

    render() {
        let postList = this.state.postUrls.map((url) =>
            <li key={url}><PostContainer url={url}/></li>
        )

        return <ul>{postList}</ul>;
    }
}

export default VerticalScroller;