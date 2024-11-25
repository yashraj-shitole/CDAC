function Persons() {
  // array of strings
  const persons = ['Steve Jobs', 'Elon Musk', 'Bill Gates', 'Larry Page']

  return (
    <div>
      <h1>Persons</h1>
      <div>
        {persons.map((person) => {
          return (
            <div
              style={{
                color: 'black',
                fontSize: 20,
                margin: 20,
                borderStyle: 'solid',
                borderColor: 'black',
                padding: 20,
                backgroundColor: 'beige',
              }}
            >
              {person}
            </div>
          )
        })}
      </div>
    </div>
  )
}

export default Persons
