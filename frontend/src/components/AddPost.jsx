import { useEffect, useRef, useState } from 'react'
import { Button, Card, CardBody, Container, Input, Label } from 'reactstrap'
import { fetchCategories } from '../services/categoryServices'
import { toast } from 'react-toastify'
import JoditEditor from 'jodit-react'
import { doLogout } from '../services/auth'
import { createPost } from '../services/postService'
import { privateAxios } from '../services/myAxios'
import { Navigate, useNavigate } from 'react-router-dom'

const AddPost= () => {
      const [category, setCategory] = useState([]);
      const editor = useRef(null);
      const navigate=useNavigate();
       
      const [posterr,setPostError]=useState({
         errors:{},
         isError:false

      })
      
      const [post, setpost] = useState({
         title:'',
         content:'',
         categoryId:-1
      })
      const contentChange=(e)=>
      {
         console.log(e)
         setpost({
            ...post,
            content:e
         })
      }
      const fieldChange=(e)=>{
       
         setpost((
            prev
         )=>{
            const newObj={
               ...prev,
               [e.target.name]:e.target.value
            }
            return newObj;
         }
         )
        
      }

      const handleReset=()=>{
         setpost({
            title:'',
            content:'',
            categoryId:-1
         })
      }
      useEffect(() => {
         const run = async () => {
            try {
               const { data } = await fetchCategories();
               console.log(data);
               setCategory(data);
            }
            catch (err) {
               if(err.status==403){
                  doLogout(()=>console.log("token expired"));
                  navigate('/signin');
               }
               setPostError(err);
               
               toast.error(err);
            }
         }
         run()

      }, [])
      let onSubmit=async (e)=>{
         e.preventDefault();
         if(post.categoryId===-1){
            alert("Please select a category")
         }
         if(post.title.trim()===''){
            alert("Please enter a title for the post")
         }
         if(post.content.trim()===''){
            alert("please enter content")
         }
         //post the data
         try{
            const data=await createPost(post);
            console.log(data) 
            toast.success("The post added successfully")
         }
         catch(err){
            console.log(err)

         }


      }

      return (
         <div className='wrapper'>
            <Container className='mt-2'>
               <Card className='shadow'>
                  <CardBody>
                     <div >
                        <Label for='title'>Post title</Label>
                        <Input type='text' id='title' name="title"
                        onChange={(e)=>fieldChange(e)}
                        value={post.title}
                        ></Input>
                     </div>
                     <div>
                        <Label for='content'>Post content</Label>
                        <JoditEditor
                           ref={editor}
                           value={post.content}
                           name="content"
                           tabIndex={1} // tabIndex of textarea
                           //onBlur={(e)=>fieldChange(e)}
                           onChange={(e)=>contentChange(e)}
                           style={{height:'700px'}}
                        />
                     </div>
                     <div>
                        <Label for='category'>Post category</Label>
                        <Input type='select' id='category' name="categoryId" 
                        value={post.categoryId}
                        defaultValue={-1}
                        onChange={(e)=>fieldChange(e)}>
                           
                              <option disabled value={-1} >--Select Category--</option>
                           {
                              category.map(
                                 (c) => <option key={c.id} value={c.id}>{c.categoryTitle}</option>
                              )
                           }
                        </Input>
                     </div>
                     <Container className='text-center mt-2'>
                        <Button color='primary' className='rounded-0' onClick={onSubmit}>Add Post</Button>
                        <Button color='danger' className='ms-2 rounded-0' onClick={handleReset}>Reset</Button>

                     </Container>
                  </CardBody>
               </Card>
            </Container>


         </div>
      )
   }



export default AddPost;