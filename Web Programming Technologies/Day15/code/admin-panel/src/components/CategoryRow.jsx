import { toast } from 'react-toastify'
import { deleteCategory } from '../services/category'

function CategoryRow({ id, title, details, onDelete }) {
  const onDeleteCategory = async () => {
    const result = await deleteCategory(id)
    if (result['status'] == 'success') {
      toast.success('Successfully deleted selected category')

      // call the callback function to refresh the category list
      onDelete()
    } else {
      toast.error(result['error'])
    }
  }

  return (
    <tr>
      <td>{id}</td>
      <td>{title}</td>
      <td>{details}</td>
      <td>
        <button className='btn btn-success btn-sm'>Edit</button>
        <button
          onClick={onDeleteCategory}
          className='btn btn-danger btn-sm ms-2'
        >
          Delete
        </button>
      </td>
    </tr>
  )
}

export default CategoryRow
