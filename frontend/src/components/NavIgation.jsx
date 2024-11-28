import { useEffect, useState } from 'react'
import { IoMenu } from 'react-icons/io5'
import { MdCancel } from 'react-icons/md';
import { NavLink, useNavigate} from 'react-router-dom'
import { doLogout, getCurrentUserDetails, isLoggedin } from '../services/auth';

const NavIgation = () => {
  const [open, setOpen] = useState(false);
  const [login, setLogin] = useState(false);
  const [user,setUser]=useState(null);
  const navigate=useNavigate();
  useEffect(() => {
    setLogin(isLoggedin());
    setUser(getCurrentUserDetails());
    console.log(user)

  }, [])

  const toggleOpen = () => {
    setOpen(!open);
  }
  const handleLogout=()=>{
    doLogout(
      ()=>{
        console.log("user is logged out")
       

      }
      
    )
    navigate('/')
    setLogin(false);
      setUser(null);
    
  }
  return (
    <header className="nav-header px-2">
      <nav className="px-5">
        <h2 className="logo">Blogging</h2>
        <div className="icons">
          <button className={`${!open ? "active" : "hidden"}`} onClick={toggleOpen}>
            <IoMenu></IoMenu>
          </button>
          <button className={`${open ? "active" : "hidden"}`} onClick={toggleOpen}>
            <MdCancel></MdCancel>
          </button>
        </div>
        <div className={`${open ? "active nav-items" : "hidden"}`}>
          <div className="containers">
            {login&&

            <NavLink className="nav-links" to="/">
              New Feed
            </NavLink>
}



          </div>
          <div className="containers">
            {
              login ? (
                <>
                <NavLink className="nav-links " to='/profile'>Profile</NavLink>
                <NavLink className="nav-links" to="/user/add-post">{user.email}</NavLink>
                <div className="nav-links" onClick={handleLogout} >logout</div>

                </>
              ) : (
                <>             
                 <NavLink className="nav-links" to="/signin" >Signin</NavLink>
                 <NavLink className="nav-links" to="/signup" >Signup</NavLink>
                </>

              )
            }

          </div>
        </div>
      </nav>
    </header>
  )
}

export default NavIgation