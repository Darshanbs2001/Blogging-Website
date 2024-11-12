import  { useState } from 'react'
import Base from '../components/Base'
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormFeedback, FormGroup, Input, Label, Row } from 'reactstrap'
import { toast } from 'react-toastify'
import signin from '../services/singin'


const SignIn = () => {
  const [data,setdata]=useState({
    email:"",
    password:"",
  })
  const [error,setError]=useState({
    errors:{},
    isError:false
  }
  )
  const handleChange=(e,field)=>{
    setdata((prev)=>{
      let newObj={
        ...prev,
        [field]:e.target.value
      }
      return newObj;
    })

  }
  const handleReset=()=>{
    setdata({
      email:"",
      password:""
      
    });
    toast.success("success",{
      position:"top-center"
    })

  }
  const handleSubmit=async (e)=>{
    e.preventDefault;
    try{

      const resp=await signin(data);
      setError({error:{},isError:false})
      console.log(resp);
      toast.success("logged in successfully",{
        position:"bottom-left"
      })
    }
    catch(err){
      console.log(err)
      setError({
        errors:err,
        isError:true
      })
      console.log(error)
      toast.error("wrong email or password try again",{
        position:"bottom-left"
      })
    }
  }
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
                onChange={(e)=>handleChange(e,"email")}
                invalid={error.errors?.response?.data?.email?true:false}
               />
                <FormFeedback>
                {error.errors?.response?.data?.email}
               </FormFeedback>
            </FormGroup>
            
            <FormGroup>
              <Label for="password">
                Password
              </Label>
              <Input
                type='password'
                id="password"
                placeholder='enter the Password'
                onChange={(e)=>handleChange(e,"password")}
                invalid={error.errors?.response?.data?.password?true:false}
                
               />
               <FormFeedback>
                {error.errors?.response?.data?.password}
               </FormFeedback>
              
            </FormGroup>
            <Container className='text-center'>
              <Button onClick={handleSubmit}color='light' outline>Login</Button>
              <Button onClick={handleReset} color="secondary" type="reset"className='m-2' outline>reset</Button>
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