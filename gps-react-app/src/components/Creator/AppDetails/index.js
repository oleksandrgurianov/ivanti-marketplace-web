import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import './AppDetails.css'

// components
import Title from '../../Title'
import axios from 'axios'

const AppDetails = () => {
  let params = useParams();

  const [application, setApplication] = useState({});
  
  const getApplication = () => {
    axios.get(`http://localhost:8080/application/details/${params.appName}`)
    .then(response => {
      setApplication(response.data);
      console.log(response.data);
    })
    .catch(err => {
      console.log(err);
    })
  }


  useEffect(() => {
    getApplication();
  }, []);

  // const screenshots = [...application.images]

  return (
    <div className='app-container'>
      <div className='sidebar'>
        <img className='icon' alt='' src={application.icon}/>
        <h4>Created By:</h4>
        <h5>Lars Kluijtmans</h5>
        <h4>Version:</h4>
        <h5>v2.3</h5>
        <h4>Categories:</h4>
        <div className='categories'>
          <a href=''>categorie </a>
          <a href=''>categorie </a>
          <a href=''>categorie </a>
          <a href=''>categorie</a>
        </div>
      </div>
      <div className='main'>
        <div className='app'>
          <h1>{application.name}</h1>
          <div className='buttons'>
            <Link to={`/creator/update/${application.name}`}>Update App</Link> | <Link to='/'>Delete App</Link>
          </div>
          <hr />
          <div className='description-details'>
            <h2>Description:</h2>
            <p>{application.description}</p>
            <hr />
          </div>
          <div className='screenshots'>
            <h2>Screenshots:</h2>
              <ul className='screenshot-list'>
                {/* {screenshots.map((image) => (
                  <p key={image}><img src={image} /></p>
                ))} */}
                <li><img src='https://drive.google.com/uc?export=view?&id=1rIr1Tcdjs2yRiUAhP0g81cQT7ILiaV-j' /></li>
                <li><img src='https://drive.google.com/uc?export=view?&id=14UK4dsvwMNOeRk5rQ6LtRGLnHPe72ToV' /></li>
                <li><img src='https://drive.google.com/uc?export=view?&id=1EzEOklCWRhiDu7cPSVv9qAqulTgHJbxz' /></li>
              </ul>
            <hr />
          </div>
          <div className='rating-section'>
            <h2>Ratings & Reviews:</h2>
            <p></p>
            <hr />
          </div>
        </div>
      </div>
    </div>
  )
}

export default AppDetails