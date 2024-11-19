import { useState } from 'react'

function Counter() {
  const [counter, setCounter] = useState(0)

  function onIncrement() {
    setCounter(counter + 1)
  }

  function onDecrement() {
    setCounter(counter - 1)
  }

  return (
    <div>
      <h2>Counter</h2>
      <button onClick={onIncrement} className='btn btn-success'>
        Increment
      </button>
      <span
        style={{ width: 100, textAlign: 'center', display: 'inline-block' }}
      >
        {counter}
      </span>
      <button onClick={onDecrement} className='btn btn-danger'>
        Decrement
      </button>
    </div>
  )
}

export default Counter
