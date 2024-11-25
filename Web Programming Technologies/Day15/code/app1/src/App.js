import { Link, Route, Routes } from 'react-router-dom'
import Screen1 from './screens/Screen1'
import Screen2 from './screens/Screen2'
import Screen3 from './screens/Screen3'
import Screen4 from './screens/Screen4'

function App() {
  return (
    <div className='container'>
      <h1>App</h1>

      <h3>Using anchor tag</h3>
      <div>
        <a href='screen1'>Screen1</a>
      </div>
      <div>
        <a href='screen2'>Screen2</a>
      </div>
      <div>
        <a href='screen3'>Screen3</a>
      </div>
      <div>
        <a href='screen4'>Screen4</a>
      </div>

      <hr />

      <h3>Using Link tag</h3>
      <div>
        <Link to='/screen1'>Screen1</Link>
      </div>
      <div>
        <Link to='/screen2'>Screen2</Link>
      </div>
      <div>
        <Link to='/screen3'>Screen3</Link>
      </div>
      <div>
        <Link to='/screen4'>Screen4</Link>
      </div>
      <hr />

      <Routes>
        <Route path='screen1' element={<Screen1 />} />
        <Route path='screen2' element={<Screen2 />} />
        <Route path='screen3' element={<Screen3 />} />
        <Route path='screen4' element={<Screen4 />} />
      </Routes>
    </div>
  )
}

export default App
