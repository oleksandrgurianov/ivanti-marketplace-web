import React from 'react'
import { Link } from 'react-router-dom'


const Application = ({ name, icon }) => {
  return (
    <>
        <article className='application'>
          <Link to={`/creator/1/myApps/${name}`}>
            <img height={"50"} src={icon} />
          </Link>
          <p className='application-info'>{name}</p> 
        </article> 
    </>
  )
}
export default Application