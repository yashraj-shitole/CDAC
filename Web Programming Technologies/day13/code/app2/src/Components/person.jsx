function Person() {
  // data
  const firstName = 'steve'
  const lastName = 'jobs'
  const company = 'Apple'
  const employeeNo = 0

  return (
    <div>
      <h1>Person</h1>
      <div>First Name: {firstName}</div>
      <div>Last Name: {lastName}</div>
      <div>Company: {company}</div>
      <div>Employee No: {employeeNo}</div>
    </div>
  )
}

export default Person
