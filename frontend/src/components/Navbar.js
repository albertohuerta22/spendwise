import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

function NavBar({ isLoggedIn, handleLogout }) {
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    handleLogout();
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
            <button onClick={handleLogoutClick}>Logout</button>
          </li>
        </ul>
      </nav>
    )
  );
}

export default NavBar;
