import React from "react";
import { Routes, Route } from "react-router-dom";

//CSS
import './styles/App.css';

//Components
import Header from './components/Header';
import Footer from './components/Footer';

//Pages
    //Authentication & Authorisation
    import ErrorPage from './pages/Authentication&Authorisation/ErrorPage'
    import LogInPage from "./pages/Authentication&Authorisation/LogInPage"
    import LogOutPage from "./pages/Authentication&Authorisation/LogOutPage"
    //Content Creator
    import AddApplicationPage from "./pages/ContentCreator/AddApplicationPage";
    import AddMajorVersionPage from "./pages/ContentCreator/AddMajorVersionPage";
    import AddMinorVersionPage from "./pages/ContentCreator/AddMinorVersionPage";
    import AnalyticsPage from "./pages/ContentCreator/AnalyticsPage";
    import ApplicationPage from "./pages/ContentCreator/ApplicationPage/ApplicationPage";
    import MyAppsPage from "./pages/ContentCreator/MyAppsPage/MyAppsPage";
    import UpdateApplicationPage from "./pages/ContentCreator/UpdateApplicationPage";
    import UpdateVersionPage from "./pages/Miscellaneous/UpdateVersionPage";
    import HomePage from "./pages/ContentCreator/HomePage"
    //Other
    import AboutPage from "./pages/Miscellaneous/AboutPage"
    import ContactPage from "./pages/Miscellaneous/ContactPage"

//App Structure
function App() {
    return (
        <div className="Html">
            <Header/>
            <div className="Body">
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
            </div>
            <Footer/>
        </div>
    );
}

export default App;