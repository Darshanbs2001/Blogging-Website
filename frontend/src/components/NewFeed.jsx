import { useEffect, useState } from 'react'
import { getPosts } from '../services/postService';
import { toast } from 'react-toastify';
import { Col, Container, Pagination, PaginationItem, PaginationLink, Row } from 'reactstrap';
import Post from './Post';

const NewFeed = () => {
  const [posts, setposts] = useState(null)
  const [loading, setloading] = useState(false)
  useEffect(() => {
    changePost(0, 5);
  }, [])
  const changePost = async (pageNumber, NumberOfPosts = 5) => {
    try {
      //console.log(pageNumber);
      setloading(true);
      const { data } = await getPosts(pageNumber, NumberOfPosts);
      setposts(data);
      console.log(posts)
      window.scroll(0, 0)


    }
    catch (err) {

      toast.error("Something went with post fetching")
    }
    finally {
      setloading(false);
    }

  }
  function generatePageNumbers(pages) {
    let a = []
    for (let i = 0; i < pages; i++) {
      a.push(i + 1);
    }
    return a;
  }
  return (

    <div className="container-fluid">
      <Container>
        <Row>
          <Col>
            <h2>Total Blogs ({posts?.totalElements})</h2>
            {
              posts?.content?.map(
                (post) => <Post key={post.postId} post={post} />
              )
            }
            <Container className='py-3'>
              <Pagination
                aria-label="Page navigation example"
                size="md"
              >


                <PaginationItem disabled={posts?.pageNumber == 0} onClick={() => {
                  posts?.pageNumber == 0 ? null : changePost(posts?.pageNumber - 1);
                }}>
                  <PaginationLink
                    href="#"
                    previous

                  >
                    Previous
                  </PaginationLink>
                </PaginationItem>
                {
                  generatePageNumbers(posts?.totalPages).map((i) => {
                    return <PaginationItem key={i} onClick={() => { changePost(i - 1) }} active={posts.pageNumber == i - 1}>
                      <PaginationLink>
                        {i}
                      </PaginationLink>
                    </PaginationItem>
                  }
                  )
                }
                <PaginationItem disabled={posts?.lastPage} onClick={() => {
                  posts?.lastPage ? null : changePost(posts?.pageNumber + 1);
                }}>
                  <PaginationLink
                    href="#"
                    next
                  >
                    Next
                  </PaginationLink>
                </PaginationItem>

              </Pagination>
            </Container>
          </Col>

        </Row>

      </Container>
    </div>

  )
}

export default NewFeed