
import { Link } from 'react-router-dom'
import { Button, Card, CardBody, CardText } from 'reactstrap'

const Post = ({post={title:"This is the default title",content:"This is the default content"}}) => {
  return (
    <Card className="m-1 shadow-sm">
        <CardBody className='text-start'>
            <h1>{post?.title}</h1>
        
        <CardText dangerouslySetInnerHTML={ {__html:post?.content.substring(0,100)+"..."}}>
            
            
        </CardText>
        {//post?.content
        }

      <div>
        <Link className="btn btn-secondary" to={"/user/post/"+post.postId}>
            Read More..
            </Link>
        
      </div>
      </CardBody>

    </Card>
  )
}

export default Post