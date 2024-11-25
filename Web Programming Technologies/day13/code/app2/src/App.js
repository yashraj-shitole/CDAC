import Car from './Components/car'
import FirstComponent from './Components/firstComponent'
import Person from './Components/person'
import Persons from './Components/persons'
import SecondComponent from './Components/secondComponent'
import Cars from './Components/cars'

function App() {
  return (
    <div>
      <h1>App</h1>
      {/* <FirstComponent />
      <SecondComponent /> */}
      <Person />
      <Person />
      <Person />
      <Person />
      <Car />
      {/* <Persons /> */}
      <Cars />
    </div>
  )
}

export default App
