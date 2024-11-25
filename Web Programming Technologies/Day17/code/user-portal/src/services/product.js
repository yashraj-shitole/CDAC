import axios from 'axios'
import { createUrl } from '../utils'

export async function getProductList() {
  try {
    const url = createUrl('product/')
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

export async function getProductDetails(id) {
  try {
    const url = createUrl('product/details/' + id)
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
