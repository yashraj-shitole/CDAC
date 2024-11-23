import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import { getProductDetails } from '../services/product'
import { toast } from 'react-toastify'
import { createUrl } from '../utils'
import { addToCart } from '../services/cart'
import { useDispatch } from 'react-redux'
import { addProduct } from '../slices/cartSlice'

function ProductDetails() {
  const [details, setDetails] = useState(null)

  // get the dispatcher
  const dispatcher = useDispatch()

  // get the route location detail
  const location = useLocation()

  const loadProductDetails = async (id) => {
    const result = await getProductDetails(id)
    if (result['status'] == 'success') {
      // since the result['data'] is an array of only one product
      setDetails(result['data'][0])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    // get the id of selected product
    const { id } = location.state

    loadProductDetails(id)
  }, [])

  const navigate = useNavigate()
  const onBack = () => {
    navigate(-1)
  }

  const onAddToCart = async () => {
    const result = await addToCart(details['id'], 1, details['price'])
    if (result['status'] == 'success') {
      toast.success('Successfully added to cart')

      // update the cartSlice
      dispatcher(addProduct())
    } else {
      toast.error(result['error'])
    }
  }

  return (
    <div>
      <h2 className='header'>Product Details</h2>

      {details && (
        <div>
          <img
            style={{ height: 200 }}
            src={createUrl(details['image'])}
            alt=''
          />
          <h3 className='mt-3'>{details['title']}</h3>
          <div>{details['details']}</div>

          <div className='mt-2'>
            <span style={{ fontWeight: 'bold' }}>Price: </span>₹{' '}
            {details['price']}
          </div>
          <div>
            <span style={{ fontWeight: 'bold' }}>Category: </span>₹{' '}
            {details['categoryTitle']}
          </div>
          <div>
            <span style={{ fontWeight: 'bold' }}>Brand: </span>₹{' '}
            {details['brandTitle']}
          </div>

          <div className='mt-3'>
            <button onClick={onBack} className='btn btn-danger btn-sm'>
              Back
            </button>
            <button
              onClick={onAddToCart}
              className='btn btn-primary btn-sm ms-2'
            >
              Add to cart
            </button>
          </div>
        </div>
      )}
    </div>
  )
}

export default ProductDetails
