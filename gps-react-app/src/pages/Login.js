import React, { useState } from "react";
import Axios from "axios";

function Login(){
const username = "creator";
const password = "creator"

const [usernameState, setUsernameState] =useState("");
const [passwordState, setPasswordState] =useState("");
const [loggedIn, setLoggedIn] =  useState(false);
const [welcome, setWelcome] =useState("");

const getWelcome = ()=>{
Axios.get('https://api.chucknorris.io/jokes/random').then(
(response) => {
console.log(response);
setWelcome(response.data.value);
}
);
};

    function checkCredentials() {
        if(usernameState === username && passwordState === password) {
        setLoggedIn(true);
        }
    }
    return (
        <div className="login">
            <h1>Login</h1>
            <input type="text"
            onChange={(event)=>{
                setUsernameState(event.target.value);
                }}
            />
            <input type="password"
            onChange={(event)=>{
                setPasswordState(event.target.value);
                }}
            />
            <button onClick={(checkCredentials, getWelcome)}>Log In</button> {}
            {loggedIn && <h1>logged In</h1>}
            {welcome}

        </div>
    );
   }

export default Login;

