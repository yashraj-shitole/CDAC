import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import CategoryRow from "../Components/CategoryRow";
import Navbar from "../Components/Navbar";
import { getCategoryList } from "../util/category";

const Category = () => {

    const [categories, setCategories] = useState([])

    const onLoadCategories = async () => {
      const result = await getCategoryList()
      if (result['status'] == 'success') {
        setCategories(result['data'])
      } else {
        toast.error(result['error'])
      }
    }
  
    useEffect(() => {
      onLoadCategories()
    }, [])

  return (

    <div>
      <Navbar />
      <div className='flex flex-col items-center'>
        <h2 className='text-3xl p-3 font-bold'>Categories</h2>

        <Link className="border  rounded-full w-fit border shadow-[#38383860] shadow-md hover:bg-[#222831] hover:text-white  px-5 py-2 font-extrabold border-accent" to='/addcategory'>
          Add
        </Link>
        {categories.length == 0 && (
          <h3 className='m-3'>
            There are no categories. Please use add button to add one.
          </h3>
        )}

        <div className="flex p-10 w-full">

        
        {categories.length > 0 && (
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
              {categories.map((category,i) => {
                return (
                  <CategoryRow key={i}
                    id={category['id']}
                    title={category['title']}
                    details={category['details']}
                    onDelete={onLoadCategories}
                  />
                )
              })}
            </tbody>
          </table>
        )}

</div>
      </div>
    </div>

  )
};

export default Category;
