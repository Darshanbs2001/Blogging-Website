
import { Button, Card, CardBody, CardText, Container } from 'reactstrap'

const Post = ({post={title:"This is the default title",content:"This is the default content"}}) => {
  return (
    <Card className="m-1 shadow-sm">
        <CardBody className='text-start'>
            <h1>{post?.title}</h1>
        
        <CardText>
            {post?.content.substring(0,30)}...
            
        </CardText>

      <div>
        <Button>
            Read More..
        </Button>
      </div>
      </CardBody>

    </Card>
  )
}

export default Post