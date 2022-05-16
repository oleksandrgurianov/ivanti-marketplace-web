import React from "react";
import { Routes, Route } from "react-router-dom";

//Css
import './App.css';

//Components
import Header from './components/Header'
import Footer from './components/Footer';

//Pages
import Login from "./pages/Login"
import Logout from "./pages/Logout"
import Contact from "./pages/Contact"
import Home from "./pages/Home"
import About from "./pages/About"
import Add_Application from "./pages/Product/Add_Application";
import Update_Application from "./pages/Product/Update_Application";
import Error from './pages/Error'
import DownloadStatistics from "./pages/DownloadStatistics";
import CreatorMyApps from './pages/CreatorMyApps'
import CreatorPage from './pages/CreatorPage'

// test page 
import AppPage from "./pages/AppPage";
import AddMinorVersion from "./pages/Version/AddMinorVersion";
import AddMajorVersion from "./pages/Version/AddMajorVersion";
import UpdateVersion from "./pages/Version/UpdateVersion";

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

                <Route path="/Creator/update/:Name" element={<Update_Application />}/>
                <Route path="/Creator/AddApp/:id" element={<Add_Application/>}/>

                <Route path="/Creator/MyApps" element={<CreatorMyApps />} />
                <Route path='/creator/myapps/:id' element={<CreatorMyApps />} />

                <Route path='/creator/:id' element={<CreatorPage />} />

                <Route path="/app/:appName" element={<AppPage />} />

                <Route path='/addVersion/minor/:Name' element={<AddMinorVersion />} />
                <Route path='/addVersion/major/:Name' element={<AddMajorVersion />} />
                <Route path='/updateVersion/:Name/:version' element={<UpdateVersion />} />

                <Route path="/Logout" element={<Logout/>} />
                <Route path="/*" element={<Error />} />

                <Route path="/Statistics" element={<DownloadStatistics/>}/>

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