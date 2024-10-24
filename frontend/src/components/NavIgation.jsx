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
    <header>
      <div className="nav-left">
        <h2>Blogging</h2>
        
      </div>
      <div className="nav-right">
        <div className="nav-items">
          <div className="left">
        <ul className={`${open?"links":" links active"}`}>
          <NavLink className="link" to="/">Home</NavLink>
          <NavLink className="link" to="/signup">Singup</NavLink>
        </ul>
        </div>
        <div className="right">
          <ul className={`${open?"links":"links active"}`}>

          <NavLink className="link" to="/signin">some</NavLink>
        </ul>
        </div>
        </div>
       
        <div className="icons">
          <button className={`${open?"active":"hide"}`} onClick={toggleOpen}><IoMenu className='btns .active'></IoMenu></button>
          
          <button className={`${open?"hide":"open"}`}><MdCancel className='btns' onClick={toggleOpen}></MdCancel></button>
        </div>
      </div>
    </header>
  )
}

export default NavIgation