import React, { useState } from "react";

function LogInPage({login}){

    const [usernameState, setUsernameState] =useState("");
    const [passwordState, setPasswordState] =useState("");

    const tryLogin = () => {
        login(usernameState, passwordState);
    }

    return (
        <div className="login">

            <h1>Login</h1>

            <input type="text" onChange={(event)=>{setUsernameState(event.target.value);}}/>

            <input type="password" onChange={(event)=>{setPasswordState(event.target.value)}}/>
            <button onClick={tryLogin}>Log In</button>
        </div>
    );
   }

export default LogInPage;

