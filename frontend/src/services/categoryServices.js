import { getCurrentUserDetails, getToken } from "./auth";
import myAxios from "./myAxios"

const fetchCategories=async()=>{
    let token=getToken();
    token="Bearer "+token;
    console.log(token);

    const res=await myAxios.get("/apis/categories",{
        headers:{
        Authorization:token
    }
}
)
    return res;


} 
export {fetchCategories};