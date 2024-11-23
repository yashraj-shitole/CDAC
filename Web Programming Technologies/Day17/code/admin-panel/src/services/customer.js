import axios from 'axios'
import { createUrl } from '../utils'

export async function getCustomerList() {
  try {
    const url = createUrl('customer/')
    const response = await axios.get(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function toggleUser(userId, status) {
  try {
    const url = createUrl('customer/' + userId + '/' + status)
    const response = await axios.patch(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
