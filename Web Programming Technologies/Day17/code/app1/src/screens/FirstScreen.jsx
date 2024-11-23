import { useDispatch, useSelector } from 'react-redux'
import { decrement, increment } from '../slices/counterSlice'

function FirstScreen() {
  // get the counter from counter slice
  const value = useSelector((state) => state.counter.value)

  // get the dispatcher
  const dispatcher = useDispatch()

  const onIncrement = () => {
    dispatcher(increment())
  }

  const onDecrement = () => {
    dispatcher(decrement())
  }

  return (
    <div>
      <h1>First Screen</h1>

      <button onClick={onIncrement} className='btn btn-success'>
        Increment
      </button>
      <div>counter: {value}</div>
      <button onClick={onDecrement} className='btn btn-danger'>
        Decrement
      </button>
    </div>
  )
}

export default FirstScreen
