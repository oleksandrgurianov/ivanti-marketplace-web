import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import './AppDetails.css'

// components
import axios from 'axios'


const AppDetails = () => {
  let params = useParams();

  const [application, setApplication] = useState({});
  const [version, setVersion] = useState("1.0");

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
  const deleteApplication = () => {
    axios.delete(`http://localhost:8080/application/${params.appName}`)
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


  return (
    <div className='app-container'>
      <div className='sidebar'>
        <img className='icon' alt='' src={application.icon}/>
        <h4>Created By:</h4>
        <h5>Lars Kluijtmans</h5>
        <h4>Version:</h4>

        <select className={"versions"} value={version} onChange={e=>setVersion(e.target.value)}>
          {application.versions != null &&
              application.versions.map((version) => (
                  <option>{parseFloat(version.number).toFixed(1)}</option>
              ))}
        </select>

        <Link to={`/addVersion/minor/${application.name}`}>Add minor version</Link>
        | <Link to={`/addVersion/major/${application.name}`} >Add major version</Link>
        | <Link to={`/updateVersion/${application.name}/${version}`} >Update version</Link>

        <h4>Categories:</h4>
        <div className='categories'>
          <a href=''>category </a>
          <a href=''>category </a>
          <a href=''>category </a>
          <a href=''>category</a>
        </div>
      </div>
      <div className='main'>
        <div className='app'>
          <h1>{application.name}</h1>
          <div className='buttons'>
            <Link to={`/creator/update/${application.name}`}>Update App</Link> | <Link to={`/creator/1`} onClick={deleteApplication}>Delete App</Link>
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
                {application.images != null &&
                application.images.map((image) => (
                  <p key={image}><img src={image} /></p>
                ))}
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