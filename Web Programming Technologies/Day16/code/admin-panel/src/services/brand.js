import axios from 'axios'
import { createUrl } from '../utils'

export async function addBrand(title, details) {
  try {
    const body = { title, details }
    const url = createUrl('brand/')
    const response = await axios.post(url, body)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function getBrandList() {
  try {
    const url = createUrl('brand/')
    const response = await axios.get(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function deleteBrand(id) {
  try {
    const url = createUrl('brand/' + id)
    const response = await axios.delete(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
