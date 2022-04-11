import { Routes, Route } from "react-router-dom";
//Components
import Header from './components/Header'
import Container from './components/Container';
import Footer from './components/Footer';

//Pages
import React from "react";
import Login from "./pages/Login"
import Contact from "./pages/Contact"
import Home from "./pages/Home"
import About from "./pages/About"
import Add_Application from "./pages/Product/Add_Application"
import CreatorMyApps from './pages/CreatorMyApps'
import Error from './pages/Error'

//Css
import './App.css';
import Statistics from "./pages/Statistics";


//APP STRUCTURE
function App() {
 return (
     <>
      {/*Include multiple elements with <>*/}

      <Header/>
      <Container/>
      <Routes>
       <Route path="/Login" element={<Login/>} />
       <Route path="/About" element={<About/>} />
       <Route path="/Contact" element={<Contact/>} />
       <Route path="/" element={<Home/>} />
       <Route path="/Creator/AddApp" element={<Add_Application/>}/>
       <Route path="/Statistics" element={<Statistics/>}/>
       <Route path="/Creator/MyApps" element={<CreatorMyApps />} />
       <Route path="/*" element={<Error />} />
      </Routes>
      <Footer/>
     </>
 );
}

export default App;


