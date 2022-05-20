import React from 'react'
                      import { useHistory,BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
                      import {Nav, NavLogo, NavLink, Bars, NavMenu, NavBtn, NavBtnLink, TitleContainer, TitleHeading,} from "../../../styles/navElements";


                      function Navbar(){
                          return (

                              <div className="Header">
                                 <div  className="Nav">
                                     <Link className="NavLogo" to="/">
                                         <img src={"https://drive.google.com/uc?export=view?&id=1DmHraUB7mskryi5aH9hpnlDqnkHuzJI7"} height={"50px"}  alt={"ivanti logo"}/>
                                     </Link>

                                     <div className="NavMenu">

                                         <NavLink to="/creator/1/myApps" activeStyle={{ color: 'black' }}>Creator Apps</NavLink>
                                         <NavLink to="/creator/1/analytics" activeStyle={{ color: 'black' }}>Analytics</NavLink>
                                         <div className="NavBtn"><Link className="NavBtnLink" to="/logIn">Logout</Link></div>
                                     </div>
                                 </div>
                              </div>

/*//
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
                                 </> */
                          );
                          }


                      export default Navbar;

