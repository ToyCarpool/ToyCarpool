import React from 'react';
import {BrowserRouter, Link, Routes, Route} from "react-router-dom";
import SignUp from "./Components/SignUp";
import SignIn from './Components/SignIn';
import Home from './Components/Home';
import Board from './Components/Board';
import './App.css';


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="SignUp" element={<SignUp/>}/>
            <Route path="SignIn" element={<SignIn/>}/>
            <Route path="Board" element={<Board/>}/>
        </Routes>
  </BrowserRouter>
  )
}

export default App;