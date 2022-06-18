import React, { useEffect, useRef, useState } from 'react'
import { useNavigate } from 'react-router'
import useAuth from '../../hooks/useAuth'
import jwt_decode from "jwt-decode"
import logo from '../../../src/images/ivanti-logo.svg';
import "../../styles/Authentication&Authorisation/login.css";

import axios from "axios"
const URL = 'http://localhost:8080/login'

const LoginPage = () => {

    const { setAuth } = useAuth();

    const navigate = useNavigate();

    const usernameRef = useRef();

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    useEffect(() => {
        usernameRef.current.focus();
    }, [])

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(URL,
                JSON.stringify({username, password}),
                {
                    headers: {'Content-Type': 'application/json'}
                }
            );

            const accessToken = response?.data?.accessToken;
            const decoded = jwt_decode(accessToken);
            const roles = decoded?.roles;
            console.log(roles)
            setAuth({ accessToken, decoded, roles });

            setUsername('')
            setPassword('')

            navigate('/')
        } catch (err) {
            console.log(err)
        }
    }

  return (
    <div className='container'>
        <div className='login-container'>
            <div className='login-logo'>
                <img src={logo} />
            </div>
            <form onSubmit={handleSubmit}>
                <h2>Login</h2>
                <input className='login-input' type={'username'} placeholder='username' ref={usernameRef} value={username} onChange={(e) => {setUsername(e.target.value)}} />
                <input className='login-input' type={'password'} placeholder='password' value={password} onChange={(e) => setPassword(e.target.value)} />
                <button className='login-button'>Login</button>
            </form>
        </div>
    </div>
  )
}

export default LoginPage
