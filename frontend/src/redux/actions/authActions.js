import { loginSuccess, logout as logoutAction } from '../reducers/authReducer';

export const login = (username, password) => {
  return async (dispatch) => {
    // Dispatch the login success action with the user data
    dispatch(loginSuccess({ id: 1, username, email: 'user@example.com' }));
  };
};

export const logout = () => {
  return async (dispatch) => {
    dispatch(logoutAction());
  };
};
