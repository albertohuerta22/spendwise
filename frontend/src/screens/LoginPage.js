import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { login } from '../redux/actions/authActions';
import { useNavigate } from 'react-router-dom'; // Import useNavigate hook

function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const dispatch = useDispatch();
  const navigate = useNavigate(); // Initialize useNavigate hook

  const handleLogin = () => {
    dispatch(login(username, password)).then(() => {
      navigate('/dashboard'); // Navigate to dashboard after successful login
    });
  };

  return (
    <div>
      <h1>Login Page</h1>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default LoginPage;
