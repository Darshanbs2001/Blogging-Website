import React, { useEffect, useState } from 'react'
import { Col, Container, Row } from 'reactstrap'
import SideBar from '../../components/SideBar'
import Base from '../../components/Base'
import { useParams } from 'react-router-dom'
import { toast } from 'react-toastify'
import { loadPostByCategory } from '../../services/categoryServices'
import Post from '../../components/Post'

function CategoriesPage() {
    const { categoryId } = useParams();
    const [posts, setposts] = useState(null);
    useEffect(() => {
        loadCategoryPost(categoryId);
    }, [])
    const loadCategoryPost = async (categoryId) => {
        try {
            const {data} = await loadPostByCategory(categoryId);
            console.log(data)
            setposts(data)        
}
        catch (err) {
    console.log(err)
    toast.error("Something went wrong while fetching the posts")
}
    }
return (
    <>
        <Base>
            <Container className="mt-3">
                <Row>
                    <Col className="py-5" md={{ size: 2 }}>
                        <SideBar />
                    </Col >
                    <Col >
                        <h2>Total Blogs ( {posts?.length} )</h2>
                        { posts&&
                            posts?.map((p)=>{
                                return <Post key={p.postId} post={p}></Post>
                            })
                        }
                    </Col>

                </Row>


            </Container>

        </Base>
    </>
)
}

export default CategoriesPage