import React, { useState } from "react";
import Header from "./components/Header";
import Home from "./components/Home";
import { Switch, Route } from "react-router-dom";
import SignUp from "./components/SignUp";
import Login from "./components/Login";
import Profile from "./components/Profile";
import CreateVcard from "./components/CreateVcard";
import ReceivedCards from "./components/ReceivedCards";

const App = () => {
  const [loggedin, setLoggedin] = useState(localStorage.getItem("loggedin"));
  return (
    <div>
      <Header isloggedin={loggedin} />
      <Switch>
        <Route path="/signup">
          <SignUp />
        </Route>
        <Route path="/login">
          <Login setLoggedin={setLoggedin} isloggedin={loggedin} />
        </Route>
        <Route path="/profile">
          <Profile isloggedin={loggedin} />
        </Route>
        <Route path="/create">
          <CreateVcard isloggedin={loggedin} />
        </Route>
        <Route path="/received">
          <ReceivedCards isloggedin={loggedin} />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
    </div>
  );
};

export default App;
