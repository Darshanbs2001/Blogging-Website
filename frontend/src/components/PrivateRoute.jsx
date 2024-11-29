
import { Navigate, Outlet, useNavigate } from 'react-router-dom'
import { doLogout, isLoggedin } from '../services/auth'
import { useEffect } from 'react';
import { privateAxios } from '../services/myAxios';

const PrivateRoute = () => {
//   const navigate=useNavigate();
//   useEffect(()=>{
//    const verfiyUser=async()=>{
//      try{
//      const data=await privateAxios.get('/apis/check');
//      console.log(data)
//      }
//      catch(err){
//        if(err.status==403){
//          doLogout((err)=>console.log(err));
//          navigate('/signin')
//        }
//      }
//    }
//  verfiyUser()
//   }
//  ,[] )
  return isLoggedin()?<Outlet/>:<Navigate to="/signin"/>
}

export default PrivateRoute