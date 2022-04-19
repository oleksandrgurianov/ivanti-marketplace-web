import React from 'react'
import { Routes, Route } from 'react-router-dom'
import './App.css'

// pages
import CreatorMyApps from './pages/CreatorMyApps'
import CreatorPage from './pages/CreatorPage'


function App() {
  return (
    <>
      <Routes>
        <Route path='/creator/myapps/:id' element={<CreatorMyApps />} />
        <Route path='/creator/:id' element={<CreatorPage />} />
      </Routes>
    </>
  )
}

export default App