import { getCurrentUserDetails, getToken } from "./auth";
import  myAxios, { privateAxios } from "./myAxios"

export const createPost=async(postData)=>{
    const user=getCurrentUserDetails()
    //const token=getToken()
    // const res=await myAxios.post(`/apis/user/${user.id}/category/${postData.categoryId}/posts`,
    //     postData
    //     ,{
    //         headers:{
    //             Authorization:"Bearer "+token
        
    //         }
    //     }
    // )
    const res=await privateAxios.post(`/apis/user/${user.id}/category/${postData.categoryId}/posts`,postData);
    return res.data;
}
export async function getPosts(){
    return await privateAxios.get('/apis/posts');
}