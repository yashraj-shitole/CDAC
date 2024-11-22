import axios from 'axios'
import { createUrl } from '../utils'

export async function getCartItems() {
  try {
    const url = createUrl('cart/')
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

export async function addToCart(productId, quantity, price) {
  try {
    const url = createUrl('cart/')
    const token = sessionStorage['token']
    const body = { productId, quantity, price }
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

export async function updateCart(cartId, quantity) {
  try {
    const url = createUrl('cart/' + cartId + '/' + quantity)
    const token = sessionStorage['token']
    const response = await axios.patch(
      url,
      {},
      {
        headers: {
          token,
        },
      }
    )

    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}

export async function deleteItemFromCart(cartId) {
  try {
    const url = createUrl('cart/' + cartId)
    const token = sessionStorage['token']
    const response = await axios.delete(url, {
      headers: {
        token,
      },
    })

    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
