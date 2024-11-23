import { toast } from 'react-toastify'
import { delete } from '../util/category'


function Row({ id, title, details, onDelete }) {
  const onDelete = async () => {
    const result = await delete(id)
    if (result['status'] == 'success') {
      toast.success('Successfully deleted selected category')

      onDelete()
    } else {
      toast.error(result['error'])
    }
  }

  return (
    <tr>
      <td className="border-2 border-[#31363F] border-collapse">{id}</td>
      <td className="border-2 border-[#31363F90] border-collapse">{title}</td>
      <td className="border-2 border-[#31363F90] border-collapse">{details}</td>
      <td className="border-2 border-[#31363F90] border-collapse border-r-[#31363F]">
        <div className='flex justify-evenly'>

        <button
          className="px-3 py-1 rounded-full border border-[#1f9c00] hover:bg-[#1f9c00] hover:text-white "
          >Edit</button>
        <button
          className="px-3 py-1 rounded-full border border-[#ff0000] hover:bg-[#ff0000] hover:text-white " 
          onClick={onDeleteCategory}
          >
          Delete
        </button>
        </div>
      </td>
    </tr>
  )
}

export default Row
