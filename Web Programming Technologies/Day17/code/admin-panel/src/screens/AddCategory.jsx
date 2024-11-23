import { useState } from 'react'
import Navbar from '../components/Navbar'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { addCategory } from '../services/category'

function AddCategory() {
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

  return (
    <div>
      <Navbar />
      <div className='container'>
        <h2 className='header'>Add Category</h2>
        <div className='mb-3'>
          <label htmlFor=''>Title</label>
          <input
            onChange={(e) => setTitle(e.target.value)}
            type='text'
            className='form-control'
          />
        </div>
        <div className='mb-3'>
          <label htmlFor=''>Details</label>
          <input
            onChange={(e) => setDetails(e.target.value)}
            type='text'
            className='form-control'
          />
        </div>

        <div className='mb-3'>
          <button onClick={onSave} className='btn btn-success'>
            Save
          </button>
          <button onClick={onCancel} className='btn btn-danger ms-2'>
            Cancel
          </button>
        </div>
      </div>
    </div>
  )
}

export default AddCategory
