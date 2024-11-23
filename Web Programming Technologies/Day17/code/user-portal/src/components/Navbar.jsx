import { useSelector } from 'react-redux'
import { Link, useNavigate } from 'react-router-dom'

function Navbar() {
  // get navigate function
  const navigate = useNavigate()

  // get the item count from cart slice
  const count = useSelector((state) => state.cart.itemCount)

  const onLogout = () => {
    // cleat the session storage
    sessionStorage.removeItem('name')
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('email')
    sessionStorage.removeItem('phone')

    // go to login screen
    navigate('/login')
  }

  return (
    <nav className='navbar navbar-expand-lg bg-primary' data-bs-theme='dark'>
      <div className='container-fluid'>
        <a className='navbar-brand' href='#'>
          MyStore
        </a>
        <button
          className='navbar-toggler'
          type='button'
          data-bs-toggle='collapse'
          data-bs-target='#navbarNav'
          aria-controls='navbarNav'
          aria-expanded='false'
          aria-label='Toggle navigation'
        >
          <span className='navbar-toggler-icon'></span>
        </button>
        <div className='collapse navbar-collapse' id='navbarNav'>
          <ul className='navbar-nav'>
            <li className='nav-item'>
              <Link
                className='nav-link'
                aria-current='page'
                to='/home/products'
              >
                Products
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' aria-current='page' to='/home/cart'>
                Cart ({count})
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/home/orders'>
                Orders
              </Link>
            </li>
            <li className='nav-item'>
              <button onClick={onLogout} className='nav-link'>
                Logout
              </button>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default Navbar
