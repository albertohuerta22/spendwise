// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './screens/LoginPage';
import DashboardPage from './screens/DashboardPage';
import NavBar from './components/Navbar';
import { useDispatch, useSelector } from 'react-redux'; // Import useDispatch and useSelector hooks
import { logout } from './redux/actions/authActions';

function App() {
  const dispatch = useDispatch();
  const isLoggedIn = useSelector((state) => state.auth.isLoggedIn); // Get isLoggedIn state from Redux

  const handleLogout = () => {
    dispatch(logout());
  };

  return (
    <Router>
      <NavBar isLoggedIn={isLoggedIn} handleLogout={handleLogout} />
      {/* Pass isLoggedIn and handleLogout as props */}
      <Routes>
        {isLoggedIn && <Route path="/dashboard" element={<DashboardPage />} />}
        {/* Render DashboardPage route only if user is logged in */}
        <Route path="/" element={<LoginPage />} />
        <Route path="/login" element={<LoginPage />} />
      </Routes>
    </Router>
  );
}

export default App;
