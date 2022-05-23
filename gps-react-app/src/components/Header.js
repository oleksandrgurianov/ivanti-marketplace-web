import React from 'react'
import { Link } from "react-router-dom";
import logo from "../images/ivanti-marketplace-logo.png";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faGlobe, faCaretDown } from '@fortawesome/free-solid-svg-icons'

function Navbar() {
    function showContent() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    window.onclick = function(e) {
        if (!e.target.matches('.dropdown-button')) {
            let myDropdown = document.getElementById("myDropdown");

            if (myDropdown.classList.contains('show')) {
                myDropdown.classList.remove('show');
            }
        }
    }

    return (
        <div className="Nav">
            <Link className="NavLogo" to="/">
                <img src={logo} height={"38px"} alt={"ivanti marketplace logo"}/>
            </Link>
            <Link className="NavLink" to="/creator/1/myApps">My Apps</Link>
            <Link className="NavLink" to="/creator/1/analytics">Analytics</Link>
            <Link className="NavLink" to="/creator/1/notifications">Notifications</Link>
            <div className="NavTranslate">Translate<FontAwesomeIcon className="NavIcon" icon={faGlobe} /></div>
            <div className="NavDropdown">
                <button className="dropdown-button" onClick={showContent}>Lars Kluijtmans<FontAwesomeIcon className="NavIcon" icon={faCaretDown} /></button>
                <div className="dropdown-content" id="myDropdown">
                    <Link to="/creator/1">My Account</Link>
                    <hr/>
                    <Link to="/logIn">Log Out</Link>
                </div>
            </div>
        </div>

        /*
        <>
            <Nav>
                <NavLogo to="/HomePage">
                    Ivanti AppMarket :P
                </NavLogo>
                <Bars />

                <NavMenu>
                    <NavLink to="/" activeStyle={{ color:'black' }}> HomePage </NavLink>
                    <NavLink to="/about"activeStyle={{ color: 'black' }}> AboutPage</NavLink>
                    <NavLink to="/contact" activeStyle={{ color: 'black' }}>ContactPage</NavLink>
                    <NavLink to="/logout" activeStyle={{ color: 'black' }}>LogOutPage</NavLink>
                    <NavLink to="/home" activeStyle={{ color: 'black' }}>HomePage</NavLink>
                    <NavLink to="/MyAppsPage/update/:Name" activeStyle={{ color: 'black' }}>Update Application</NavLink>
                    <NavLink to="/MyAppsPage/AddApp" activeStyle={{ color: 'black' }}>Add App</NavLink>
                    <NavLink to="/MyAppsPage/MyApps" activeStyle={{ color: 'black' }}>My Apps</NavLink>
                    <NavLink to="/Statistics" activeStyle={{ color: 'black' }}>Statistics</NavLink>
                    <NavLink to="/*" activeStyle={{ color: 'black' }}>LogOutPage</NavLink>

                    <NavBtn><NavBtnLink to="/LogInPage">Log In</NavBtnLink></NavBtn>

                </NavMenu>
            </Nav>
        </>
        */

    );
}


export default Navbar;