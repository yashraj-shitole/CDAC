function function1() {
  console.log('inside function1')
}

// function1()

// create a variable of type number
const num = 200
console.log(`num = ${num}, type = ${typeof num}`)

// create a variable of type function
// function reference or function alias
const myFunction = function1
console.log(`myFunction = ${myFunction}`)
console.log(`type of myFunction = ${typeof myFunction}`)
myFunction()
