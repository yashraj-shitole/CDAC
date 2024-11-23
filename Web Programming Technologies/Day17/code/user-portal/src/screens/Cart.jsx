import { useEffect, useState } from 'react'
import { deleteItemFromCart, getCartItems, updateCart } from '../services/cart'
import { toast } from 'react-toastify'
import CartItem from '../components/CartItem'
import './Cart.css'
import { placeOrder } from '../services/order'
import { useDispatch } from 'react-redux'
import { deleteProduct } from '../slices/cartSlice'

function Cart() {
  const [items, setItems] = useState([])

  // get the dispatcher
  const dispatcher = useDispatch()

  const loadCartItems = async () => {
    const result = await getCartItems()
    console.log(result)
    if (result['status'] == 'success') {
      setItems(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  const getSubtotal = () => {
    let total = 0
    for (const item of items) {
      total += item['quantity'] * item['price']
    }

    return total
  }

  const updateQuantity = async (cartId, newQuantity) => {
    if (newQuantity == 0) {
      // user no longer wants to keep this product in cart
      const result = await deleteItemFromCart(cartId)
      if (result['status'] == 'success') {
        toast.success('Successfully deleted item from cart')

        // update the itemCount in cartSlice
        dispatcher(deleteProduct())

        // refresh the list of items
        loadCartItems()
      } else {
        toast.error(result['error'])
      }
    } else {
      const result = await updateCart(cartId, newQuantity)
      if (result['status'] == 'success') {
        // refresh the list of items
        loadCartItems()
      } else {
        toast.error(result['error'])
      }
    }
  }

  useEffect(() => {
    loadCartItems()
  }, [])

  const onPlaceOrder = async () => {
    const totalAmount = getSubtotal() + getSubtotal() * 0.18
    const result = await placeOrder(totalAmount)
    if (result['status'] == 'success') {
      toast.success('Successfully placed your order')

      // refresh the list of items
      loadCartItems()
    } else {
      toast.error(result['error'])
    }
  }

  return (
    <div>
      <h2 className='header'>Cart</h2>
      {items.length == 0 && (
        <h4>
          There are no items in your cart. Please add one to place an order
        </h4>
      )}

      {items.length > 0 && (
        <div className='row'>
          <div className='col-9'>
            <table className='table table-hover table-bordered'>
              <thead>
                <tr>
                  <th>No</th>
                  <th>Image</th>
                  <th>Title</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Total</th>
                </tr>
              </thead>
              <tbody>
                {items.map((item, index) => {
                  return (
                    <CartItem
                      item={item}
                      index={index}
                      onUpdateQuantity={(newQuantity) => {
                        updateQuantity(item['id'], newQuantity)
                      }}
                    />
                  )
                })}
              </tbody>
            </table>
          </div>
          <div className='col-3 '>
            <div className='cart-summary'>
              <div>
                <label htmlFor='' style={{ width: 100 }}>
                  # Items:
                </label>
                <span style={{ fontWeight: 'bold' }}>{items.length}</span>
              </div>
              <div>
                <label htmlFor='' style={{ width: 100 }}>
                  Subtotal:
                </label>
                <span style={{ fontWeight: 'bold' }}>₹ {getSubtotal()}</span>
              </div>
              <div>
                <label htmlFor='' style={{ width: 100 }}>
                  GST:
                </label>
                <span style={{ fontWeight: 'bold' }}>
                  ₹ {(getSubtotal() * 0.18).toFixed(2)}
                </span>
              </div>
              <hr />
              <div>
                <label htmlFor='' style={{ width: 100 }}>
                  Cart Total:
                </label>
                <span style={{ fontWeight: 'bold' }}>
                  ₹ {(getSubtotal() + getSubtotal() * 0.18).toFixed(2)}
                </span>
              </div>
            </div>

            <div style={{ textAlign: 'center' }}>
              <button onClick={onPlaceOrder} className='btn btn-success mt-2'>
                Place Order
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  )
}

export default Cart
