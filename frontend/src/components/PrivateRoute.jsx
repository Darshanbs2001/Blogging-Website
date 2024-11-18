
import { Navigate, Outlet } from 'react-router-dom'
import { isLoggedin } from '../services/auth'

const PrivateRoute = () => {
  return isLoggedin()?<Outlet/>:<Navigate to="/signin"/>
}

export default PrivateRoute