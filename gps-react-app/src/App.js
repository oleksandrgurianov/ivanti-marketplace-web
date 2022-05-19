import React from "react";
import { Routes, Route } from "react-router-dom";

//Css
import './styles/App.css';

//Components
import Header from './components/Header'
import Footer from './components/Footer';

//Pages
    //analytics
import DownloadStatistics from "./pages/Creator/Analytics/DownloadStatistics"
    //apps
import Application from "./pages/AppCatalogue/Application";
import ApplicationList from "./pages/AppCatalogue/ApplicationList";
    //creator
import CreatorPage from "./pages/Creator/CreatorPage";
    //customer
    //login
import Login from "./pages/Login/Login"
import Logout from "./pages/Login/Logout"
    //miscelaneous
import Error from './pages/Misc/Error'
import Contact from "./pages/Misc/Contact"
import Home from "./pages/Login/Home"
import About from "./pages/Misc/About"
    //product
import AddApplication from "./pages/Creator/AppManagement/AddApplication";
import UpdateApplication from "./pages/Creator/AppManagement/UpdateApplication";
import GetApp from "./pages/Creator/AppManagement/GetApp";
import ViewAppDefault from "./pages/Creator/AppManagement/ViewAppDefault";
    //review
import Rating from "./pages/Review/Rating";
    //version
import AddMajorVersion from "./pages/Creator/Version/AddMajorVersion";
import AddMinorVersion from "./pages/Creator/Version/AddMinorVersion";
import UpdateVersion from "./pages/Creator/Version/UpdateVersion";
import AppDetails from "./pages/AppCatalogue";


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
                <Route path="/" element={<Home/>} />
                <Route path="/Login" element={<Login/>} />
                <Route path="/About" element={<About/>} />
                <Route path="/Contact" element={<Contact/>} />
                <Route path="/CreatorPage/update/:Name" element={<UpdateApplication />}/>
                <Route path="/CreatorPage/AddApp/:id" element={<AddApplication/>}/>


                <Route path="/CreatorPage/MyApps" element={<ApplicationList/>} />
                <Route path='/creator/myapps/:id' element={<ApplicationList/>} />
                <Route path="/app/:appName" element={<AppDetails />} />


                <Route path='/creator/:id' element={<CreatorPage />} />

                <Route path='/addVersion/minor/:Name' element={<AddMinorVersion />} />
                <Route path='/addVersion/major/:Name' element={<AddMajorVersion />} />
                <Route path='/updateVersion/:Name/:version' element={<UpdateVersion />} />

                <Route path="/Logout" element={<Logout/>} />
                <Route path="/*" element={<Error />} />

                <Route path="/Creator/Statistics" element={<DownloadStatistics/>}/>

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