import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { signin } from '../services/admin'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  // get the navigate function
  const navigate = useNavigate()

  const onLogin = async () => {
    if (email.length == 0) {
      toast.warn('please enter email')
    } else if (password.length == 0) {
      toast.warn('please enter password')
    } else {
      // call the singin api
      const result = await signin(email, password)

      // check if the result is successful
      if (result['status'] == 'success') {
        toast.success('Welcome to MyStore')

        // get the admin details
        const { firstName, lastName, phone, token } = result['data']

        // cache the admin details in session storage
        sessionStorage['name'] = `${firstName} ${lastName}`
        sessionStorage['token'] = token
        sessionStorage['phone'] = phone
        // sessionStorage['email'] = email
        sessionStorage.setItem('email', email)

        // go to home screen
        navigate('/home')
      } else {
        toast.error(result['error'])
      }
    }
  }

  return (
    <div>
      <h2 className='header'>Login</h2>

      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <div className='mb-3'>
            <label htmlFor=''>Email</label>
            <input
              onChange={(e) => setEmail(e.target.value)}
              type='email'
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
            <div>
              Don't have an account? <Link to='/register'>Register here</Link>
            </div>
            <button onClick={onLogin} className='btn btn-success mt-3'>
              Login
            </button>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  )
}

export default Login
