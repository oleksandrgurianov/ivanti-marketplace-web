// import React, {useEffect, useState} from 'react'
// import {Link, Route, Routes} from "react-router-dom";
// import logo from "../images/ivanti-marketplace-logo.png";
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faGlobe, faCaretDown } from '@fortawesome/free-solid-svg-icons'

// import axios from "axios";
// import AnalyticsPage from '../pages/ContentCreator/AnalyticsPage/AnalyticsPage';
// import Translate from './Translate';


// function Navbar() {
//     function showContent() {
//         document.getElementById("myDropdown").classList.toggle("show");
//     }

//     window.onclick = function(e) {
//         if (!e.target.matches('.dropdown-button')) {
//             let myDropdown = document.getElementById("myDropdown");

//             if (myDropdown != null) {
//                 if (myDropdown.classList.contains('show')) {
//                     myDropdown.classList.remove('show');
//                 }
//             }
//         }
//     }

//     const [authorization, setAuthorization] = useState("");
//     const [username, setUsername] = useState("");
//     const login = (username, password) => {
//         axios.post(`http://localhost:8080/login`,{
//             "username":username,
//             "password":password
//         })
//             .then(res => {
//                 localStorage.setItem("token", res.data.accessToken);
//                 localStorage.setItem("authorization", res.data.permission);
//                 localStorage.setItem('username', username);
//                 setAuthorization(res.data.permission);
//                 setUsername(res.data.username)
//                 console.log(authorization)

//             })
//             .catch(err => {});
//     }
//     const logout =()=>{
//         localStorage.removeItem("token");
//         setAuthorization("");
//     }

//     return(
//         <>
//             {(authorization === "Customer")?(
//                 <>
//                     <div className="Nav">
//                         <Link className="NavLogo" to="/">
//                             <img src={logo} height={"38px"} alt={"ivanti marketplace logo"}/>
//                         </Link>
//                         <Link className='NavLink' to="/all-apps">Apps</Link>
//                         <Link className='NavLink' to="/*">My Downloads</Link>
//                         <Translate/>
//                         <div className="NavDropdown">
//                             <button className="dropdown-button" onClick={showContent}>{localStorage.getItem("username")}<FontAwesomeIcon className="NavIcon" icon={faCaretDown} /></button>
//                             <div className="dropdown-content" id="myDropdown">
//                                 <Link to="/customer/1">My Account</Link>
//                                 <hr/>
//                                 <Link to="/" onClick={logout}>Logout</Link>
//                             </div>
//                         </div>
//                     </div>

//                     <div className="Body">
//                         <Routes>
//                             <Route path="/" element={<HomePage/>} />
//                             <Route path="/about" element={<AboutPage/>} />
//                             <Route path="/contact" element={<ContactPage/>} />
//                             <Route path='/all-apps' element={<AllApplicationsPage />} />
//                             <Route path='/app/:name' element={<ApplicationDetailedPage />} />
//                             <Route path="/logout" element={<LogOutPage logout={logout}/>} />
//                             <Route path="/login" element={<LogInPage login={login}/>} />
//                             <Route path="/*" element={<ErrorPage />} />
//                         </Routes>
//                     </div>
//                 </>
//             ):(authorization === "Creator")?(
//                 <>
//                     <div className="Nav">
//                         <Link className="NavLogo" to="/">
//                             <img src={logo} height={"38px"} alt={"ivanti marketplace logo"}/>
//                         </Link>
//                         <Link className='NavLink' to="/all-apps">Apps</Link>
//                         <Link className="NavLink" to="/creator/analytics">Analytics</Link>
//                         <Link className="NavLink" to="/*">Notifications</Link>
//                         <Link className="NavLink" to="/my-account/creator">My Apps</Link>
//                         <Translate/>
//                         <div className="NavDropdown">
//                             <button className="dropdown-button" onClick={showContent}>{localStorage.getItem("username")}<FontAwesomeIcon className="NavIcon" icon={faCaretDown} /></button>
//                             <div className="dropdown-content" id="myDropdown">
//                                 <Link to="/creator/1">My Account</Link>
//                                 <hr/>
//                                 <Link to="/" onClick={logout}>Logout</Link>
//                             </div>
//                         </div>
//                     </div>

//                     <div className="Body">
//                         <Routes>
//                             <Route path="/" element={<HomePage/>} />
//                             <Route path="/about" element={<AboutPage/>} />
//                             <Route path="/contact" element={<ContactPage/>} />
//                             <Route path="/creator/:id/myApps/:name/updateApplication" element={<UpdateApplicationPage />}/>
//                             <Route path="/creator/:id/myApps/addApplication" element={<AddApplicationPage/>}/>
//                             <Route path="/creator/:id/myApps/:name" element={<ApplicationPage />} />
//                             <Route path='/app/:name' element={<ApplicationDetailedPage />} />
//                             <Route path='/all-apps' element={<AllApplicationsPage />} />
//                             <Route path='/app/:name' element={<ApplicationDetailedPage />} />
//                             <Route path="/my-account/:username" element={<MyAppsPage />}/>
//                             <Route path="/creator/:id/myApps/:appName/updateApplication" element={<UpdateApplicationPage />}/>
//                             <Route path="/creator/:id/myApps/addApplication" element={<AddApplicationPage/>}/>
//                             <Route path="/creator/:id/myApps/:appName" element={<ApplicationPage />} />
//                             <Route path='/creator/:id/myApps/:name/addMinorVersion' element={<AddMinorVersionPage />} />
//                             <Route path='/creator/:id/myApps/:name/addMajorVersion' element={<AddMajorVersionPage />} />
//                             <Route path="/login" element={<LogInPage login={login}/>} />
//                             <Route path="/*" element={<ErrorPage />} />
//                             <Route path="/creator/myApps/:name" element={<ApplicationPage />} />
//                             <Route path="/creator/analytics" element={<AnalyticsPage/>}/>
//                         </Routes>
//                     </div>
//                 </>
//             ):(
//                 <>
//                     <div className="Nav">
//                         <Link className="NavLogo" to="/">
//                             <img src={logo} height={"38px"} alt={"ivanti marketplace logo"}/>
//                         </Link>
//                         <Link className='NavLink' to="/all-apps">Apps</Link>
//                         <Translate/>
//                         <Link className="NavLinkLogin" to="/login">Login</Link>
//                     </div>

//                     <div className="Body">
//                         <Routes>
//                             <Route path="/" element={<HomePage/>} />
//                             <Route path="/about" element={<AboutPage/>} />
//                             <Route path="/contact" element={<ContactPage/>} />
//                             <Route path='/all-apps' element={<AllApplicationsPage />} />
//                             <Route path='/app/:name' element={<ApplicationDetailedPage />} />
//                             <Route path="/login" element={<LogInPage login={login}/>} />
//                             <Route path="/*" element={<ErrorPage />} />
//                         </Routes>
//                     </div>
//                 </>
//             )}
//         </>
//     );
// }


// export default Navbar;

import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import useAuth from '../hooks/useAuth'
import logo from "../images/ivanti-marketplace-logo.png";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faGlobe, faCaretDown } from '@fortawesome/free-solid-svg-icons'
import Translate from './Translate'; 

function Navbar() {

    const { auth } = useAuth();
    const [isCreator, setIsCreator] = useState(false)

    const checkRoleStatus = () => {
        auth?.roles?.map((role) => {
            if (role === "Creator") {
                setIsCreator(true)
            }
        })
    }

    useEffect(() => {
        checkRoleStatus()
    }, [auth])

    function showContent() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    window.onclick = function(e) {
        if (!e.target.matches('.dropdown-button')) {
            let myDropdown = document.getElementById("myDropdown");

            if (myDropdown !== null) {
                if (myDropdown.classList.contains('show')) {
                    myDropdown.classList.remove('show');
                }
            }
        }
    }

    

  return (
    <>
        <div className='Nav'>
            <Link className='NavLogo' to={'/'}>
                <img src={logo} height={'38px'} alt={"ivanti marketplace logo"} />
            </Link>
            <Link className='NavLink' to={'/all-apps'}>Apps</Link>

            { isCreator ? (
                <>
                    {auth?.decoded && <Link className='NavLink' to={'/creator/analytics'}>Analytics</Link>}
                    {auth?.decoded && <Link className='NavLink' to={'/*'}>Notifications</Link>}
                    {auth?.decoded && <Link className='NavLink' to={'/creator/my-apps'}>My Apps</Link>}
                </>
            ) : (
                <>
                    {auth?.decoded && <Link className='NavLink' to={'/*'}>My Downloads</Link> }
                </>
            )}
            
            <Translate />
            {auth?.decoded &&
                <div className='NavDropdown'>
                    <button className='dropdown-button' onClick={showContent}>{auth?.decoded.sub}<FontAwesomeIcon className='NavIcon' icon={faCaretDown} /></button>
                    <div className='dropdown-content'>
                        { isCreator ? (
                            <>
                                <Link to={'/creator/my-apps'}>My Account</Link>
                            </>
                        ) : (
                            <>
                                <Link to={'/*'}>My Account</Link>
                            </>
                        )}
                        <hr />
                        <Link to={'/logout'}>Logout</Link>
                    </div>
                </ div>
            }
            {!auth?.decoded && <Link className='NavLinkLogin' to={'/login'}>Login</Link>}
        </div>
    </>
  )
}

export default Navbar