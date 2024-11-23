import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { getBrandList } from "../util/brands";
import { getCategoryList } from "../util/category";
import { addProduct } from "../util/product";

export const AddProduct = () => {
    const [categories, setCategories] = useState([])
    const [brands, setBrands] = useState([])
  
    const [title, setTitle] = useState('')
    const [details, setDetails] = useState('')
    const [tags, setTags] = useState('')
    const [price, setPrice] = useState('')
    const [categoryId, setCategoryId] = useState('')
    const [brandId, setBrandId] = useState('')
    const [image, setImage] = useState(null)
  
    const navigate = useNavigate()
  
    const loadCategoriesAndBrands = async () => {
      const brandsResult = await getBrandList()
      if (brandsResult['status'] == 'success') {
        setBrands(brandsResult['data'])
      }
  
      const categoriesResult = await getCategoryList()
      if (categoriesResult['status'] == 'success') {
        setCategories(categoriesResult['data'])
      }
    }
  
    useEffect(() => {
      loadCategoriesAndBrands()
    }, [])
  
    const onSave = async () => {
      if (title.length == 0) {
        toast.warn('Please enter title')
      } else if (details.length == 0) {
        toast.warn('Please enter details')
      } else if (tags.length == 0) {
        toast.warn('Please enter tags')
      } else if (price.length == 0) {
        toast.warn('Please enter price')
      } else if (categoryId.length == 0) {
        toast.warn('Please select category')
      } else if (brandId.length == 0) {
        toast.warn('Please select brand')
      } else if (!image) {
        toast.warn('Please select image')
      } else {
        const result = await addProduct(
          title,
          details,
          categoryId,
          brandId,
          price,
          tags,
          image
        )
        if (result['status'] == 'success') {
          toast.success('Successfully added a product')
          navigate(-1)
        } else {
          toast.error(result['error'])
        }
      }
    }
  
    const onCancel = () => {
      navigate(-1)
    }
  
    return (
      <div>
        <div className='flex flex-col p-5 items-center justify-center'>
          <h2 className='text-3xl p-3 font-bold'>Add Product</h2>
  
          <div className=" flex flex-col w-full md:w-fit m-2 bg-[#EEEEEE] border  p-10 rounded-2xl gap-5 shadow-[#38383860] shadow-md">

              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Title</label>
                <input
                  onChange={(e) => setTitle(e.target.value)}
                  type='text'
                  className="border border-[#38383850] rounded-full px-3 p-1 "
                />
              </div>
           
      
          <div className="felx gap-5">
              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Category</label>
                <select
                  onChange={(e) => setCategoryId(e.target.value)}
                  className="border border-[#38383850] rounded-full px-3 p-1 "
                >
                  {categories.map((category,i) => {
                    return (
                      <option key={i} value={category['id']}>{category['title']}</option>
                    )
                  })}
                </select>
            </div>

              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Brand</label>
                <select
                  onChange={(e) => setBrandId(e.target.value)}
                  className="border border-[#38383850] rounded-full px-3 p-1 "
                >
                  {brands.map((brand,i) => {
                    return <option key={i} value={brand['id']}>{brand['title']}</option>
                  })}
                </select>
            </div>

            </div>

  
          <div className='flex  gap-5'>
              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Tags</label>
                <input
                  onChange={(e) => setTags(e.target.value)}
                  type='text'
                  className="border border-[#38383850] rounded-full px-3 p-1 "
                />
            </div>
              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Price</label>
                <input
                  onChange={(e) => setPrice(e.target.value)}
                  type='number'
                  className="border border-[#38383850] rounded-full px-3 p-1 "
                />
            </div>
          </div>
  
          <div >
              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Details</label>
                <textarea
                  onChange={(e) => setDetails(e.target.value)}
                  rows='5'
                  className="border border-[#38383850] rounded-2xl px-3 p-1 "
                />
              </div>
          </div>
  
              <div className="flex flex-col gap-2">
                <label className="font-extrabold" htmlFor=''>Image</label>
                <input
                  onChange={(e) => {
                    // get the first image selected by user
                    setImage(e.target.files[0])
                  }}
                  type='file'
                  className="w-fit border border-[#38383850] rounded-full px-3 p-1 "
                  accept='image/*'
                />
          </div>
  
            <div className='felx gap-10 '>
              <button onClick={onSave} className="px-3 py-1 rounded-full border border-[#1f9c00] hover:bg-[#1f9c00] hover:text-white ">
                Save
              </button>

              <button onClick={onCancel} className="px-3 py-1 rounded-full border border-[#ff0000] hover:bg-[#ff0000] hover:text-white ">
                Cancel
              </button>
              
            </div>
        </div>
      </div>

      </div>
    )
  }

  
export default AddProduct