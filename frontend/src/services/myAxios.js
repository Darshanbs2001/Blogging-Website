import axios from "axios";
import { doLogout, getToken } from "./auth";


const myAxios=axios.create({
    baseURL:'http://localhost:8080/'
}
)
// export const privateAxios=axios.create({
//     baseURL:'http://localhost:8080/',
//     headers:{
//         Authorization:"Bearer "+getToken()
//     }
// })

export const privateAxios=axios.create(
    {
        baseURL:'http://localhost:8080/'
    }
)
privateAxios.interceptors.request.use(
    (config)=>{
        const token=getToken();
        if(token){
            config.headers.Authorization=`Bearer ${token}`;
        }
        return config;
    },(error)=>{
        /*if(error.status===403){
            doLogout();

        }*/
        return Promise.reject(error);
    }
)
export default myAxios;