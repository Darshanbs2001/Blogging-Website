import React from 'react'
import { Route,Routes } from 'react-router-dom'
import Home from '../pages/Home'
import Login from '../pages/SignIn'
import SignUp from '../pages/SignUp'
import About from '../pages/About'
const CustomRoutes = () => {
  return (
   <Routes>
    <Route path='/'>
     <Route index element={<Home/>}/>
     <Route path='login' element={<Login/>} />
     <Route path='signup' element ={<SignUp/>}/>
     <Route path="about" element={<About/>}/>
    </Route>   
    </Routes>
  )
}

export default CustomRoutes