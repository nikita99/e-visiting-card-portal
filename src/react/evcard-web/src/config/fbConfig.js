import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
var firebaseConfig = {
  apiKey: "AIzaSyDYgh8cy2tTZ-GUmXjVrNMyrAr12VKPfjY",
  authDomain: "ndad-evcard.firebaseapp.com",
  databaseURL: "https://ndad-evcard.firebaseio.com",
  projectId: "ndad-evcard",
  storageBucket: "ndad-evcard.appspot.com",
  messagingSenderId: "984265715714",
  appId: "1:984265715714:web:86471ed4ab6506363ff71b",
  measurementId: "G-M8EZB4D7YV",
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
// firebase.analytics();

export default firebase;
