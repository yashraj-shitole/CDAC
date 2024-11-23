import axios from 'axios'
import { createUrl } from '../utils'

export async function getProductList() {
  try {
    const url = createUrl('product/')
    const response = await axios.get(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function addProduct(
  title,
  details,
  categoryId,
  brandId,
  price,
  tags,
  image
) {
  try {
    const url = createUrl('product/')

    // create body to upload the data along with an image
    const body = new FormData()
    body.append('title', title)
    body.append('details', details)
    body.append('categoryId', categoryId)
    body.append('brandId', brandId)
    body.append('price', price)
    body.append('tags', tags)
    body.append('image', image)

    const response = await axios.post(url, body)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
