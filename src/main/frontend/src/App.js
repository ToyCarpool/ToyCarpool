import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import SignUp from "./Components/SignUp";
import SignIn from './Components/SignIn';
import Home from './Components/Home';
import Board from './Components/Board';
import BoardDetail from './Components/BoardDetail';
import './App.css';


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="SignUp" element={<SignUp/>}/>
            <Route path="SignIn" element={<SignIn/>}/>
            <Route path="Board" element={<Board/>}/>
            <Route path="/Board/:id" element={<BoardDetail/>}/> 
        </Routes>
  </BrowserRouter>
  )
}

export default App;