import  { useState } from 'react'
import Base from '../components/Base'
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormFeedback, FormGroup, Input, Label, Row } from 'reactstrap'
import { toast } from 'react-toastify'
import {signin} from '../services/Users'
import { doLogin } from '../services/auth'
import { useNavigate } from 'react-router-dom'


const SignIn = () => {
  const [data,setdata]=useState({
    email:"",
    password:"",
  })
  const [loading,setloading]=useState(false);
  const [error,setError]=useState({
    errors:{},
    isError:false
  }
  )
  const navigate=useNavigate();
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
    /*toast.success("success",{
      position:"top-center"
    })*/

  }
  const handleSubmit=async (e)=>{
    e.preventDefault;
    try{

      setloading(true);
      const resp=await signin(data);
      setError({error:{},isError:false})
      console.log(resp);
     
      doLogin(resp,
        ()=>{
          console.log("login details is saved")
          navigate('/user/dashboard')
        }
      );
    }
    catch(err){
      console.log(err)
      if(err.response.status==403)
      {
      toast.error("wrong email or password try again",{
        position:"bottom-left"
      })
    }
    else{
      setError({
        errors:err,
        isError:true
      })
    }
    
    
  }
  finally{
    setloading(false);
  }
}
  return (
    
    <Base>
 {
            loading?<div className="wrapper"><div className="loader"></div></div>:
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
          <Form >

            <FormGroup className="px-5">
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
            
            <FormGroup className="px-5">
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
              <Button onClick={handleReset} color="light" type="reset"className='m-2' outline>reset</Button>
            </Container>



          </Form>
          </CardBody>
         </Card>

        </Col>
      </Row>
    </Container>
}
    </Base>
  )
}

export default SignIn