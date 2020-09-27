import notificationReducer from "../reducers/notificationReducer";

export const createNotification = (notification) => {
  return (dispatch, getState, { getFirestore }) => {
    // make async call to database
    const firestore = getFirestore();
    firestore
      .collection(notification.toEmail)
      .add({
        ...notification,
        createdAt: new Date(),
      })
      .then(() => {
        dispatch({ type: "SEND_NOTIFICATION_SUCCESS" });
      })
      .catch((err) => {
        dispatch({ type: "SEND_NOTIFICATION_ERROR" }, err);
      });
  };
};
