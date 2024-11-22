import axios from "axios"
import { useState } from "react"

function Login(){



    const [email,setEmail]=useState('')
    const [password,setPassword]=useState('')


    const onLogin=()=>{
       
            const url="http://localhost:4000/user/signin"
            const body={email,password}
            const response= axios.post(url,body)
            console.log(response.data)
            const result=response.data
            if(result=="found"){
                alert("welcome")
            }else{
                alert("user does not exist")
            }
    }

    return(

        <div className="h-[100vh] flex flex-col justify-center items-center">
        <div className="flex flex-col gap-2 border border-[#38383850] rounded-2xl p-6 ">


            <div className="flex flex-col items-start justify-center gap-2">
                <label className="text-[14px] font-semibold" htmlFor="email">Email</label>
                <input onChange={(e)=>setEmail(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="email" name="email" placeholder="email" />
            </div>

            <div className="flex flex-col items-start justify-center gap-2">
                <label className="text-[14px] font-semibold" htmlFor="password">Password</label>
                <input onChange={(e)=>setPassword(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="password" name="password" placeholder="password" />
            </div>

            <div>
                <button onClick={onLogin} className="border border-[#38383850] rounded-full py-2 px-8 hover:bg-[#262626] hover:text-white">Login</button>
            </div>

            <div>
                <p>Dont have an accoount? <span><button className="font-semibold">Signup</button></span></p>
            </div>

            <div className=" my-4 h-[0.5px] w-full bg-black"></div>


            <div>
                <button className="flex items-center justify-center gap-2 border border-[#38383850] rounded-full p-3 w-full hover:bg-[#262626] hover:text-white">
                    <img className="h-7" src="https://lh3.googleusercontent.com/COxitqgJr1sJnIDe8-jiKhxDx1FrYbtRHKJ9z_hELisAlapwE9LUPh6fcXIfb5vwpbMl4xl9H9TRFPc5NOO8Sb3VSgIBrfRYvW6cUA" alt="" />
                    <h1>Login with Google</h1>
                    </button>
            </div>


        </div>
    </div>


    )
}

export default Login