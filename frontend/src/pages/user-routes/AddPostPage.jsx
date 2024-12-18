import Base from '../../components/Base'
import AddPost from '../../components/AddPost'
import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import { loadById } from '../../services/postService'
import { getCurrentUserDetails } from '../../services/auth'
import UserFeed from '../../components/UserFeed'

const AddPostPage = () => {
        const [loading,setloading]=useState(false);
        const [userPosts,setUserPosts]=useState(null);
        const [isUpdating,setUpdating]=useState(false);
        const [posterr,setPostError]=useState({
           errors:{},
           isError:false
  
        })
        
        const [post, setpost] = useState({
           title:'',
           content:'',
           categoryId:-1
        })
       
    function updatePost(temp){
        setUpdating(true);
        const data={
          title:temp?.title,
          content:temp?.content,
          categoryId:temp?.category?.id,
          postId:temp?.postId
        }
        setpost(data);

    }
  const loadPostById=async(id)=>{
    try{

      const {data}=await loadById(id);
      setUserPosts(data);
      console.log(data)
    }
    catch(Err){
      toast.error(Err);
    }
  }

  useEffect(()=>{
    loadPostById(getCurrentUserDetails().id);
  },[])
  return (
      <Base>
      <AddPost post={post}  loadPosts={loadPostById} setpost={setpost} posterr={posterr} setPostError={setPostError} updating={isUpdating} setUpdating={setUpdating}/>
      <UserFeed posts={userPosts} setPosts={setUserPosts} updatePost={updatePost}/>
      </Base>
  )
}

export default AddPostPage