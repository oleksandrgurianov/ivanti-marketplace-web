import React from 'react'
                      import { useHistory,BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
                      import { Nav, NavLogo, NavLink, Bars, NavMenu, NavBtn, NavBtnLink,} from "./navElements";

                      function Navbar(){

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