import React, { Component } from 'react';
import './App.css';
 /* eslint-disable */
import Durl from './Durl.js';
import UpdateURI from './UpdateURI.js'
class App extends Component {
  render() {
    return (
      <div className="App">
        <UpdateURI />
        <Durl />
      </div>
    );
  }
}

export default App;
