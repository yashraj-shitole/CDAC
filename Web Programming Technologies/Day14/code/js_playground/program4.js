// function testFunction() {
//   return new Promise(() => {
//     console.log('inside promise')
//   })
// }

async function testFunction() {
  return 10
}

const value = testFunction()
console.log(`value = ${value}`)
