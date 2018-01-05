import React, { Component } from 'react';
/* eslint-disable */
class UpdateURI extends Component {
    constructor(props) {
      super(props)
     this.submitDomainUrl = this.submitDomainUrl.bind(this);
      this.state = {
        requestFailed: false
      }
    }
    submitDomainUrl() {
        var content = document.getElementById('uritext').value;
        var urlCount = document.getElementById('urlcount').value;
        var opts ={
            url:content,
            count:10,
        }
         var url = 'http://localhost:8080/domainApi/'+content+'/count/'+urlCount
          fetch(url, {
            method: 'get',
            //body: JSON.stringify(opts)
          }).then(function(response) {
            return response.json();
          }).then(function(data) {
            console.log('Created domain Data:', data);
          });
      }

    render() {  
      console.log("this is the state ... ",this.state);
     if (this.state.requestFailed) return <p>Failed!</p>
        return (
            <div>
            Type Url (with domain::) :
            <input type='text' id='uritext' name="textarea" size='20'/>
                <br/>
                <br/>
            Enter count :
            <input type='text' id='urlcount' name="textarea" size='20'/>
            <br/>
            <br/>
            <button className="btn btn-primary"
                            onClick={this.submitDomainUrl}>
                            Add </button>
            <h2>{this.state.highestDomain}</h2>
            </div>
            )
          }
}
export default UpdateURI;