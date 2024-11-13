import myAxios from "./myAxios"

export const signup= async (userData)=>{
    const response=await myAxios.post('/apis/register',userData);
    console.log(response);
    return response.data;
}

export async function signin(data){
    const res=await myAxios.post('/apis/login',data);
    return res.data;
}