import React from 'react'
import Base from '../components/Base'
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from 'reactstrap'


const SignIn = () => {
  return (
    <Base>
    <Container>
      <Row className="mt-4"> 
        <Col
        md={
          {
            offset:3,
            size:6
          }
        }
        >
         <Card color='dark' inverse>
          <CardHeader>
            Login here!!
          </CardHeader>
          <CardBody>
          <Form>

            <FormGroup>
              <Label for="email">
                Email
              </Label>
              <Input
                type='email'
                id="email"
                placeholder='enter the email'
               />
            </FormGroup>
            
            <FormGroup>
              <Label for="password">
                Password
              </Label>
              <Input
                type='password'
                id="password"
                placeholder='enter the Password'
               />
            </FormGroup>
            <Container className='text-center'>
              <Button color='light' outline>Login</Button>
              <Button color="secondary" type="reset"className='m-2' outline>reset</Button>
            </Container>



          </Form>
          </CardBody>
         </Card>

        </Col>
      </Row>
    </Container>
    </Base>
  )
}

export default SignIn