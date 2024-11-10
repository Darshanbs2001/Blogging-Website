import './App.css'
import { BrowserRouter } from 'react-router-dom'
import CustomRoutes from './Routes/Routes'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
function App() {
 

  return (
  <div>
       <BrowserRouter>
       
    <CustomRoutes/>
   
    </BrowserRouter>
    </div>
 
    


  )
}

export default App
