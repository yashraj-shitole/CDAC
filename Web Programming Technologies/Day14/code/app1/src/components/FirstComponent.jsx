import Person from './Person'

function FirstComponent() {
  return (
    <div>
      <h1>First Component</h1>
      <Person firstName='person1' lastName='person1' email='person1@test.com' />
      <Person firstName='person2' lastName='person2' email='person2@test.com' />
    </div>
  )
}

export default FirstComponent
