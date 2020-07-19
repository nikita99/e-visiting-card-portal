import React, { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

const Login = (props) => {
  const history = useHistory();

  const [loginState, setLoginState] = useState({
    email: "",
    password: "",
    loginMessage: "",
  });

  const handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    setLoginState({ ...loginState, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const loginRequest = {
      email: loginState.email,
      password: loginState.password,
    };
    axios
      .post("http://localhost:8080/api/v1/auth/login", loginRequest)
      .then((response) => {
        console.log(response);
        if (response.status === 200) {
          setLoginState({
            ...loginState,
            email: "",
            password: "",
            loginMessage: "You logged in successfully!",
          });
          localStorage.setItem(
            "access-token",
            response.data.message.accessToken
          );
          localStorage.setItem("loggedin", true);
          props.setLoggedin(true);
          history.push("/");
        } else {
          setLoginState({
            ...loginState,
            email: "",
            password: "",
            loginMessage: "Please check your credentials!",
          });
        }
      })
      .catch((err) => {
        if (err.response) {
          setLoginState({
            ...loginState,
            loginMessage: err.response.data.message,
          });
        } else if (err.request) {
          setLoginState({
            ...loginState,
            loginMessage: "Request failed! Please try again later!",
          });
        } else {
          setLoginState({
            ...loginState,
            loginMessage:
              "Request failed! Please check your internet connection!",
          });
        }
      });
  };

  return (
    <div>
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <br />
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={loginState.email}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={loginState.password}
            onChange={handleChange}
          />
        </label>
        <br />
        <br />
        <br />
        <input type="submit" value="Submit" />
      </form>
      <div>
        <h2>{loginState.loginMessage}</h2>
      </div>
    </div>
  );
};

export default Login;
