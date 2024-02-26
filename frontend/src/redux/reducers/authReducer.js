import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  user: null,
  isLoggedIn: false,
  error: null, // Add error state to store login failure error message
};

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    loginSuccess(state, action) {
      state.user = action.payload;
      state.isLoggedIn = true;
      state.error = null; // Clear any previous login errors
    },
    loginFailure(state, action) {
      state.user = null;
      state.isLoggedIn = false;
      state.error = action.payload; // Set error message from action payload
    },
    logout(state) {
      state.user = null;
      state.isLoggedIn = false;
      state.error = null; // Clear any previous errors on logout
    },
  },
});

export const { loginSuccess, loginFailure, logout } = authSlice.actions;
export default authSlice.reducer;
