import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";

const CreateVcard = (props) => {
  const history = useHistory();
  const isloggedin = props.isloggedin;
  const [createVcardState, setCreateVcardState] = useState({
    firstName: "",
    lastName: "",
    office: "",
    designation: "",
    contact: "",
    createVcardMessage: "",
  });

  if (isloggedin !== "true") {
    history.push("/login");
    return null;
  }

  const accessToken = "Bearer " + localStorage.getItem("access-token");

  const handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    setCreateVcardState({ ...createVcardState, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const createVcardRequest = {
      firstName: createVcardState.firstName,
      lastName: createVcardState.lastName,
      office: createVcardState.office,
      designation: createVcardState.designation,
      contact: createVcardState.contact,
    };
    axios
      .post("http://localhost:8080/api/v1/evcard", createVcardRequest, {
        headers: { Authorization: accessToken },
      })
      .then((response) => {
        console.log(response);
        if (response.status === 201) {
          setCreateVcardState({
            ...createVcardState,
            firstName: "",
            lastName: "",
            office: "",
            designation: "",
            contact: "",
            createVcardMessage: "",
          });
          history.push("/profile");
        }
      })
      .catch((err) => {
        if (err.response) {
          setCreateVcardState({
            ...createVcardState,
            createVcardMessage: err.response.data.message,
          });
        } else if (err.request) {
          setCreateVcardState({
            ...createVcardState,
            createVcardMessage: "Request failed! Please try again later!",
          });
        } else {
          setCreateVcardState({
            ...createVcardState,
            createVcardMessage:
              "Request failed! Please check your internet connection!",
          });
        }
      });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          First Name:
          <input
            type="text"
            name="firstName"
            value={createVcardState.firstName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Last Name:
          <input
            type="text"
            name="lastName"
            value={createVcardState.lastName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Office:
          <input
            type="text"
            name="office"
            value={createVcardState.office}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Designation:
          <input
            type="text"
            name="designation"
            value={createVcardState.designation}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Contact:
          <input
            type="text"
            name="contact"
            value={createVcardState.contact}
            onChange={handleChange}
          />
        </label>
        <br />
        <br />
        <input type="submit" value="Submit" />
      </form>
      <div>
        <h2>{createVcardState.createVcardMessage}</h2>
      </div>
    </div>
  );
};

export default CreateVcard;
