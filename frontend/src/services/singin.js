import myAxios from "./myAxios"

export default async function signin(data){
    const res=await myAxios.post('/apis/login',data);
    return res;
}