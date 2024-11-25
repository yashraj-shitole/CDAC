import { useSelector } from 'react-redux'

function SecondScreen() {
  const value = useSelector((state) => state.counter.value)

  return (
    <div>
      <h1>Second Screen</h1>
      <div>Counter: {value}</div>
    </div>
  )
}

export default SecondScreen
