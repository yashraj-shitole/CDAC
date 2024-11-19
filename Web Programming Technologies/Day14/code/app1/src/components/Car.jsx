// object destructuring
function Car({ model, company, price }) {
  // object destructuring
  // const { model, company, price } = props

  return (
    <div>
      <h3>Car</h3>
      <div>model = {model} </div>
      <div>company = {company}</div>
      <div>price = {price}</div>
    </div>
  )
}

export default Car
