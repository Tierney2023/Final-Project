import { Link } from 'react-router-dom';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import "./Navbar.css";


export const Navbar = ({ setResults, sorted }) => {

  const [input, setInput] = useState("");
  const navigate = useNavigate();

  const fetchData = (value) => {
    fetch("https://example-data.draftbit.com/books?_sort=$(sorted)")
      .then((response) => response.json())
      .then((json) => {
        const results = json.filter((item) => {
          return (
            value &&
            item &&
            item.title &&
            item.title.toLowerCase().includes(value)

          );
        });
        setResults(results);

      });
  };


  const handleChange = (value) => {
    setInput(value);
    fetchData(value);
  };


  return (


    <div className="navbar">
      <nav className="bar">
        <h3 className="logo">Bookmark</h3>
        <div className="search_bar">
          <input
            className="search"
            type="search" id="search"
            onClick={() => navigate(`/collection`)}
            onChange={(e) => handleChange(e.target.value)} />
        </div>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/collection">Collection</Link></li>
          <li><Link to="/account">Account</Link></li>
        </ul>
      </nav>
    </div >
  )
}

export default Navbar;