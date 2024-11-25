import Mobile from './Mobile'

function ThirdComponent() {
  const mobile = { model: 'iPhone 15 Pro Max', company: 'Apple', price: 200000 }

  return (
    <div>
      <h2>Third Component</h2>
      <Mobile
        model={mobile.model}
        company={mobile.company}
        price={mobile.price}
      />
    </div>
  )
}

export default ThirdComponent
