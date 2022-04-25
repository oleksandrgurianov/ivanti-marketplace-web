import React from 'react'
                      import { useHistory,BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
                      import { Nav, NavLogo, NavLink, Bars, NavMenu, NavBtn, NavBtnLink,} from "./navElements";

                      function Navbar(){
                          return (
    //IF CUSTOMER IS LOGED IN:
                              <div className="Header">
                                 <div  className="Nav">
                                     <Link className="NavLogo" to="/">
                                         <img src={"https://drive.google.com/uc?export=view?&id=1DmHraUB7mskryi5aH9hpnlDqnkHuzJI7"} height={"50px"}  alt={"ivanti logo"}/>
                                     </Link>

                                     <div className="NavMenu">
                                         <NavLink to="/creator/1" activeStyle={{ color: 'black' }}>My Apps</NavLink>
                                         <NavLink to="/Statistics" activeStyle={{ color: 'black' }}>Analytics</NavLink>
                                         <div className="NavBtn"><Link className="NavBtnLink" to="/Login">Logout</Link></div>
                                     </div>
                                 </div>
                              </div>

                              /*//IF CREATOR IS LOGGED IN
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
                                         <NavLink to="/home" activeStyle={{ color: 'black' }}>Home</NavLink>
                                         <NavLink to="/Creator/update/:Name" activeStyle={{ color: 'black' }}>Update Application</NavLink>
                                         <NavLink to="/Creator/AddApp" activeStyle={{ color: 'black' }}>Add App</NavLink>
                                         <NavLink to="/Creator/MyApps" activeStyle={{ color: 'black' }}>My Apps</NavLink>
                                         <NavLink to="/Statistics" activeStyle={{ color: 'black' }}>Statistics</NavLink>
                                         <NavLink to="/*" activeStyle={{ color: 'black' }}>Logout</NavLink>


                                         <NavLink to="/contact" activeStyle={{ color: 'black' }}>Contact</NavLink>
                                         <NavLink to="/about"activeStyle={{ color: 'black' }}> About</NavLink>
                                         <NavLink to="/logout" activeStyle={{ color: 'black' }}>Logout</NavLink>


                                         <NavBtn><NavBtnLink to="/Login">Log In</NavBtnLink></NavBtn>

                                     </NavMenu>
                                    </Nav>
                                 </> */
                          );
                          }


                      export default Navbar;

