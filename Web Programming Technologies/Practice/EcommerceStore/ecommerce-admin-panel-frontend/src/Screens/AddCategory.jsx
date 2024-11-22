import  { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { addCategory } from "../util/category";
import Navbar from "../Components/Navbar";


const AddCategory = () => {


    const [title, setTitle] = useState('')
    const [details, setDetails] = useState('')
  
    // get navigate function
    const navigate = useNavigate()
  
    const onSave = async () => {
      if (title.length == 0) {
        toast.warn('Please enter title')
      } else if (details.length == 0) {
        toast.warn('Please enter details')
      } else {
        const result = await addCategory(title, details)
        if (result['status'] == 'success') {
          toast.success('Successfully added a category')
          navigate(-1)
        } else {
          toast.error(result['error'])
        }
      }
    }
  
    const onCancel = () => {
      navigate(-1)
    }

  return <div >
  <Navbar />
  <div className='flex flex-col p-5 items-center justify-center'>
    <h2 className='text-3xl p-3 font-bold'>Add Category</h2>

    <div className=" flex flex-col w-full md:w-fit m-2 bg-[#EEEEEE] border  p-10 rounded-2xl gap-5 shadow-[#38383860] shadow-md">

    
    <div className="flex flex-col gap-2">
      <label className="font-extrabold" htmlFor=''>Title</label>
      <input
        onChange={(e) => setTitle(e.target.value)}
        type='text'
        className="border border-[#38383850] rounded-full px-3 p-1 "
      />
    </div>
    <div className="flex flex-col gap-2">
      <label className="font-extrabold" htmlFor=''>Details</label>
      <input
        onChange={(e) => setDetails(e.target.value)}
        type='text'
        className="border border-[#38383850] rounded-full px-3 p-1 "
      />
    </div>

    <div className='flex gap-5'>
      <button onClick={onSave} className="px-3 py-1 rounded-full border border-[#1f9c00] hover:bg-[#1f9c00] hover:text-white ">
        Save
      </button>
      <button onClick={onCancel} className="px-3 py-1 rounded-full border border-[#ff0000] hover:bg-[#ff0000] hover:text-white ">
        Cancel
      </button>
    </div>
  </div>
  </div>
</div>;
};

export default AddCategory;
