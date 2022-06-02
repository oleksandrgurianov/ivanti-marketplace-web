import React from 'react'
import { Link } from 'react-router-dom'

const ApplicationBasicCreator = ({ name, icon }) => {
  return (
    <Link className='application' to={`/creator/1/myApps/${name}`}>
        <img src={icon} />
        <p>{name}</p>
    </Link>
  )
}

export default ApplicationBasicCreator