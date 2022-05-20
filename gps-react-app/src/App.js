import React from "react";
import { Routes, Route } from "react-router-dom";

//Css
import './styles/App.css';

//Components
import Header from './components/Header/Header'
import Footer from './components/Footer/Footer';

//Pages
    //analytics
import AnalyticsPage from "./pages/ContentCreator/Analytics/AnalyticsPage"
    //apps
import Application from "./pages/ContentCreator/MyApps/components/Application";
import ApplicationList from "./pages/ContentCreator/MyApps/components/ApplicationList";
    //creator
import MyAppsPage from "./pages/ContentCreator/MyApps/MyAppsPage";
    //customer
    //login
import LogInPage from "./pages/Authentication&Authorisation/LogIn/LogInPage"
import LogOutPage from "./pages/Authentication&Authorisation/LogOut/LogOutPage"
    //miscelaneous
import ErrorPage from './pages/Authentication&Authorisation/Error/ErrorPage'
import ContactPage from "./pages/Other/ContactPage"
import HomePage from "./pages/ContentCreator/HomePage"
import AboutPage from "./pages/Other/AboutPage"
    //product
import AddApplicationPage from "./pages/ContentCreator/AddApplication/AddApplicationPage";
import UpdateApplicationPage from "./pages/ContentCreator/UpdateApplication/UpdateApplicationPage";
import GetApp from "./pages/Miscellaneous/GetApplication";
import ApplicationPreview from "./pages/ContentCreator/MyApps/components/ApplicationPreview";
    //review
import Rating from "./pages/ContentCreator/Application/components/Rating/Rating";
    //version
import AddMajorVersionPage from "./pages/ContentCreator/AddMajorVersion/AddMajorVersionPage";
import AddMinorVersionPage from "./pages/ContentCreator/AddMinorVersion/AddMinorVersionPage";
import UpdateVersionPage from "./pages/ContentCreator/UpdateVersion/UpdateVersionPage";
import ApplicationPage from "./pages/ContentCreator/Application/ApplicationPage";


//APP STRUCTURE
function App() {
  return (
        <div>
            {/*Include multiple elements with <>*/}
            <Header/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <Routes>
                <Route path="/" element={<HomePage/>} />
                <Route path="/logIn" element={<LogInPage/>} />
                <Route path="/about" element={<AboutPage/>} />
                <Route path="/contact" element={<ContactPage/>} />
                <Route path="/creator/:id/myApps/:name/updateApplication" element={<UpdateApplicationPage />}/>
                <Route path="/creator/:id/myApps/addApplication" element={<AddApplicationPage/>}/>
                <Route path="/creator/:id/myApps/:name" element={<ApplicationPage />} />
                <Route path='/creator/:id/myApps' element={<MyAppsPage />} />
                <Route path='/creator/:id/myApps/:name/addMinorVersion' element={<AddMinorVersionPage />} />
                <Route path='/creator/:id/myApps/:name/addMajorVersion' element={<AddMajorVersionPage />} />
                <Route path='/creator/:id/myApps/:name/updateVersion/:version' element={<UpdateVersionPage />} />
                <Route path="/logOut" element={<LogOutPage/>} />
                <Route path="/*" element={<ErrorPage />} />
                <Route path="/creator/:id/analytics" element={<AnalyticsPage/>}/>

            </Routes>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <Footer/>
        </div>
    );
}

export default App;