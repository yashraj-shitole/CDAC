import { Outlet, useNavigate } from 'react-router-dom'
import Navbar from '../components/Navbar'
import { useEffect } from 'react'

function Home() {
  const navigate = useNavigate()

  useEffect(() => {
    navigate('/home/products')
  }, [])

  return (
    <div>
      <Navbar />
      <hr />

      <div className='container'>
        <Outlet />
      </div>
    </div>
  )
}

export default Home
