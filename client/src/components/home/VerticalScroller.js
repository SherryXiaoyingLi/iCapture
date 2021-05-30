import axios from 'axios';
import React, { useState, useEffect, useContext } from 'react'
import Post from "./../posts/Post"
import { Context } from './../../context';

function VerticalScroller() {

    const [postList, setPostList] = useState([]);

    let auth = useContext(Context);
    

    // effect function is synchronous, use the following for asynchronous call
    useEffect(() => {
        async function fetchData() {
            const response = await axios.get('http://localhost:8080/api/photos/public', {
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + auth.token
                }
            })
            setPostList(response.data)
        }
        fetchData();
    }, [auth.token]) // or [someId] if effect needs some state or prop


    let posts = postList.map((post) =>
        <li key={post.photoId}><Post post={post}/></li>
    )

    return <ul>{posts}</ul>;
    
}


export default VerticalScroller;