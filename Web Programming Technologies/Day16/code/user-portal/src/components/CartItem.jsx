import { useState } from 'react'
import { createUrl } from '../utils'

function CartItem({ item, index, onUpdateQuantity }) {
  const [quantity, setQuantity] = useState(item['quantity'])

  const increment = () => {
    setQuantity(quantity + 1)
    onUpdateQuantity(quantity + 1)
  }

  const decrement = () => {
    setQuantity(quantity - 1)
    onUpdateQuantity(quantity - 1)
  }

  return (
    <tr>
      <td>{index + 1}</td>
      <td>
        <img
          src={createUrl(item['image'])}
          style={{ height: 50, width: 50 }}
          alt=''
        />
      </td>
      <td>{item['title']}</td>
      <td>{item['price']}</td>
      <td>
        <button onClick={increment} className='btn btn-sm btn-success'>
          +
        </button>
        <span
          style={{ display: 'inline-block', width: 40, textAlign: 'center' }}
        >
          {quantity}
        </span>
        <button onClick={decrement} className='btn btn-sm btn-success'>
          -
        </button>
      </td>
      <td>{item['price'] * item['quantity']}</td>
    </tr>
  )
}

export default CartItem
