//import Add_Application from "./Product/Add_Application";
import React from "react";
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
   <Routes>
        <Route path="/" element={<logIn />} />
   </Routes>
   <Container/>
   <Footer/>
  </>
  );
}

export default App;