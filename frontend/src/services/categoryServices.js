import { getCurrentUserDetails, getToken } from "./auth";
import myAxios, { privateAxios } from "./myAxios"

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
async function loadPostByCategory(catgeoryId){
    const res=await privateAxios.get(`/apis/category/${catgeoryId}/posts`)
    return res;
}
export {fetchCategories,loadPostByCategory};