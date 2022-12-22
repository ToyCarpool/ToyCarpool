import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import SignUp from "./Components/SignUp";
import SignIn from './Components/SignIn';
import Home from './Components/Home';
import BoardList from './Components/BoardList';
import BoardDetail from './Components/BoardDetail';
import BoardEdit from './Components/BoardEdit';
import './App.css';


function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="SignUp" element={<SignUp/>}/>
            <Route path="SignIn" element={<SignIn/>}/>
            <Route path="Board" element={<BoardList/>}/>
            <Route path="/Board/:id" element={<BoardDetail/>}/>
            <Route path="/Board/:id/edit" element={<BoardEdit/>}/>
            <Route path="/Board/edit" element={<BoardEdit/>}/>
        </Routes>
  </BrowserRouter>
  )
}

export default App;