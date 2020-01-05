import firebase from 'firebase/app';
import 'firebase/auth';
import 'firebase/firestore';
import 'firebase/analytics';

const firebaseConfig = {
    apiKey: "AIzaSyC4_ronNDjnaVw_x7ltUBpHsl7af4oWXLU",
    authDomain: "svelte-playground-9adc9.firebaseapp.com",
    databaseURL: "https://svelte-playground-9adc9.firebaseio.com",
    projectId: "svelte-playground-9adc9",
    storageBucket: "svelte-playground-9adc9.appspot.com",
    messagingSenderId: "384015497945",
    appId: "1:384015497945:web:a69be9098796d8aba8dcc8",
    measurementId: "G-WQ6TK51N4E"
}

console.log(firebase);

firebase.initializeApp(firebaseConfig);
firebase.analytics();

export const auth = firebase.auth();
export const googleProvider = new firebase.auth.GoogleAuthProvider();
export const db = firebase.firestore();