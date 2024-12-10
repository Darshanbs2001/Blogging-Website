
import { Route,Routes } from 'react-router-dom'
import Home from '../pages/Home'
import Login from '../pages/SignIn'
import SignUp from '../pages/SignUp'
import About from '../pages/About'
import PrivateRoute from '../components/PrivateRoute'
import UserDashBoard from '../pages/user-routes/userDashBoard'
import AddPostPage from '../pages/user-routes/AddPostPage'
import PostPage from '../pages/PostPage'
const CustomRoutes = () => {
  return (
   <Routes>
    <Route path='/'>
     <Route index element={<Home/>}/>
     
     <Route path='signin' element={<Login/>} />

     <Route path='signup' element ={<SignUp/>}/>
     <Route path="about" element={<About/>}/>
    </Route>   
    <Route path="/user" element={<PrivateRoute/>}>
      <Route path="dashboard" element={<UserDashBoard/>}/>
      <Route path="add-post" element={<AddPostPage/>}/>
      <Route path="post/:postId" element={<PostPage/>}/>
    </Route>
    </Routes>
  )
}

export default CustomRoutes