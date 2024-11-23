import { Route, Routes } from 'react-router-dom'
import Login from './screens/Login'
import Register from './screens/Register'
import Home from './screens/Home'
import Orders from './screens/Orders'
import Products from './screens/Products'
import Cart from './screens/Cart'
import ProductDetails from './screens/ProductDetails'

import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

function App() {
  return (
    <div className='container-fluid'>
      <Routes>
        <Route path='/' element={<Login />} />
        <Route path='login' element={<Login />} />
        <Route path='register' element={<Register />} />

        <Route path='home' element={<Home />}>
          <Route path='products' element={<Products />} />
          <Route path='orders' element={<Orders />} />
          <Route path='cart' element={<Cart />} />
          <Route path='product-details' element={<ProductDetails />} />
        </Route>
      </Routes>

      <ToastContainer />
    </div>
  )
}

export default App
