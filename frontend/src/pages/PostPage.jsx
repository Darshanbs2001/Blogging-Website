import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { toast } from 'react-toastify';
import { createComment, getPostDetails } from '../services/postService';
import Base from '../components/Base';
import { Button, Card, CardBody, CardText, Col, Container, Input, Row } from 'reactstrap';

function PostPage() {
    const { postId } = useParams();
    const [post, setpost] = useState(null);
    const [comments, setcomments] = useState([{
        content: ""
    },])
    const [comment, setcomment] = useState({
        content: ""
    })
    useEffect(
        () => {
            loadPost();

        }
        , [])
    const submitComment = async (e) => {
        //e.preventDefault();
        console.log(comment);
        if (comment.content === "") {
            return;
        }

        setcomments(
            [...comments, comment]
        )

        await createComment(post?.postId, comment);
    }
    const loadPost = async () => {
        try {
            const { data } = await getPostDetails(postId);
            console.log(data)
            setcomments(data?.comments)
            setpost(data)
        }
        catch (Error) {
            console.log(Error)
            toast.error("Something went wrong with the loading posts")
        }
    }
    const printDate = (date) => {
        return new Date(date).toLocaleString()
    }
    return (
        <Base>
            <Container className="mt-2">
                <Link to="/user/dashboard">Home</Link>/<Link to={`/user/post/${postId}`}>post</Link>
                <Row>
                    <Col md={{
                        size: 10,
                        offset: 1
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
                                    <img className="img-fluid" src={"http://localhost:8080/" + "apis/post/image/" + post?.imageName}></img>
                                </CardText>
                                <div className="mt-2" dangerouslySetInnerHTML={{ __html: post?.content }}>

                                </div>
                            </CardBody>
                        </Card>
                    </Col>


                </Row>
                <Row className='mt-4 '>
                    <Col md={{
                        size: 9,
                        offset: 2
                    }}>
                        <h3>Comments({comments?.length})</h3>
                        {
                            comments.length != 0 && comments?.map((c, index) =>
                                <Card className="mt-2" key={index}>
                                    <CardBody>
                                        <CardText>
                                            {c.content}
                                        </CardText>
                                    </CardBody>
                                </Card>
                            )




                        }
                        <Card className='my-2'>
                            <CardBody>
                                <Input type='textarea' onChange={(e) => setcomment({ content: e.target.value })} />
                                <Button color="primary mt-2"
                                    onClick={(e) => submitComment(e)}
                                >
                                    Submit
                                </Button>
                            </CardBody>
                        </Card>

                    </Col>
                </Row>
            </Container>
        </Base >
    )
}

export default PostPage