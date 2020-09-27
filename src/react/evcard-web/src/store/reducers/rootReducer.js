import notificationReducer from "./notificationReducer";
import { combineReducers } from "redux";
import { firestoreReducer } from "redux-firestore";

const rootReducer = combineReducers({
  notification: notificationReducer,
  firestore: firestoreReducer,
});

export default rootReducer;
