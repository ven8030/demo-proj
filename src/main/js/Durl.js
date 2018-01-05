import React, { Component } from 'react';
/* eslint-disable */
const getDomainURL = url =>
 // `https://api.github.com/users/${username}`
`http://localhost:8080/domainApi`


class Durl extends Component {
  constructor(props) {
    super(props)
    this.getDomainData = this.getDomainData.bind(this);
    this.state = {
      requestFailed: false
    }
  }

  getDomainData() {
      fetch('http://localhost:8080/domainApi', {
        method: 'get',
      }).then(response => {
        if (!response.ok) {
          throw Error("failed")
        }
        return response
      })
      .then(domainData => domainData.json())
      .then(domainData => {
        this.setState({
          highestDomain: domainData
        })
      }, () => {
        this.setState({
          requestFailed: true
        })
      })
  }
  render() 
  {

    console.log("this is the state ... ",this.state);
    if (this.state.requestFailed) return <p>Failed....!</p>
    return (
      <div>
          <br/>
            <button className="btn btn-primary"
                            onClick={this.getDomainData}>
                            display </button>
            
        <h2>{this.state.highestDomain}</h2>
      </div>
    )
  }
}

export default Durl;


