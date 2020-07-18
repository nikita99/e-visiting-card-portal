import React, { Component } from "react";
import Header from "./components/Header";
import Home from "./components/Home";
import { Switch, Route } from "react-router-dom";
import SignUp from "./components/SignUp";
import Login from "./components/Login";

const App = () => {
  return (
    <div>
      <Header />
      <Switch>
        <Route path="/signup">
          <SignUp />
        </Route>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
    </div>
  );
};

export default App;
