import './../../post.css';

const postView = (props) => {
    return (<div>
                <img src={`${process.env.PUBLIC_URL}`+props.url} className="post-pic" alt=""/>
                <p>{props.text}</p>
            </div>);
}

export default postView;
