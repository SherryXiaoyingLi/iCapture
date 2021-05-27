import React from 'react';
import StoryContainer from './StoryContainer';
import VerticalScroller from './VerticalScroller';
import Header from './../Header';
import Footer from './../Footer';

class HomeContainer extends React.Component {
    render() {
        return (
            <div>
                <Header />
                <hr />
                <StoryContainer />
                <hr />
                <VerticalScroller />
                <hr />
                <Footer />
            </div>
        );
    }
}

export default HomeContainer;