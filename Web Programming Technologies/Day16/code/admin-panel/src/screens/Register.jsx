import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { signup } from '../services/admin'

function Register() {
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [phone, setPhone] = useState('')

  // get navigate function
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
    <div>
      <h2 className='header'>Register</h2>

      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <div className='mb-3'>
            <label htmlFor=''>First Name</label>
            <input
              onChange={(e) => setFirstName(e.target.value)}
              type='text'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Last Name</label>
            <input
              onChange={(e) => setLastName(e.target.value)}
              type='text'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Email</label>
            <input
              onChange={(e) => setEmail(e.target.value)}
              type='email'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Phone Number</label>
            <input
              onChange={(e) => setPhone(e.target.value)}
              type='tel'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Password</label>
            <input
              onChange={(e) => setPassword(e.target.value)}
              type='password'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Confirm Password</label>
            <input
              onChange={(e) => setConfirmPassword(e.target.value)}
              type='password'
              className='form-control'
            />
          </div>

          <div className='mb-3'>
            <div>
              Already have an account? <Link to='/login'>Signin here</Link>
            </div>
            <button onClick={onSignup} className='mt-3 btn btn-success'>
              Signup
            </button>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  )
}

export default Register
