//isLoggedIn=>
export const isLoggedin=()=>{
    let data=localStorage.getItem("data");
    if(data==null){
        return false;
    }
    else{
        return true;
    }
}
//doLogin=>
    export const doLogin=(data,next)=>{
        localStorage.setItem("data",JSON.stringify(data))
        next();
    }
    

//doLogout=>
export const doLogout=(next)=>{

    localStorage.removeItem("data");
    next();
}
//get current user
export const getCurrentUserDetails=()=>{
    if(isLoggedin()){
        return JSON.parse(localStorage.getItem("data")).userdto;
    }
    else{
        return undefined;
    }
}