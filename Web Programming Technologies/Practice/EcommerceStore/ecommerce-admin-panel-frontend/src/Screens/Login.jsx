import {  useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { signin } from "../util/admin";



const Login = () => {

  const [email,setEmail]=useState('');
  const [password,setPassword]=useState('');

  const navigate=useNavigate();

  const onLogin=async ()=>{
    
    if(email.length==0){
      alert('enter email')
    }
    else if(password.length==0){
      alert('enter password')
    }else{
      const result=await signin(email,password)
      if(result.status=='success'){
        toast.success('Welcome to MyStore')

        const { firstName, lastName, phone, token } = result['data']
        localStorage['name'] = `${firstName} ${lastName}`
        localStorage['token'] = token
        localStorage['phone'] = phone
        localStorage.setItem('email', email)

        navigate('/home')
      }else{
        alert('failed')
      }
    }

  }
  


  return (
    <div className="flex items-center justify-center h-[100vh]">


          <div className=" flex flex-col w-full md:w-fit m-2 bg-[#EEEEEE] border  p-10 rounded-2xl gap-5 shadow-[#38383860] shadow-md">

            <div className="flex flex-col gap-2">
              <label htmlFor="email"><h1 className="font-extrabold">Email</h1></label>
              <input onChange={e=>setEmail(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="email" name="email" id="" />
            </div>

            <div className="flex flex-col gap-2">
              <label htmlFor="password"><h1 className="font-extrabold">Password</h1></label>
              <input onChange={e=>setPassword(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="password" name="password" id="" />
            </div>
            
            <div className="flex items-center justify-center p-2">
            <button className="border  rounded-full w-fit border-none  shadow-[#38383860] shadow-md hover:bg-[#222831] hover:text-white  " onClick={onLogin}>
             <div className="hover:shadow-inner hover:shadow-[#f6f6f670] w-full h-full px-10 py-2">
             <h1 className="text-xl font-bold">Login</h1>
             </div>
            </button>
            </div>

            <div>
              <h1 className="font-medium">Dont have an account? <span><Link className="text-[#76ABAE] font-bold " to='/signup'>Register</Link></span> </h1>
            </div>
           
          </div>
    
       </div>  
  )
}

export default Login