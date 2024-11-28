import axios from "axios";
import { getToken } from "./auth";


const myAxios=axios.create({
    baseURL:'http://localhost:8080/'
}
)
export const privateAxios=axios.create({
    baseURL:'http://localhost:8080/',
    headers:{
        Authorization:"Bearer "+getToken()
    }
})

export default myAxios;