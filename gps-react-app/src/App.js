import React, {useEffect, useState} from "react";
import { Routes, Route } from "react-router-dom";


//CSS
import './styles/App.css';

//Components
import Navbar from './components/Header';
import Footer from './components/Footer';
import RequireAuth from './components/RequireAuth';

//Pages
import HomePage from "./pages/PublicRoutes/HomePage";
import AllApplicationsPage from "./pages/PublicRoutes/AllApplicationsPage";
import AboutPage from "./pages/PublicRoutes/AboutPage";
import ContactPage from "./pages/PublicRoutes/ContactPage";
import LoginPage from "./pages/Authentication&Authorisation/LogInPage";
import LogOutPage from "./pages/Authentication&Authorisation/LogOutPage";
import ErrorPage from "./pages/Authentication&Authorisation/ErrorPage";
import MyAppsPage from "./pages/ContentCreator/MyAppsPage/MyAppsPage";
import DetailedApplicationPage from "./pages/PublicRoutes/DetailedApplication";
import AddApplicationPage from "./pages/ContentCreator/AddApplicationPage";

//App Structure
function App() {

    return (
        <div className="Html">
            <Navbar/>
            
            <Routes>
                <Route path="/" element={<HomePage />} />

                {/* public routes */}
                <Route path="/all-apps"  element={<AllApplicationsPage />} />
                <Route path="/app/:name" element={<DetailedApplicationPage />} />
                <Route path="/about" element={<AboutPage />} />
                <Route path="/contact" element={<ContactPage />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/logout" element={<LogOutPage />} />

                {/* creator */}
                <Route element={<RequireAuth allowedRoles={["Creator"]} />}>
                    {/* applications */}
                    <Route path="/creator/my-apps" element={<MyAppsPage />} />
                    <Route path="/creator/app/:name" element={<DetailedApplicationPage />} />

                    {/* application actions */}
                    <Route path="/creator/add-app" element={<AddApplicationPage />} />
                </Route>

                {/* customer */}
                <Route element={<RequireAuth allowedRoles={["Customer"]} />}>

                </Route>
                
                {/* error */}
                <Route path="/*" element={<ErrorPage />} />
            </Routes>

            <Footer/>
        </div>
    );
}

export default App;

{/* <Routes>

                            <Route path="/creator/:id/myApps/:name/updateApplication" element={<UpdateApplicationPage />}/>
                            <Route path="/creator/:id/myApps/addApplication" element={<AddApplicationPage/>}/>
                            <Route path="/creator/:id/myApps/:name" element={<ApplicationPage />} />
                            <Route path="/my-account/:username" element={<MyAppsPage />}/>
                            <Route path="/creator/:id/myApps/:appName/updateApplication" element={<UpdateApplicationPage />}/>
                            <Route path="/creator/:id/myApps/addApplication" element={<AddApplicationPage/>}/>
                            <Route path="/creator/:id/myApps/:appName" element={<ApplicationPage />} />
                            <Route path='/creator/:id/myApps/:name/addMinorVersion' element={<AddMinorVersionPage />} />
                            <Route path='/creator/:id/myApps/:name/addMajorVersion' element={<AddMajorVersionPage />} />

                            <Route path="/creator/myApps/:name" element={<ApplicationPage />} />

                            <Route path="/creator/analytics" element={<AnalyticsPage/>}/>
                        </Routes> */}