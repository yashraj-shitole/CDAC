function Row({ id, title, details, onDelete }) {
  return (
    <tr>
      <td>{id}</td>
      <td>{title}</td>
      <td>{details}</td>
      <td>
        <button className='btn btn-success btn-sm'>Edit</button>
        <button
          onClick={() => {
            onDelete(id)
          }}
          className='btn btn-danger btn-sm ms-2'
        >
          Delete
        </button>
      </td>
    </tr>
  )
}

export default Row
