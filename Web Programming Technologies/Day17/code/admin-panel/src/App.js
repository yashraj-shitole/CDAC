import { Route, Routes } from 'react-router-dom'
import Login from './screens/Login'
import Register from './screens/Register'
import Home from './screens/Home'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Categories from './screens/Categories'
import Orders from './screens/Orders'
import Products from './screens/Products'
import AddCategory from './screens/AddCategory'
import Brands from './screens/Brands'
import AddBrand from './screens/AddBrand'
import AddProduct from './screens/AddProduct'
import Customers from './screens/Customers'

function App() {
  return (
    <div className='container-fluid'>
      <Routes>
        <Route path='/' element={<Login />} />
        <Route path='login' element={<Login />} />
        <Route path='register' element={<Register />} />
        <Route path='home' element={<Home />} />
        <Route path='/category' element={<Categories />} />
        <Route path='/add-category' element={<AddCategory />} />
        <Route path='/order' element={<Orders />} />
        <Route path='/user' element={<Customers />} />
        <Route path='/product' element={<Products />} />
        <Route path='/add-product' element={<AddProduct />} />
        <Route path='/brand' element={<Brands />} />
        <Route path='/add-brand' element={<AddBrand />} />
      </Routes>

      <ToastContainer />
    </div>
  )
}

export default App
