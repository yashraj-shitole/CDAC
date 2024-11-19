import Car from './Car'

function SecondComponent() {
  const car = {
    model: 'triber',
    company: 'renault',
    price: 10,
  }

  return (
    <div>
      <h2>Second Component</h2>
      <Car model={car.model} company={car.company} price={car.price} />
    </div>
  )
}

export default SecondComponent
