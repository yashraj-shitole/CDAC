import axios from 'axios'
import { createUrl } from '../utils'

export async function placeOrder(totalAmount) {
  try {
    const url = createUrl('order/')
    const token = sessionStorage['token']
    const body = { totalAmount }
    const response = await axios.post(url, body, {
      headers: {
        token,
      },
    })
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function getOrderList() {
  try {
    const url = createUrl('order/')
    const token = sessionStorage['token']
    const response = await axios.get(url, {
      headers: {
        token,
      },
    })
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
