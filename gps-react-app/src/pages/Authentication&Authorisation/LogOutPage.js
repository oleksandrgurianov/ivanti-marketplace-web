import React, { useEffect } from 'react'
import useAuth from '../../hooks/useAuth'
import { useNavigate } from 'react-router'

const Logout = () => {
    const { setAuth } = useAuth();
    const navigate = useNavigate();

    const handleLogout = () => {
        setAuth({})
        navigate('/login')
    }

    useEffect(() => {
        handleLogout()
    }, [])

  return (
    <div>Loggin out...</div>
  )
}

export default Logout