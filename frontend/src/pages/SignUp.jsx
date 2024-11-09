import React, { useState } from 'react'
import { Button, Card, CardBody,Form, FormGroup, CardHeader, Container, Input, Label, Row, Col } from 'reactstrap'
import Base from '../components/Base'

const SignUp = () => {
  const [data, setdata] = useState({
    name:"",
    email:"",
    password:"",
    about:""
  });
  const handleChange=(e,field)=>{
    setdata((prev)=>{
      let newObj={
        ...prev,
        [field]:e.target.value

      }
      return newObj;


    })
    console.log(data)
  }
  const handleSubmit=(e)=>{
    e.preventDefault;
    console.log(data);
  }
  return (
    <Base>   
    <Container className='mt-4'>
      <Row>
        <Col md={{offset:3,size:6}}>
        <Card color="dark" inverse outline={false}>
          <CardHeader>
            <h2>
            Fill the form to register
            </h2>
          </CardHeader>
          <CardBody>
            <Form>          
              <FormGroup>
              <Label for="name">
                Enter Name

              </Label>
              <Input type='text' 
              placeholder='enter you name'
               id="name"
               onChange={(e)=>handleChange(e,"name")}

              />

            </FormGroup>
            <FormGroup>
              <Label for="email">
                Enter Email

              </Label>
              <Input type='email' 
              placeholder='enter you Email'
               id="email"
               onChange={(e)=>handleChange(e,"email")}
              />
              </FormGroup>
              <FormGroup>
              <Label for="password">
                Enter password

              </Label>
              <Input type='password' 
              placeholder='enter you password'
               id="password"
               onChange={(e)=>handleChange(e,"password")}
              />
              </FormGroup>
              <FormGroup>
              <Label for="confirm-password">
                Confirm Password

              </Label>
              <Input type='password' 
              placeholder='enter the password again'
               id="confirm-password"

              />

            </FormGroup>
            <FormGroup>
              <Label for="about">
                About you
              </Label>
              <Input
              type='textarea'
               id="about"
               bssize={{height:"250px"}}
               onChange={(e)=>handleChange(e,"about")}
              />
            </FormGroup>

            <Container className='text-center'>
              <Button onClick={handleSubmit} color='light' outline>Register</Button>
              <Button color='secondary' type="reset" className='m-2' outline>Reset</Button>
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

export default SignUp