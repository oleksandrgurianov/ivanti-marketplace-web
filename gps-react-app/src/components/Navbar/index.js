import React from 'react'
import { FaBars } from 'react-icons/fa'

const Navbar = () => {
  return (
    <>
        <nav className='navbar'>
            <a to='/' className='nav-logo'>IVANTI</a>
            <div className='responsive'>
                <FaBars />
            </div>
            <ul className='nav-menu'>
                <li className='nav-item'>Apps</li>
                <li className='nav-item'>Analytics</li>
                <li className='nav-item'>Notifications</li>
            </ul>
            <button></button>
        </nav>
    </>
  )
}

export default Navbar