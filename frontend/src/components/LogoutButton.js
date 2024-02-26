import React from 'react';
import { useDispatch } from 'react-redux';
import { logout } from '../actions/authActions';

function LogoutButton() {
  const dispatch = useDispatch();

  const handleLogout = () => {
    // Dispatch the logout action
    dispatch(logout());
  };

  return <button onClick={handleLogout}>Logout</button>;
}

export default LogoutButton;
