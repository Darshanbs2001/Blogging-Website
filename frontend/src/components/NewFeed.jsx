import  { useEffect, useState } from 'react'
import { getPosts } from '../services/postService';
import { toast } from 'react-toastify';
import { Col, Container, Row } from 'reactstrap';
import Post from './Post';

const NewFeed = () => {
    const [posts, setposts] = useState(null)
    useEffect(()=>{
        //load the post
        const loadData=async()=>{
        try{ 
        const {data}=await getPosts();
        //console.log(data)
        setposts(data);
    
        }catch(err)
        {
          console.log(err)
          toast.error(err);
        }
        
      }
      loadData();
      },[])
  return (
   <div className="container-flud">
    <Container>
        <Row>
            <Col md={
                {
                    size:10,
                    offset:1
                }
            }>
                <h1>Total Blogs ({posts?.totalElements})</h1>
                {
                posts?.content?.map(
                    (post)=><Post key={post.postId} post={post}/>
                )
            }
            </Col>
            
        </Row>
    </Container>
   </div>
  )
}

export default NewFeed