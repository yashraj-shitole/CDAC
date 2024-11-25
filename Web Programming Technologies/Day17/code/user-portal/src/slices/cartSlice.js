import { createSlice } from '@reduxjs/toolkit'

const cartSlice = createSlice({
  name: 'cart',
  initialState: {
    itemCount: 0,
  },
  reducers: {
    addProduct: (state) => {
      state.itemCount += 1
    },
    deleteProduct: (state) => {
      state.itemCount -= 1
    },
  },
})

export const { addProduct, deleteProduct } = cartSlice.actions
export default cartSlice.reducer
