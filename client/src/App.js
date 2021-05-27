import React from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom';
import HomeContainer from './components/home/HomeContainer'
import NewPostContainer from './components/newPost/NewPostContainer';
import ProfileContainer from './components/profile/ProfileContainer';
import LikesContainer from './components/home/likes';
import CommentsContainer from './components/home/comments';
import './styles.css';

// //TODO: change to functional compopnent if don't need to handle states
class App extends React.Component {

    render() {

        return (
            // need <Router> encapsulating header and footer b/c they contain <Link>
            <Router>
                <div>
                    <Route path="/" exact component={HomeContainer}/>
                    <Route path="/post" exact component={NewPostContainer} />
                    <Route path="/profile" exact component={ProfileContainer} />
                    <Route path="/likes" exact component={LikesContainer}/>
                    <Route path="/comments" exact component={CommentsContainer} />
                </div>
            </Router>
        );
    }
}


export default App;