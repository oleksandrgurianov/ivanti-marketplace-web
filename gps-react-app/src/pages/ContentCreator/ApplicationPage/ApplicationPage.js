import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { FaStar } from 'react-icons/fa'
import '../../../styles/ContentCreator/ApplicationPage.css'

// components
import axios from 'axios'


const ApplicationPage = () => {
  let params = useParams();

  const [application, setApplication] = useState({});
  const [version, setVersion] = useState("1.0");

  const getApplication = () => {
    axios.get(`http://localhost:8080/application/details/${params.name}`)
    .then(response => {
      setApplication(response.data);
      console.log(response.data);
    })
    .catch(err => {
      console.log(err);
    })
  }
  const deleteApplication = () => {
    axios.delete(`http://localhost:8080/application/${params.name}`)
        .then(response => {
          setApplication(response.data);
          console.log(response.data);
        })
        .catch(err => {
          console.log(err);
        })
  }
  const deleteVersion = () => {
    axios.post(`http://localhost:8080/application/version/delete`, {
          'appName': params.appName,
          'number': version
        })
        .then(response => {
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
        <div className='buttons-left' >
          <div className="button-left">
            <Link  to={`/creator/1/myApps/${application.name}/addMinorVersion`}>Add minor version</Link> | <Link to={`/creator/1/myApps/${application.name}/addMajorVersion`}>Add major version</Link>
          </div>

          {/*
          Updating and deleting versions
          <Link  to={`/updateVersion/${application.name}/${version}`}>Update</Link> | <Link to= {`/app/${application.name}`} onClick={deleteVersion}>Delete</Link>*/}
        </div>


        <h4>Categories:</h4>
        <div className='categories'>
          <a href='src/pages/AppCatalogue/index'>category </a>
          <a href='src/pages/AppCatalogue/index'>category </a>
          <a href='src/pages/AppCatalogue/index'>category </a>
          <a href='src/pages/AppCatalogue/index'>category</a>
        </div>


      </div>
      <div className='main'>
        <div className='app'>
          <h1>{application.name}</h1>
          <div className='buttons'>
            <Link to={`/creator/1/myApps/${application.name}/updateApplication`}>Update App</Link> | <Link to={`creator/1/myApps`} onClick={deleteApplication}>Delete App</Link>
          </div>
          <hr />
          <div className='screenshots'>
            <h2>Screenshots:</h2>
            <ul className='screenshot-list'>
              {application.images != null &&
                  application.images.map((image) => (
                      <li key={image}><img src={image} /></li>
                  ))}
            </ul>
            <hr />
          </div>
          <div>
            <h2>Reviews:</h2>
            <div className={"reviews"}>
              {application.reviews != null &&
                  application.reviews.map(review =>
                      <div className={"card"}>
                        <p className={"text"}><b>{review.title}</b></p>
                        <p className={"text"}>
                          {[...Array(5)].map((star, i) => {
                            const ratingValue = i + 1;
                            return(
                                <label>
                                  <FaStar
                                      className={"star"}
                                      color={ratingValue<=review.rating ? "#4F4746": "#e4e5e9" }
                                      size={15}
                                  />
                                </label>
                            )
                          })}
                        </p>
                        <p className={"description"}>{review.description}</p>
                      </div>
                  )}
            </div>
            <hr />
          </div>
          <div className='description-details'>
            <h2>Description:</h2>
            <p>{application.description}</p>
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

export default ApplicationPage