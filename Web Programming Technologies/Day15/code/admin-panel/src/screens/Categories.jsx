import { Link } from 'react-router-dom'
import Navbar from '../components/Navbar'
import { useEffect, useState } from 'react'
import { getCategoryList } from '../services/category'
import CategoryRow from '../components/CategoryRow'
import { toast } from 'react-toastify'

function Categories() {
  // used to load all the categories
  const [categories, setCategories] = useState([])

  const onLoadCategories = async () => {
    const result = await getCategoryList()
    if (result['status'] == 'success') {
      setCategories(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    // load all categories when this component is loaded on the screen
    onLoadCategories()
  }, [])

  return (
    <div>
      <Navbar />
      <div className='container'>
        <h2 className='header'>Categories</h2>

        <Link className='btn btn-success' to='/add-category'>
          Add
        </Link>
        {categories.length == 0 && (
          <h3 className='mt-3'>
            There are no categories. Please use add button to add one.
          </h3>
        )}

        {categories.length > 0 && (
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
              {categories.map((category) => {
                return (
                  <CategoryRow
                    id={category['id']}
                    title={category['title']}
                    details={category['details']}
                    onDelete={onLoadCategories}
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

export default Categories
