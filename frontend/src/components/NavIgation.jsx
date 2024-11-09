import React, { useState } from 'react'
import { IoMenu } from 'react-icons/io5'
import { MdCancel } from 'react-icons/md';
import { NavLink } from 'react-router-dom'

const NavIgation = () => {
  const [open,setOpen]=useState(false);
  const toggleOpen=()=>{
    setOpen(!open);
  }
  return (
    <header className="nav-header">
      <nav>
        <h2 className="logo">Blogging</h2>
        <div className="icons">
          <button className={`${!open?"active":"hidden"}`} onClick={toggleOpen}>
            <IoMenu></IoMenu>
          </button>
          <button className={`${open?"active":"hidden"}`} onClick={toggleOpen}>
            <MdCancel></MdCancel>
          </button>
        </div>
        <div className={`${open?"active nav-items":"hidden"}`}>
          <div className="containers">
            
            <NavLink className="nav-links" to="/">
              Home
            </NavLink>
          
            <NavLink className="nav-links" to="/signin" >Signin</NavLink>
            <NavLink className="nav-links" to="/signup" >Signup</NavLink>
          </div>
          <div className="containers">
            <NavLink className="nav-links" to="/logout" >logout</NavLink>
          </div>
        </div>
      </nav>
    </header>
  )
}

export default NavIgation