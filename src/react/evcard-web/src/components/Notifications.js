import React, { useState } from "react";
import { connect } from "react-redux";
import { firestoreConnect } from "react-redux-firebase";
import { compose } from "redux";

const Notifications = (props) => {
  const { notifications } = props;

  const [expand, setExpand] = useState(false);

  const handleOnClick = () => {
    setExpand(!expand);
  };

  return (
    <div>
      <button onClick={handleOnClick}>Notifications</button>
      <ul>
        {expand &&
          notifications &&
          notifications.map((notification) => {
            return (
              <li key={notification.id}>
                {" "}
                {notification.fromEmail} {notification.message}{" "}
              </li>
            );
          })}
      </ul>
    </div>
  );
};

const mapStateToProps = (state) => {
  console.log(state);
  return {
    notifications: state.firestore.ordered[localStorage.getItem("useremail")],
  };
};

export default compose(
  connect(mapStateToProps),
  firestoreConnect([
    {
      collection: localStorage.getItem("useremail"),
      limit: 3,
      orderBy: ["createdAt", "desc"],
    },
  ])
)(Notifications);
