import { Link, useNavigate } from "react-router-dom";

const Navbar = () => {


    const navigate=useNavigate()

    const onLogout = () => {
        // cleat the session storage
        sessionStorage.removeItem('name')
        sessionStorage.removeItem('token')
        sessionStorage.removeItem('email')
        sessionStorage.removeItem('phone')
    
        // go to login screen
        navigate('/')
      }


  return (

    <div className="flex justify-between items-center p-5 h-20 border-b-2">
        <div>
            Logo
        </div>

        <div className="h-full">
            <ul className="flex gap-2 items-center  justify-center h-full">
                <Link to={'/home'} className="hover:border-b-2 border-accent px-1">Home</Link>
                <Link to={'/categories'} className="hover:border-b-2 border-accent px-1">Categories</Link>
                <Link to={'/products'} className="hover:border-b-2 border-accent px-1">Products</Link>
                <Link to={'/users'} className="hover:border-b-2 border-accent px-1">Users</Link>
                <Link to={'/orders'} className="hover:border-b-2 border-accent px-1">Orders</Link>
                <button onClick={onLogout} className="p-3 rounded-full border border-[#38383860] hover:bg-[#222831] hover:text-white "><h1>Logout</h1></button>
            </ul>
        </div>
    </div>
  )
};

export default Navbar;
