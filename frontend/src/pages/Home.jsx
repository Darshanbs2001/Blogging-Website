import React, { useEffect } from 'react'
import Navigation from '../components/NavIgation'
import Example from '../components/NavIgation'
import { useNavigate, useNavigation } from 'react-router-dom'
import { isLoggedin } from '../services/auth'

const Home = () => {
  const navigate=useNavigate();

  useEffect(() => {
    if(!isLoggedin()){
      navigate('/signin');
    }
  }, [])
  
 
  return (
    <div>
      <Navigation/>
    </div>
  )
}

export default Home