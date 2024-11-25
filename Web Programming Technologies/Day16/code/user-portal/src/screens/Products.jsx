import { useEffect, useState } from 'react'
import { getProductList } from '../services/product'
import { toast } from 'react-toastify'
import { createUrl } from '../utils'
import { useNavigate } from 'react-router-dom'

function Products() {
  const [products, setProducts] = useState([])

  const navigate = useNavigate()

  const loadProducts = async () => {
    const result = await getProductList()
    console.log(result)

    if (result['status'] == 'success') {
      setProducts(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    loadProducts()
  }, [])

  return (
    <div>
      <h2 className='header'>Products</h2>
      <div className='row'>
        {products.map((product) => {
          return (
            <div className='col-3'>
              <div className='card'>
                <img
                  src={createUrl(product['image'])}
                  className='card-img-top'
                />
                <div className='card-body'>
                  <h6 className='card-title'>{product['title']}</h6>
                  <p className='card-text'>Price: ₹{product['price']}</p>
                  <button
                    onClick={() => {
                      navigate('/home/product-details', {
                        state: { id: product['id'] },
                      })
                    }}
                    className='btn btn-link'
                  >
                    details
                  </button>
                </div>
              </div>
            </div>
          )
        })}
      </div>
    </div>
  )
}

export default Products
