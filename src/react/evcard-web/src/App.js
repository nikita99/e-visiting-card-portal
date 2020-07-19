import React, { useState } from "react";
import Header from "./components/Header";
import Home from "./components/Home";
import { Switch, Route } from "react-router-dom";
import SignUp from "./components/SignUp";
import Login from "./components/Login";

const App = () => {
  const [loggedin, setLoggedin] = useState(localStorage.getItem("loggedin"));
  return (
    <div>
      <Header isloggedin={loggedin}/>
      <Switch>
        <Route path="/signup">
          <SignUp />
        </Route>
        <Route path="/login">
          <Login setLoggedin={setLoggedin}/>
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
    </div>
  );
};

export default App;
