import {
  loginSuccess,
  loginFailure,
  logout as logoutAction,
} from '../reducers/authReducer';

export const login = (username, password) => {
  return async (dispatch) => {
    try {
      // Simulate a successful login (replace with your actual login logic)
      const user = {
        id: 1,
        username: 'exampleUser',
        email: 'user@example.com',
      };

      // Dispatch the login success action with the user data
      dispatch(loginSuccess(user));
    } catch (error) {
      // Dispatch the login failure action with the error message
      dispatch(loginFailure('Login failed. Please check your credentials.'));
    }
  };
};

export const logout = () => {
  return async (dispatch) => {
    dispatch(logoutAction());
  };
};
