import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import LoginPage from './screens/LoginPage';
import DashboardPage from './screens/DashboardPage';

function App() {
  return (
    <Router>
      <div>
        <Route path="/login" component={LoginPage} />
        <Route path="/dashboard" component={DashboardPage} />
      </div>
    </Router>
  );
}

export default App;
