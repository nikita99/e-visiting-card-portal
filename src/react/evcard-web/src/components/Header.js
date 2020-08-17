import React from "react";
import { NavLink } from "react-router-dom";

const Header = (props) => {
  const isloggedin = props.isloggedin;
  if (isloggedin === true) {
    return (
      <div className="header">
        <h1>e-Vcard</h1>
        <NavLink to="/profile">
          <button className="profile">Profile</button>
        </NavLink>
        <hr />
      </div>
    );
  } else {
    return (
      <div className="header">
        <h1>e-Vcard</h1>
        <NavLink to="/signup">
          <button className="signup">SignUp</button>
        </NavLink>
        <br />
        <NavLink to="/login">
          <button className="login">Login</button>
        </NavLink>
        <hr />
      </div>
    );
  }
};

export default Header;
