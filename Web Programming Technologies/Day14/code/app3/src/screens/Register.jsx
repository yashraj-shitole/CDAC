import { useState } from 'react'
import { signup } from '../services/user'

function Register() {
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [phone, setPhone] = useState('')
  const [email, setEmail] = useState('')
  const [gender, setGender] = useState('male')
  const [birthDate, setBirthDate] = useState('')
  const [address1, setAddress1] = useState('')
  const [address2, setAddress2] = useState('')
  const [city, setCity] = useState('')
  const [state, setState] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')

  const onRegister = async () => {
    // console.log(`first name = ${firstName}`)
    // console.log(`last name = ${lastName}`)
    // console.log(`phone = ${phone}`)
    // console.log(`email = ${email}`)
    // console.log(`gender = ${gender}`)
    // console.log(`birth date = ${birthDate}`)
    // console.log(`address1 = ${address1}`)
    // console.log(`address2 = ${address2}`)
    // console.log(`city = ${city}`)
    // console.log(`state = ${state}`)
    // console.log(`password = ${password}`)
    // console.log(`confirm password = ${confirmPassword}`)

    // input validation
    if (firstName.length == 0) {
      alert('please enter first name')
    } else if (lastName.length == 0) {
      alert('please enter last name')
    } else if (phone.length != 10) {
      alert('mobile number must be 10 digits')
    } else if (email.length == 0) {
      alert('please enter email')
    } else if (password.length == 0) {
      alert('please enter password')
    } else if (confirmPassword.length == 0) {
      alert('please confirm the password')
    } else if (password != confirmPassword) {
      alert('password does not match')
    } else {
      const result = await signup(
        firstName,
        lastName,
        address1,
        address2,
        city,
        state,
        email,
        phone,
        gender,
        birthDate,
        password
      )
      if (result == 'ok') {
        alert('successfully registered a user')
      } else {
        alert('error while registering a user')
      }
    }
  }

  return (
    <div>
      <h2 style={{ textAlign: 'center', margin: 20 }}>Register</h2>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>First Name</label>
          <input
            onChange={(e) => {
              setFirstName(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
        <div className='col'>
          <label htmlFor=''>Last Name</label>
          <input
            onChange={(e) => {
              setLastName(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
      </div>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>Phone Number</label>
          <input
            maxLength={10}
            onChange={(e) => {
              setPhone(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
        <div className='col'>
          <label htmlFor=''>Email</label>
          <input
            onChange={(e) => {
              setEmail(e.target.value)
            }}
            type='email'
            className='form-control'
          />
        </div>
      </div>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>Gender</label>
          <select
            onChange={(e) => {
              setGender(e.target.value)
            }}
            className='form-control'
          >
            <option value='male'>Male</option>
            <option value='female'>Female</option>
          </select>
        </div>
        <div className='col'>
          <label htmlFor=''>Birth Date</label>
          <input
            onChange={(e) => {
              setBirthDate(e.target.value)
            }}
            type='date'
            className='form-control'
          />
        </div>
      </div>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>Address Line 1</label>
          <input
            onChange={(e) => {
              setAddress1(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
        <div className='col'>
          <label htmlFor=''>Address Line 2</label>
          <input
            onChange={(e) => {
              setAddress2(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
      </div>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>City</label>
          <input
            onChange={(e) => {
              setCity(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
        <div className='col'>
          <label htmlFor=''>State</label>
          <input
            onChange={(e) => {
              setState(e.target.value)
            }}
            type='text'
            className='form-control'
          />
        </div>
      </div>

      <div className='row mb-3'>
        <div className='col'>
          <label htmlFor=''>Password</label>
          <input
            onChange={(e) => {
              setPassword(e.target.value)
            }}
            type='password'
            className='form-control'
          />
        </div>
        <div className='col'>
          <label htmlFor=''>Confirm Password</label>
          <input
            onChange={(e) => {
              setConfirmPassword(e.target.value)
            }}
            type='password'
            className='form-control'
          />
        </div>
      </div>

      <div className='mb-3'>
        <button onClick={onRegister} className='btn btn-success'>
          Register
        </button>
        <button className='btn btn-danger ms-2'>Cancel</button>
      </div>
    </div>
  )
}

export default Register
