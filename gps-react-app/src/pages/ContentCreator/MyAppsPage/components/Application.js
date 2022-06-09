import React from 'react'
import { Link } from 'react-router-dom'
import "../../../../styles/ContentCreator/MyAppsPage/components/Application.css"


const Application = ({ name, icon }) => {
  return (
      <Link className={"application"} to={`/creator/creator/myApps/${name}`}>
          <img src={icon} />
          <p>{name}</p>
      </Link>
  )
}

export default Application