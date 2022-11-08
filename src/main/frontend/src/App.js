// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Login from "./Login";

function App() {
  const [hello, setHello] = useState('')


  return (
      <Login></Login>
  );
}

export default App;