import React from 'react'

const Application = ({ name, icon }) => {

  return (
    <>
      <div className='column'>
        <div className='card'>
          <h2>{name}</h2>
          <p>icon</p>
        </div>
      </div>
    </>
  )
}

export default Application