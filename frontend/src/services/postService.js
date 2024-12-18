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
    return await privateAxios.get(`/apis/posts?pageNumber=${pageNumber}&pageSize=${NumberOfPosts}&sortBy=addedDate&sortDir='asc'`);
}
export async function getPostDetails(postId){
    return await privateAxios.get(`/apis/posts/${postId}`);
}
export async function createComment(postId,comment){
    return await privateAxios.post(`/apis/comments/post/${postId}/comments`,comment);
}
export async function loadById(id){
    return await privateAxios.get(`/apis/user/${id}/posts`);
}
export async function deletePost(id){
    return await privateAxios.delete(`/apis/posts/${id}`);
}
export async function updatePostId(id,post){
    return await privateAxios.put(`/apis/posts/${id}`,post)
}