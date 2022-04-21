import React from "react";
import { Routes, Route } from "react-router-dom";

//Css
import './App.css';

//Components
import Header from './components/Header'
import Container from './components/Container';
import Footer from './components/Footer';

//Pages
import Login from "./pages/Login"
import Logout from "./pages/Logout"
import Contact from "./pages/Contact"
import Home from "./pages/Home"
import About from "./pages/About"
import Add_Application from "./pages/Product/Add_Application";
import Update_Application from "./pages/Product/Update_Application";
import MyApps from './pages/Creator/MyApps'
import Error from './pages/Error'
import DownloadStatistics from "./pages/DownloadStatistics";
import Rating from "./pages/Rating";
import CreatorMyApps from './pages/CreatorMyApps'
import CreatorPage from './pages/CreatorPage'



//APP STRUCTURE
function App() {
  return (
        <>
            {/*Include multiple elements with <>*/}
            <Header/>

            <br/>
            <br/>
            <br/>
            <br/>

            <Container/>
            <Routes>
                <Route path="/Login" element={<Login/>} />
                <Route path="/About" element={<About/>} />
                <Route path="/Contact" element={<Contact/>} />
                <Route path="/Home" element={<Home/>} />
                <Route path="/Creator/update/:Name" element={<Update_Application />}/>
                <Route path="/Creator/AddApp" element={<Add_Application/>}/>
                {/* <Route path="/Creator/MyApps" element={<CreatorMyApps />} />
                <Route path='/creator/myapps/:id' element={<CreatorMyApps />} /> */}
                <Route path='/creator/:id' element={<CreatorPage />} />

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
            <br/>
            <br/>

            <Footer/>
        </>
    );
}

export default App;