import React, { Component } from "react";
import axios from "axios";

class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = { username: "", email: "", password: "", confirmPassword: "" , signupMessage: ""};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    this.setState({ [name]: value });
  }

  async handleSubmit(event) {
    event.preventDefault();
    if (this.state.password !== this.state.confirmPassword) {
      alert("Password doesn't match");
    } else {
      const signupRequest = {
        username: this.state.username,
        email: this.state.email,
        password: this.state.password,
      };
     await axios.post(
        "http://localhost:8080/api/v1/auth/signup",
        signupRequest
      ).then(response => {
        console.log(response);
        if(response.status === 201){
          this.setState({username:""})
          this.setState({email:""})
          this.setState({password:""})
          this.setState({confirmPassword:""}) 
        }
        this.setState({ signupMessage: response.data.message });
      }).catch(err => { 
        if (err.response) {
          // client received an error response (5xx, 4xx)
          this.setState({ signupMessage: err.response.data.message });
        } else if (err.request) {
          // client never received a response, or request never left
          this.setState({signupMessage:"Request failed! Please try again later!"})
        } else {
          // anything else
          this.setState({signupMessage:"Request failed! Please check your internet connection!"})
        }
      });
      
    }
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>
            User Name:
            <input
              type="text"
              name="username"
              value={this.state.username}
              onChange={this.handleChange}
            />
          </label>
          <br />
          <label>
            Email:
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </label>
          <br />
          <label>
            Password:
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
          </label>
          <br />
          <label>
            Confirm Password:
            <input
              type="password"
              name="confirmPassword"
              value={this.state.confirmPassword}
              onChange={this.handleChange}
            />
          </label>
          <br />
          <br />
          <input type="submit" value="Submit" />
        </form>
        <div>
          <h2>{this.state.signupMessage}</h2>
        </div>
      </div>
    );
  }
}

export default SignUp;
