import { Outlet } from 'react-router-dom'
import Navbar from '../components/Navbar'

function Home() {
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
