import axios from 'axios'

export async function signup(
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
) {
  // url to call the API
  const url = 'http://localhost:4000/user/signup'

  // create the request body
  const body = {
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
    password,
  }

  // wait till the response is received
  const response = await axios.post(url, body)
  console.log(response.data)

  // return response body
  return response.data
}

export async function signin(email, password) {
  const url = 'http://localhost:4000/user/signin'

  // create the body
  const body = { email, password }

  // call the signin api and get the response
  const response = await axios.post(url, body)
  console.log(response.data)

  return response.data
}
