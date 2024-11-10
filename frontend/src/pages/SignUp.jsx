import { useState } from 'react'
import { Button, Card, CardBody,Form, FormGroup, CardHeader, Container, Input, Label, Row, Col } from 'reactstrap'
import Base from '../components/Base'
import signup from '../services/singup';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const [data, setdata] = useState({
    name:"",
    email:"",
    password:"",
    about:""
  });
 const navigate=useNavigate();
  const handleChange=(e,field)=>{
    setdata((prev)=>{
      let newObj={
        ...prev,
        [field]:e.target.value

      }
      return newObj;


    })
    //console.log(data)
  }
  const handleReset=()=>{
    setdata({
      name:'',
      about:'',
      email:'',
      password:''
    })
    toast('🦄 Wow so easy!', {
      position: "top-right",
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
      theme: "dark",
  
      });
  }
  const handleSubmit=async(e)=>{
    e.preventDefault;
    //call the singupmethod
    try{
      let res=await signup(data);
      console.log(res);
      console.log(data);
      handleReset();
      navigate('/signin')
      toast.success('added the user successfully',{
        position:"top-center"
      });
      

    }
    catch(error){
      //console.log(error)
      toast.warning(error.message,{
        position:"top-center"
      });
    }



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
              <Button onClick={handleReset} color='secondary' type="reset" className='m-2' outline>Reset</Button>
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