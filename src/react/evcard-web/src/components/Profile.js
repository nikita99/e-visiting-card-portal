import React, { useState, useEffect } from "react";
import axios from "axios";
import VisitingCard from "./VisitingCard";
import ShareVisitingCard from "./ShareVisitingCard";
import { useHistory } from "react-router-dom";

const Profile = (props) => {
  const isloggedin = props.isloggedin;
  const history = useHistory();
  const accessToken = "Bearer " + localStorage.getItem("access-token");
  const [profileState, setProfileState] = useState({
    username: "",
    visitingCards: [],
    profileMessage: "",
  });
  useEffect(() => {
    if (isloggedin === "true") {
      axios
        .get("http://localhost:8080/api/v1/profile", {
          headers: { Authorization: accessToken },
        })
        .then((response) => {
          console.log(response);
          if (response.status === 200) {
            setProfileState({
              ...profileState,
              username: response.data.message.user.username,
              visitingCards: response.data.message.visitingCards,
              profileMessage: "Welcome!",
            });
          }
        })
        .catch((err) => {
          console.log(err);
          if (err.response) {
            setProfileState({
              ...profileState,
              profileMessage: "Something went wrong! Try logging in again!",
            });
          } else if (err.request) {
            setProfileState({
              ...profileState,
              profileMessage: "Request failed! Please try again later!",
            });
          } else {
            setProfileState({
              ...profileState,
              profileMessage:
                "Request failed! Please check your internet connection!",
            });
          }
        });
    } else {
      history.push("/login");
    }
  }, [accessToken, isloggedin]);

  return (
    <div className="profileClass">
      <h1>
        {profileState.profileMessage} {profileState.username}
      </h1>
      <ul>
        {profileState.visitingCards.map((visitingCard, index) => (
          <li key={index}>
            <VisitingCard visitingCard={visitingCard} />
            <ShareVisitingCard visitingCard={visitingCard} />
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Profile;
