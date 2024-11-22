import { createUrl } from '../utils'

function ProductRow({ id, title, details, price, tags, image }) {
  return (
    <tr>
      <td>{id}</td>
      <td>
        <img src={createUrl(image)} alt='' style={{ width: 70, height: 70 }} />
      </td>
      <td>{title.length > 50 ? title.substr(0, 50) + '...' : title}</td>
      <td>{details.length > 50 ? details.substr(0, 50) + '...' : details}</td>
      <td>{price}</td>
      <td>{tags}</td>
      <td>
        <button className='btn btn-success btn-sm'>Edit</button>
        <button className='btn btn-danger btn-sm ms-3'>Delete</button>
      </td>
    </tr>
  )
}

export default ProductRow
