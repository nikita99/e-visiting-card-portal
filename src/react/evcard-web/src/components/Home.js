import React, { Component } from "react";
import { NavLink } from "react-router-dom";

class Home extends Component {
  render() {
    return (
      <div>
        <p>We provide e-visiting card solutions</p>
        <NavLink to="/signup">
          <button className="signup">SignUp</button>
        </NavLink>
        <br />
        <NavLink to="/login">
          <button className="login">Login</button>
        </NavLink>
      </div>
    );
  }
}

export default Home;
