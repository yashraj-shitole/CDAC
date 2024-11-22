import axios from "axios"
import { createUrl } from "../utils"


//for login
export async function signin(email,password){
    try{
        const url= createUrl('admin/signin')
        const body={email,password}

        const response=await axios.post(url,body)

        return response.data

    }catch(ex){
return{status:"error",error:ex}
    }
}


//to regsister
export async function signup(firstName,lastName,email,password,phone){
    try{
        const url=createUrl('admin/signup')
        const body={firstName,lastName,email,password,phone}

        const response=await axios.post(url,body)

        return response.data

    }catch (e){
        return {status:'error',error:e}
    }

}