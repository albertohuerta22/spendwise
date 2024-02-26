import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux'; // Import useSelector hook
import { logout } from '../redux/actions/authActions';

function NavBar() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const isLoggedIn = useSelector((state) => state.auth.isLoggedIn); // Get isLoggedIn state from Redux

  const handleLogout = () => {
    dispatch(logout());
    navigate('/login');
  };

  return (
    // Render the navigation bar only if the user is logged in
    isLoggedIn && (
      <nav>
        <ul>
          <li>
            <Link to="/dashboard">Dashboard</Link>
          </li>
          <li>
            <button onClick={handleLogout}>Logout</button>
          </li>
        </ul>
      </nav>
    )
  );
}

export default NavBar;
