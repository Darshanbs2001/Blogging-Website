import { ToastContainer } from "react-toastify"
import NavIgation from "./NavIgation"


const Base = (children) => {
  return (
  
   <>
   <NavIgation/>
   <ToastContainer/>

   {children}
   </>

)
}

export default Base