import React, { useState} from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom';
import HomePage from './components/home/HomePage'
import NewPostPage from './components/newPost/NewPostPage';
import ProfilePage from './components/profile/ProfilePage';
import LikesPage from './components/likes/likesPage';
import CommentsPage from './components/comments/CommentsPage';
import LoginPage from './components/login/LoginPage';
import {Context} from './context';
import './styles.css';

// //TODO: change to functional compopnent if don't need to handle states
function App() {

        const [auth, setAuth] = useState();

        if (!auth) {
            return <LoginPage setAuth={setAuth} />;
        }

        return (
            // need <Router> encapsulating header and footer b/c they contain <Link>
            <Context.Provider value={auth}>
                <Router>
                    <div>
                        <Route path="/" exact component={HomePage}/>
                        <Route path="/post" exact component={NewPostPage} />
                        <Route path="/profile" exact component={ProfilePage} />
                        <Route path="/likes" exact component={LikesPage}/>
                        <Route path="/comments" exact component={CommentsPage} />
                    </div>
                </Router>
            </Context.Provider>
        );
    
}

export default App;