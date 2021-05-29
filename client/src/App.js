import React, { useState} from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom';
import HomeContainer from './components/home/HomeContainer'
import NewPostContainer from './components/newPost/NewPostContainer';
import ProfileContainer from './components/profile/ProfileContainer';
import LikesContainer from './components/home/likes';
import CommentsContainer from './components/home/comments/CommentsContainer';
import Login from './components/login/Login';
import {Context} from './context';
import './styles.css';

// //TODO: change to functional compopnent if don't need to handle states
function App() {

        const [auth, setAuth] = useState();

        if (!auth) {
            return <Login setAuth={setAuth} />;
        }

        return (
            // need <Router> encapsulating header and footer b/c they contain <Link>
            <Context.Provider value={auth}>
                <Router>
                    <div>
                        <Route path="/" exact component={HomeContainer}/>
                        <Route path="/post" exact component={NewPostContainer} />
                        <Route path="/profile" exact component={ProfileContainer} />
                        <Route path="/likes" exact component={LikesContainer}/>
                        <Route path="/comments" exact component={CommentsContainer} />
                    </div>
                </Router>
            </Context.Provider>
        );
    
}

export default App;