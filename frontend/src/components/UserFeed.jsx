import React from 'react'
import UserPost from './UserPost'
import { Col, Container, Row } from 'reactstrap'
import { toast } from 'react-toastify';
import { deletePost } from '../services/postService';

const UserFeed = ({posts=[],setPosts,updatePost}) => {
    async function DeleteById(id){
        try{
        console.log(id);
        const temp=await deletePost(id);
        console.log(temp);
        const data=posts.filter((post)=>post.postId!=id);
        setPosts(data);
        console.log(data);
        }
        catch(err){
            toast.error(err);
        }
    }
    
    
    return (
        <div className="container-fluid">
            <Container>
                <Row>
                    <Col>
                        <h2>Total Blogs ({posts?.length})</h2>
                        {
                            posts?.map(
                                (post) => <UserPost key={post.postId} post={post} deletePost={DeleteById} updatePost={updatePost}/>
                            )
                        }

                    </Col>

                </Row>

            </Container>
        </div>
    )
}

export default UserFeed