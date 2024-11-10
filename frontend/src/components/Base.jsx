import { ToastContainer } from "react-toastify"
import NavIgation from "./NavIgation"


const Base = ({title="Welecome to our Website",children}) => {
  return (
  
   <>
   <NavIgation/>
   <ToastContainer/>

   {children}
   </>

)
}

export default Base