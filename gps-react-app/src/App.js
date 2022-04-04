//import Add_Application from "./Product/Add_Application";
import React from "react";
import Login from "./pages/Login"
import Contact from "./pages/contact"
import Home from "./pages/home"
import About from "./pages/about"

import { Routes, Route } from "react-router-dom";

import './App.css';

import Header from './components/Header'
import Container from './components/Container';
import Footer from './components/Footer';


//APP STRUCTURE
function App() {
  return (
  <>
  {/*Include multiple elements with <>*/}

   <Header/>
   <Container/>
   <Routes>
           <Route path="/Login" element={<Login/>} />
           <Route path="/about" element={<About/>} />
           <Route path="/contact" element={<Contact/>} />
           <Route path="/home" element={<Home/>} />
      </Routes>
   <Footer/>
  </>
  );
}

export default App;