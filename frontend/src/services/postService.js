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
export async function getPosts(pageNumber=0,NumberOfPosts=5){
    return await privateAxios.get(`/apis/posts?pageNumber=${pageNumber}&pageSize=${NumberOfPosts}`);
}
export async function getPostDetails(postId){
    return await privateAxios.get(`/apis/posts/${postId}`);
}