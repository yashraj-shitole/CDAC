
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import './App.css'
import AddCategory from './Screens/AddCategory'
import Category from './Screens/Category'
import Home from './Screens/Home'
import Login from './Screens/Login'
import Register from './Screens/Register'


function App() {

  return (
    <>    
        <BrowserRouter>
        
          <Routes>
            <Route path="/" element={<Login/>}/>
            <Route path="/signup" element={<Register/>}/>

            <Route path="/home" element={<Home/>}/>
            <Route path="/categories" element={<Category/>}/>
            <Route path="/addcategory" element={<AddCategory/>}/>
            
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
