import React from 'react'
import { Routes, Route } from 'react-router-dom'

// pages
import CreatorMyApps from './pages/CreatorMyApps'

function App() {
  return (
    <>
      <Routes>
        <Route path='/creator/myapps/:id' element={<CreatorMyApps />} />
      </Routes>
    </>
  )
}

export default App