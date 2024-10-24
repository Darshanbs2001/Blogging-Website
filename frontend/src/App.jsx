import './App.css'
import { BrowserRouter, Route,  } from 'react-router-dom'
import Home from './pages/Home'
import SignIn from './pages/SignIn'
import Routes from './Routes/Routes'
import SignUp from './pages/SignUp'
import CustomRoutes from './Routes/Routes'
import 'bootstrap/dist/css/bootstrap.min.css';
import Example from './components/NavIgation'
function App() {
 

  return (<>
    <BrowserRouter>
    
    <CustomRoutes/>
    </BrowserRouter>
    
    </>


  )
}

export default App
