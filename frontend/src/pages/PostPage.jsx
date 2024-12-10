import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { toast } from 'react-toastify';
import { getPostDetails } from '../services/postService';
import Base from '../components/Base';
import { Card, CardBody, CardText, Col, Container, Row } from 'reactstrap';

function PostPage() {
    const {postId}=useParams();
    const [post, setpost] = useState(null);
    useEffect(
        ()=>{
            loadPost();

        }
        ,[])
    const loadPost=async()=>{
        try{
         const {data}=await getPostDetails(postId);
         console.log(data)
         setpost(data)
        }
        catch(Error){
            console.log(Error)
            toast.error("Something went wrong with the loading posts")
        }
    }
    const printDate=(date)=>{
        return new Date(date).toLocaleString()
    }
  return (
    <Base>
    <Container className="mt-2">
        <Link to="/user/dashboard">Home</Link>/<Link to={`/user/post/${postId}`}>post</Link>
        <Row>
            <Col md={{
                size:10,
                offset:1
            }

            }>
                <Card className='ps-2 mt-2'>
                    <CardBody>
                        <CardText className="mt-2">Posted by <b>{post?.user.name}</b> on <b>{printDate(post?.addedDate)}</b> </CardText>
                        <CardText className="text-center">
                            <h2>
                                {post?.title}

                            </h2>
                        </CardText >
                        <div className="divider"></div>
                        <CardText className="mt-3">
                        <img className="img-fluid"src={"http://localhost:8080/"+"apis/post/image/"+post?.imageName}></img>
                        </CardText>
                        <div className="mt-2" dangerouslySetInnerHTML={{__html: post?.content}}>

                        </div>
                    </CardBody>
                </Card>
            </Col>


        </Row>
    </Container>
    </Base>
  )
}

export default PostPage