import React, { useState } from "react";
import Popup from "reactjs-popup";
import axios from "axios";

const ShareVistingCard = (props) => {
  const accessToken = "Bearer " + localStorage.getItem("access-token");
  const [shareState, setShareState] = useState({
    email: "",
  });

  const handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    setShareState({ ...shareState, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const shareVcardRequest = {
      vcardId: props.visitingCard.vcardId,
      receiverEmail: shareState.email,
    };

    axios
      .post("http://localhost:8080/api/v1/evcard/share", shareVcardRequest, {
        headers: { Authorization: accessToken },
      })
      .then((response) => {
        if (response.status === 200) {
          setShareState({
            ...shareState,
            email: "",
          });
          alert(response.data.message);
        }
      })
      .catch((err) => {
        if (err.response) {
        } else if (err.request) {
        } else {
        }
        alert("Sorry, VCard wasn't shared.");
      });
  };

  return (
    <Popup trigger={<button> Share</button>} position="right center">
      <form onSubmit={handleSubmit}>
        <br />
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={shareState.email}
            onChange={handleChange}
          />
        </label>
        <input type="submit" value="Submit" />
      </form>
    </Popup>
  );
};

export default ShareVistingCard;
