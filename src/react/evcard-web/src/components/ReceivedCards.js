import React, { useState, useEffect } from "react";
import axios from "axios";
import VisitingCard from "./VisitingCard";
import { useHistory } from "react-router-dom";

const ReceivedCards = (props) => {
  const isloggedin = props.isloggedin;
  const history = useHistory();
  const accessToken = "Bearer " + localStorage.getItem("access-token");
  const [receivedCardsState, setReceivedCardsState] = useState({
    receivedCards: [],
    receivedCardsMessage: "",
  });
  useEffect(() => {
    if (isloggedin === "true") {
      axios
        .get("http://localhost:8080/api/v1/evcard/received", {
          headers: { Authorization: accessToken },
        })
        .then((response) => {
          console.log(response);
          if (response.status === 200) {
            setReceivedCardsState({
              ...receivedCardsState,
              receivedCards: response.data.message,
              receivedCardsMessage: "Your Received Cards",
            });
          }
        })
        .catch((err) => {
          console.log(err);
          if (err.response) {
            setReceivedCardsState({
              ...receivedCardsState,
              receivedCardsMessage:
                "Something went wrong! Try logging in again!",
            });
          } else if (err.request) {
            setReceivedCardsState({
              ...receivedCardsState,
              receivedCardsMessage: "Request failed! Please try again later!",
            });
          } else {
            setReceivedCardsState({
              ...receivedCardsState,
              receivedCardsMessage:
                "Request failed! Please check your internet connection!",
            });
          }
        });
    } else {
      history.push("/login");
    }
  }, [accessToken, isloggedin]);

  return (
    <div className="receivedCardsClass">
      <h1>{receivedCardsState.receivedCardsMessage}</h1>
      <ul>
        {receivedCardsState.receivedCards.map((receivedCard, index) => (
          <li key={index}>
            <VisitingCard visitingCard={receivedCard} />
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ReceivedCards;
