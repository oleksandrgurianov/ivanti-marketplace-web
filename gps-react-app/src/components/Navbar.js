import React from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from '../pages/home'
import Contact from '../pages/contact'
import About from '../pages/about'

import { Nav, NavLogo, NavLink, Bars, NavMenu, NavBtn, NavBtnLink,} from "./navElements";

const Navbar = () => {
    return (
        <>
           <Nav>
            <NavLogo to="/Home">
                Ivanti AppMarket :)
            </NavLogo>
            <Bars />

            <NavMenu>
                <NavLink to="/" activeStyle={{ color:'black' }}> Home </NavLink>
                <NavLink to="../pages/about"activeStyle={{ color: 'black' }}> About</NavLink>
                <NavLink to="../pages/contact" activeStyle={{ color: 'black' }}>Contact</NavLink>
                <NavLink to="/login"activeStyle={{ color: 'black' }}>Log In</NavLink>

                <NavBtn><NavBtnLink to='../pages/logIn'>Log In</NavBtnLink></NavBtn>
            </NavMenu>
           </Nav>
        </>
    );
};
export default Navbar;