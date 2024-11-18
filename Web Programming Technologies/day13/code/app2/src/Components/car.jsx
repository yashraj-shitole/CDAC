function Car() {
  // object: collection of key-value pairs
  const car = {
    model: 'triber',
    company: 'renault',
    price: 10,
    color: 'silver',
    config: {
      average: 17,
      'fuel type': 'petrol',
    },
  }

  return (
    <div>
      <h2>Car</h2>
      <div>model: {car.model}</div>
      <div>company: {car['company']}</div>
      <div>price: {car.price}</div>
      <div>color: {car.color}</div>
      <div>Average: {car.config.average}</div>
      <div>Fuel Type: {car.config['fuel type']}</div>
    </div>
  )
}

export default Car
