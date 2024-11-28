//isLoggedIn=>
export const isLoggedin=()=>{
    let data=sessionStorage.getItem("data");
    if(data==null){
        return false;
    }
    else{
        return true;
    }
}
//doLogin=>
    export const doLogin=(data,next)=>{
        sessionStorage.setItem("data",JSON.stringify(data))
        next();
    }
    

//doLogout=>
export const doLogout=(next)=>{

    sessionStorage.removeItem("data");
    next();
}
//get current user
export const getCurrentUserDetails=()=>{
    if(isLoggedin()){
        return JSON.parse(sessionStorage.getItem("data")).userdto;
    }
    else{
        return undefined;
    }
}
export const getToken=()=>{
    if(isLoggedin()){
        return JSON.parse(sessionStorage.getItem("data")).token;
    }
    else{
        return undefined;
    }
}