import React from 'react';
import HorizontalScroller from './HorizontalScroller';
import VerticalScroller from './VerticalScroller';
import Header from './Header';
import Footer from './Footer';

class HomePage extends React.Component {
    render() {
        return (
            <div>
                <Header />
                <hr />
                <HorizontalScroller />
                <hr />
                <VerticalScroller />
                <hr />
                <Footer />
            </div>
        );
    }
}

export default HomePage;