import './cars.css'

function Cars() {
  // array of objects
  const cars = [
    { model: 'nano', company: 'tata', price: 2.5 },
    { model: 'i20', company: 'hyundai', price: 12 },
    { model: 'cyber truck', company: 'tesla', price: 200 },
  ]

  return (
    <div>
      <h2>Cars</h2>
      <div>
        {cars.map((car) => {
          return (
            <div className='car'>
              <div>model: {car.model}</div>
              <div>company: {car.company}</div>
              <div>price: {car.price}</div>
            </div>
          )
        })}
      </div>
    </div>
  )
}

export default Cars
