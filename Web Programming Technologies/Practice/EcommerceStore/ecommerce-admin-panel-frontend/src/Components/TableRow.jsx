import { toast } from 'react-toastify'
import { deleteCategory } from '../util/category'


function TableRow({ id, title, details, onDelete }) {


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
          onClick={onDelete(id)}
          >
          Delete
        </button>
        </div>
      </td>
    </tr>
  )
}

export default TableRow
