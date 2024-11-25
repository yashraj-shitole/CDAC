const car = {
  model: 'triber',
  company: 'renault',
  price: 10,
}

// object destructuring
// - destructure the object into individual variables
// - the below line will create 3 variables model, company and price
//   with values from car object's respective properties
// - since average does not exist in car object, the value in average
//   variable will be undefined
const { model, company, price, average } = car

console.log(`model = ${model}`)
console.log(`company = ${company}`)
console.log(`price = ${price}`)
console.log(`average = ${average}`)

// object destructuring
const { name, email } = {
  name: 'steve jobs',
  email: 'steve@apple.com',
}

console.log(`name = ${name}, email = ${email}`)
