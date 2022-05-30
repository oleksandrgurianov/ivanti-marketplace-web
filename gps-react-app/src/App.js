import React, {useEffect, useState} from "react";
import { Routes, Route } from "react-router-dom";

//CSS
import './styles/App.css';

//Components
import Header from './components/Header';
import Footer from './components/Footer';


//App Structure
function App() {


    return (
        <div className="Html">
            <Header/>

            <Footer/>
        </div>
    );
}

export default App;