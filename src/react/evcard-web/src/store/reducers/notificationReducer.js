const initState = {};

const notificationReducer = (state = initState, action) => {
  switch (action.type) {
    case "SEND_NOTIFICATION_SUCCESS":
      console.log("notifications sharing card success");
      return state;
    case "SEND_NOTIFICATION_ERROR":
      console.log("notifications sharing card error");
      return state;
    default:
      return state;
  }
};

export default notificationReducer;
