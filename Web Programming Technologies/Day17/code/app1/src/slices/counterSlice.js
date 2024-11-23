import { createSlice } from '@reduxjs/toolkit'

const counterSlice = createSlice({
  name: 'counter',
  initialState: {
    value: 0,
  },
  reducers: {
    // handle increment event (action) to increment the counter by 1
    increment: (state) => {
      state.value += 1
    },

    // handle decrement event (action) to decrement the counter by 1
    decrement: (state) => {
      state.value -= 1
    },
  },
})

// exporting two actions for other components to consume
export const { increment, decrement } = counterSlice.actions

// exporting the reducer (action handlers)
export default counterSlice.reducer
