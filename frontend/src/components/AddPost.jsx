import { Button, Card, CardBody, Container, Input, Label } from 'reactstrap'

const AddPost
 = () => {
  return (
    <div className='wrapper'>
        <Container className='mt-2'>
            <Card className='shadow'>
                <CardBody>
                    <div >
                       <Label for='title'>Post title</Label>
                       <Input type='text' id='title'></Input> 
                    </div>
                    <div>
                       <Label for='content'>Post content</Label>
                       <Input type='textarea' id='content' height={"300px"}></Input> 
                    </div>
                    <div>
                       <Label for='title'>Post title</Label>
                       <Input type='text' id='title'></Input> 
                    </div>
                   <Container className='text-center mt-2'>
                    <Button color='primary' className='rounded-0'>Add Post</Button>
                    <Button color='danger' className='ms-2 rounded-0'>Reset</Button>
                   </Container>
                </CardBody>
            </Card>
        </Container>


    </div>
  )
}


export default AddPost