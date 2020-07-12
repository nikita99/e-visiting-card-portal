import React, { Component } from "react";
import axios from "axios";

class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = { username: "", email: "", password: "", confirmPassword: "" };

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
    if (this.state.password != this.state.confirmPassword) {
      alert("password doesnt match");
    } else {
      const signupRequest = {
        username: this.state.username,
        email: this.state.email,
        password: this.state.password,
      };
      const res = await axios.post(
        "http://localhost:8080/api/v1/auth/signup",
        signupRequest
      );
      console.log(res);
      //   if(res.status == 201){
      //       if(res.data.)
      //   }
    }
  }

  render() {
    return (
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
    );
  }
}

export default SignUp;
