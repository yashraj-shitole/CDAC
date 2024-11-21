import { useState } from "react"

function Signup(){


    const [email,setEmail]=useState('')
    const [name,setName]=useState('')
    const [surname,setSurname]=useState('')
    const [phone,setPhone]=useState(0)
    const [password,setPassword]=useState('')
    const [cpassword,setCpassword]=useState('')


    const onSignIn=()=>{
        if(password!==cpassword){
            alert("Password doesnt match")
        }
        else{
            console.log(email)
            console.log(name)
            console.log(surname)
            console.log(phone)
            console.log(password)
            console.log(cpassword)
        }

    }

return(

    <div className="h-[100vh] flex flex-col justify-center items-center">
        <div className="flex flex-col gap-2 border border-[#38383850] rounded-2xl p-6 ">


            <div className="flex flex-col items-start justify-center gap-2">
                <label className="text-[14px] font-semibold" htmlFor="email">Email</label>
                <input onChange={(e)=>setEmail(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="email" name="email" placeholder="email" />
            </div>

            <div className="flex md:flex-row flex-col gap-2">
                <div className="flex  flex-col items-start justify-center gap-2">
                    <label className="text-[14px] font-semibold" htmlFor="name">Name</label>
                    <input  onChange={(e)=>setName(e.target.value)}  className="border w-full border-[#38383850] rounded-2xl py-1 px-2 " type="text" name="Name" placeholder="Name" />
                </div>

                <div className="flex flex-col items-start justify-center gap-2">
                    <label className="text-[14px] font-semibold" htmlFor="surname">Surname</label>
                    <input  onChange={(e)=>setSurname(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="text" name="surname" placeholder="Surname" />
                </div>
            </div>

                <div className="flex flex-col items-start justify-center gap-2">
                    <label className="text-[14px] font-semibold" htmlFor="phone">Mobile number</label>
                    <input  onChange={(e)=>setPhone(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="tel" name="phone" placeholder="Mobile number" />
                </div>

            <div className="flex flex-col items-start justify-center gap-2">
                <label className="text-[14px] font-semibold" htmlFor="password">Password</label>
                <input onChange={(e)=>setPassword(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="password" name="password" placeholder="password" />
            </div>

            <div className="flex flex-col items-start justify-center gap-2">
                <label className="text-[14px] font-semibold" htmlFor="cpassword">Confirm password</label>
                <input onChange={(e)=>setCpassword(e.target.value)} className="border border-[#38383850] rounded-2xl py-1 px-2 w-full" type="password" name="cpassword" placeholder="Type password again" />
            </div>



            <div>
                <button onClick={onSignIn} className="border border-[#38383850] rounded-full py-2 px-8 hover:bg-[#262626] hover:text-white">Signup</button>
            </div>

            <div>
                <p>Already have an accoount? <span><button className="font-semibold">Login</button></span></p>
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

export default Signup;