import React from "react";
import { Routes, Route } from "react-router-dom";
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
//import Add_Application from "./Product/Add_Application";

//Css
import './App.css';


//APP STRUCTURE
function App() {
  return (
  <>
  {/*Include multiple elements with <>*/}
   <Header/>
   <Container/>
        <Routes>
           <Route path="/Login" element={<Login/>} />
           <Route path="/Logout" element={<Logout/>} />
           <Route path="/About" element={<About/>} />
           <Route path="/Contact" element={<Contact/>} />
           <Route path="/Home" element={<Home/>} />
        </Routes>

   <Footer/>
  </>
  );
}
export default App;