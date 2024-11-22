import { Link } from 'react-router-dom'
import Navbar from '../components/Navbar'
import { useEffect, useState } from 'react'
import Row from '../components/Row'
import { toast } from 'react-toastify'
import { getBrandList } from '../services/brand'

function Brands() {
  // used to load all the brands
  const [brands, setBrands] = useState([])

  const onLoadBrands = async () => {
    const result = await getBrandList()
    if (result['status'] == 'success') {
      setBrands(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    // load all brands when this component is loaded on the screen
    onLoadBrands()
  }, [])

  return (
    <div>
      <Navbar />
      <div className='container'>
        <h2 className='header'>Brands</h2>

        <Link className='btn btn-success' to='/add-brand'>
          Add
        </Link>
        {brands.length == 0 && (
          <h3 className='mt-3'>
            There are no brands. Please use add button to add one.
          </h3>
        )}

        {brands.length > 0 && (
          <table className='table-hover table mt-3'>
            <thead>
              <tr>
                <th>Sr. No</th>
                <th>Title</th>
                <th>Details</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {brands.map((category) => {
                return (
                  <Row
                    id={category['id']}
                    title={category['title']}
                    details={category['details']}
                    onDelete={onLoadBrands}
                  />
                )
              })}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}

export default Brands
