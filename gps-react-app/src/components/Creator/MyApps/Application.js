import React from 'react'
import { Link } from 'react-router-dom'
import Icon1 from '../../../Images/Icon1.png'
import icon2 from '../../../Images/Icon2.png'
import icon3 from '../../../Images/Icon3.png'

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
          <img src={icon} />
          <p className='application-info'>{name}</p> 
        </article> 
    </>
  )
}

export default Application