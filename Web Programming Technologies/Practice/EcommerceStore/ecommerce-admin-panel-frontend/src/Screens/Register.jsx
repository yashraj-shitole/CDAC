import { useState } from "react";
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify";
import { signup } from "../util/admin";


function Register() {

  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [phone, setPhone] = useState('')


  const navigate = useNavigate()

  const onSignup = async () => {
    if (firstName.length == 0) {
      toast.warn('Please enter first name')
    } else if (lastName.length == 0) {
      toast.warn('Please enter last name')
    } else if (email.length == 0) {
      toast.warn('Please enter email')
    } else if (phone.length == 0) {
      toast.warn('Please enter phone number')
    } else if (password.length == 0) {
      toast.warn('Please enter password')
    } else if (confirmPassword.length == 0) {
      toast.warn('Please confirm password')
    } else if (password != confirmPassword) {
      toast.warn('Password does not match')
    } else {
      const result = await signup(firstName, lastName, email, password, phone)
      if (result['status'] == 'success') {
        toast.success('Successfully registered a new admin')

        // go back
        navigate(-1)
      } else {
        toast.error(result['error'])
      }
    }
  }
  


  
  return (
    <div className="flex items-center justify-center h-[100vh]">

<div className=" flex flex-col w-full md:w-fit m-2 bg-[#EEEEEE] border  p-10 rounded-2xl gap-5 shadow-[#38383860]  shadow-md">

      <div className="flex flex-col gap-2">
        <label htmlFor="fname">First Name</label>
        <input onChange={e=>setFirstName(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="text" name="fname" id="" />
      </div>
      <div className="flex flex-col gap-2">
        <label htmlFor="lname">Last Name</label>
        <input onChange={e=>setLastName(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="text" name="lname" id="" />
      </div>
      <div className="flex flex-col gap-2">
        <label htmlFor="email">Email</label>
        <input onChange={e=>setEmail(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="email" name="email" id="" />
      </div>
      <div className="flex flex-col gap-2">
        <label htmlFor="phone">Phone number</label>
        <input onChange={e=>setPhone(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="tel" name="phone" id="" />
      </div>
      

      <div className="flex flex-col gap-2">
        <label htmlFor="password">Password</label>
        <input onChange={e=>setPassword(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="password" name="password" id="" />
      </div>
      <div className="flex flex-col gap-2">
        <label htmlFor="cpassword">Confirm password</label>
        <input onChange={e=>setConfirmPassword(e.target.value)} className="border border-[#38383850] rounded-full px-3 p-1 " type="password" name="cpassword" id="" />
      </div>
      
      <div className="flex items-center justify-center p-2">
            <button className="border  border-none rounded-full w-fit   shadow-[#38383860] shadow-md hover:bg-[#222831] hover:text-white  " onClick={onSignup}>
             <div className="hover:shadow-inner hover:shadow-[#f6f6f670] w-full h-full px-10 py-2">
             <h1 className="text-xl font-bold">Signup</h1>
             </div>
            </button>
            </div>

            <div>
              <h1 className="font-medium">Already have an account? <span><Link className="text-[#76ABAE] font-bold " to='/'>Login</Link></span> </h1>
            </div>
     
    </div>

 </div>  
  )
}

export default Register