import axios from 'axios'
import { createUrl } from '../utils'

export async function addCategory(title, details) {
  try {
    const body = { title, details }
    const url = createUrl('category/')
    const response = await axios.post(url, body)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function getCategoryList() {
  try {
    const url = createUrl('category/')
    const response = await axios.get(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function deleteCategory(id) {
  try {
    const url = createUrl('category/' + id)
    const response = await axios.delete(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
