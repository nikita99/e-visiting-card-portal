import React from "react";
import { NavLink } from "react-router-dom";

const Home = () => {
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
};

export default Home;
