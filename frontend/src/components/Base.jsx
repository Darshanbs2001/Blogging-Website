import { ToastContainer } from "react-toastify"
import NavIgation from "./NavIgation"
import { useEffect } from "react"
import { useNavigate, useNavigation } from "react-router-dom"


// eslint-disable-next-line react/prop-types
const Base = ({children}) => {
  
  return (
  
   <>
   <NavIgation/>
   <ToastContainer/>
   {children}
   </>

)
}

export default Base