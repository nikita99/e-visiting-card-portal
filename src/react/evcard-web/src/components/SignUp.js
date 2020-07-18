import React, { useState } from "react";
import axios from "axios";

const SignUp = () => {
  const [signupState, setSignupState] = useState({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
    signupMessage: "",
  });

  const handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    setSignupState({ ...signupState, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (signupState.password !== signupState.confirmPassword) {
      alert("Password doesn't match");
    } else {
      const signupRequest = {
        username: signupState.username,
        email: signupState.email,
        password: signupState.password,
      };
      axios
        .post("http://localhost:8080/api/v1/auth/signup", signupRequest)
        .then((response) => {
          console.log(response);
          if (response.status === 201) {
            setSignupState({
              ...signupState,
              username: "",
              email: "",
              password: "",
              confirmPassword: "",
              signupMessage: response.data.message,
            });
          }
        })
        .catch((err) => {
          if (err.response) {
            // client received an error response (5xx, 4xx)
            setSignupState({
              ...signupState,
              signupMessage: err.response.data.message,
            });
          } else if (err.request) {
            // client never received a response, or request never left
            setSignupState({
              ...signupState,
              signupMessage: "Request failed! Please try again later!",
            });
          } else {
            // anything else
            setSignupState({
              ...signupState,
              signupMessage:
                "Request failed! Please check your internet connection!",
            });
          }
        });
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          User Name:
          <input
            type="text"
            name="username"
            value={signupState.username}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={signupState.email}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={signupState.password}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Confirm Password:
          <input
            type="password"
            name="confirmPassword"
            value={signupState.confirmPassword}
            onChange={handleChange}
          />
        </label>
        <br />
        <br />
        <input type="submit" value="Submit" />
      </form>
      <div>
        <h2>{signupState.signupMessage}</h2>
      </div>
    </div>
  );
};

export default SignUp;
