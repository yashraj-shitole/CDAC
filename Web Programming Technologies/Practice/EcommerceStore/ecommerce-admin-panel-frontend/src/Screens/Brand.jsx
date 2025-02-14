import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { deleteBrand, getBrandList } from "../util/brands";
import TableRow from "../Components/TableRow";
import { deleteCategory } from "../util/category";


const Brand = () => {

    const [brands, setBrands] = useState([])

    const onLoadbrands = async () => {
      const result = await getBrandList()
      if (result['status'] == 'success') {
        setBrands(result['data'])
      } else {
        toast.error(result['error'])
      }
    }
  
    useEffect(() => {
      onLoadbrands()
    }, [])


    
            const onDeleteBrand = async (id) => {
                const result = await deleteBrand(id)
                if (result['status'] == 'success') {
                  toast.success('Successfully deleted selected category')
                    onLoadbrands()
                } else {
                  toast.error(result['error'])
                }
              }
        

  return<div>
  <div className='flex flex-col items-center'>
    <h2 className='text-3xl p-3 font-bold'>Brands</h2>

    <Link className=" rounded-full w-fit border shadow-[#38383860] shadow-md hover:bg-[#222831] hover:text-white  px-5 py-2 font-extrabold border-accent" to='/home/addbrand'>
      Add
    </Link>
    {brands.length == 0 && (
      <h3 className='m-3'>
        There are no brands. Please use add button to add one.
      </h3>
    )}

    <div className="flex p-10 w-full">

    
    {brands.length > 0 && (
      <table className='w-full mt-5 border-2 border-[#31363F] border-collapse'>
        <thead>
          <tr>
            <th className="border-2 border-[#31363F] border-collapse">Sr. No</th>
            <th  className="border-2 border-[#31363F] border-collapse">Title</th>
            <th  className="border-2 border-[#31363F] border-collapse">Details</th>
            <th  className="border-2 border-[#31363F] border-collapse">Actions</th>
          </tr>
        </thead>
        <tbody>
          {brands.map((category,i) => {
            return (
              <TableRow key={i}
                id={category['id']}
                title={category['title']}
                details={category['details']}
                onDelete={onDeleteBrand}
              />
            )
          })}
        </tbody>
      </table>
    )}

</div>
  </div>
</div>;
};

export default Brand;
