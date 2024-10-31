import NavIgation from "./NavIgation"


const Base = ({title="Welecome to our Website",children}) => {
  return (
  
   <>
   <NavIgation/>
   {children}
   </>

)
}

export default Base