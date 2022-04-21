import React from 'react'
import { Link } from 'react-router-dom'


const Application = ({ name, icon }) => {
  return (
    <>
        {/* <div className='column'>
            <div className='card'>
                <h2>{name}</h2>
                <p>{icon}</p>
            </div>
        </div> */}
        <article className='application'>
          <Link to={`/app/${name}`}>
            <img src={icon} />
          </Link>
          <p className='application-info'>{name}</p> 
        </article> 
    </>
  )
}

export default Application