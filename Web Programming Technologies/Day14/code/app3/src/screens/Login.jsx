import { useState } from 'react'
import { signin } from '../services/user'

function Login() {
  // create state members to keep email and password
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const onLogin = async () => {
    // console.log(`email = ${email}, password = ${password}`)
    if (email.length == 0) {
      alert('please enter email')
    } else if (password.length == 0) {
      alert('please enter password')
    } else {
      const result = await signin(email, password)
      if (result == 'found') {
        alert('welcome to the application')
      } else {
        alert('user does not exist')
      }
    }
  }

  return (
    <div>
      <h2 className='mt-3 mb-3' style={{ textAlign: 'center' }}>
        Login
      </h2>

      <div className='mb-3'>
        <label htmlFor=''>Email</label>
        <input
          onChange={(e) => {
            setEmail(e.target.value)
          }}
          className='form-control'
          type='text'
          placeholder='someone@test.com'
        />
      </div>
      <div className='mb-3'>
        <label htmlFor=''>Password</label>
        <input
          onChange={(e) => {
            setPassword(e.target.value)
          }}
          className='form-control'
          type='password'
          placeholder='######'
        />
      </div>
      <div className='mb-3'>
        <button onClick={onLogin} className='btn btn-success'>
          Login
        </button>
        <button className='btn btn-warning ms-2'>Register</button>
      </div>
    </div>
  )
}

export default Login
