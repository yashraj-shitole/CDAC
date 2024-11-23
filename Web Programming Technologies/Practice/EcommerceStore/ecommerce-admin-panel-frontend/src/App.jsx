
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import './App.css'
import AddCategory from './Screens/AddCategory'
import Category from './Screens/Category'
import Home from './Screens/Home'
import Login from './Screens/Login'
import Register from './Screens/Register'
import Products from './Screens/Products'
import Brand from './Screens/Brand'
import { AddProduct } from './Screens/AddProduct'
import Orders from './Screens/Orders'
import Customers from './Screens/Custoers'
import AddBrand from './Screens/AddBrand'


function App() {

  return (
    <>    
        <BrowserRouter>
        
          <Routes>
            <Route path="/" element={<Login/>}/>
            <Route path="/signup" element={<Register/>}/>

            <Route path="home" element={<Home/>}>
            
              <Route path="categories" element={<Category/>}/>
              <Route path="addcategory" element={<AddCategory/>}/>

              <Route path="products" element={<Products/>}/>
              <Route path="addproducts" element={<AddProduct/>}/>

              <Route path="Brand" element={<Brand/>}/>
              <Route path="addBrand" element={<AddBrand/>}/>
            
              <Route path="orders" element={<Orders/>}/>
              <Route path="customers" element={<Customers/>}/>
            
            </Route>

          </Routes>


          <ToastContainer
position="top-center"
autoClose={5000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
/>
        
        </BrowserRouter>


    </>
  )
}

export default App
