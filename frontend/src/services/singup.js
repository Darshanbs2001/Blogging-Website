import myAxios from "./myAxios"

const signup= async (userData)=>{
    const response=await myAxios.post('/apis/register',userData);
    console.log(response);
    return response.data;
}

export default signup;