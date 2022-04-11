import React from 'react'
                      import { useHistory,BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
                      import { Nav, NavLogo, NavLink, Bars, NavMenu, NavBtn, NavBtnLink,} from "./navElements";

                      function Navbar(){

<<<<<<< HEAD
                          return (
                              <>
                                 <Nav>
                                  <NavLogo to="/Home">
                                      Ivanti AppMarket :P
                                  </NavLogo>
                                  <Bars />

                                  <NavMenu>
                                      <NavLink to="/" activeStyle={{ color:'black' }}> Home </NavLink>
                                      <NavLink to="/about"activeStyle={{ color: 'black' }}> About</NavLink>
                                      <NavLink to="/contact" activeStyle={{ color: 'black' }}>Contact</NavLink>
                                      <NavLink to="/logout" activeStyle={{ color: 'black' }}>Logout</NavLink>
                                      <NavBtn><NavBtnLink to="/Login">Log In</NavBtnLink></NavBtn>
                                  </NavMenu>
                                 </Nav>
                              </>
                          );
                      };
                      export default Navbar;
=======
    return (
        <>
           <Nav>
            <NavLogo to="/">
                Ivanti AppMarket :P
            </NavLogo>
            <Bars />

            <NavMenu>
                <NavLink to="/" activeStyle={{ color:'black' }}> Home </NavLink>
                <NavLink to="/statistics" activeStyle={{ color:'black' }}> Statistics </NavLink>
                <NavLink to="/about"activeStyle={{ color: 'black' }}> About</NavLink>
                <NavLink to="/contact" activeStyle={{ color: 'black' }}>Contact</NavLink>
                <NavLink to="/Login"activeStyle={{ color: 'black' }}>Log In</NavLink>

                <NavBtn><NavBtnLink to="/Login">Log In</NavBtnLink></NavBtn>
            </NavMenu>
           </Nav>
        </>
    );

};
export default Navbar;
>>>>>>> 817cd64131b25c6084116f86022aef786fef3539
