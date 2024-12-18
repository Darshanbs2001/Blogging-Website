import React from 'react'
import { Link } from 'react-router-dom'
import { Button, Card, CardBody, CardText } from 'reactstrap'

const UserPost = ({post,deletePost,updatePost}) => {
    
    return (
        <Card className="m-1 shadow-sm">
            <CardBody className='text-start'>
                <h1>{post?.title}</h1>

                <CardText dangerouslySetInnerHTML={{ __html: post?.content.substring(0, 100) + "..." }}>


                </CardText>
                {//post?.content
                }

                <div>
                    <Link className="btn btn-secondary" to={"/user/post/" + post?.postId}>
                        Read More..
                    </Link>
                    <Button color='warning' className='m-2' onClick={()=>deletePost(post?.postId)}>Delete</Button>
                    <Button color='info' className='m-2' onClick={()=>updatePost(post)}>Update</Button>

                </div>
            </CardBody>

        </Card>
    )
}

export default UserPost