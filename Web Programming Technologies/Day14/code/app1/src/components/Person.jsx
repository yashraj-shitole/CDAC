function Person(props) {
  return (
    <div>
      <h2>Person</h2>
      <div>first name = {props.firstName}</div>
      <div>last name = {props.lastName}</div>
      <div>email = {props.email}</div>
    </div>
  )
}

export default Person
