import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios'
import useAuth from '../../hooks/useAuth';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown} from '@fortawesome/free-solid-svg-icons'

import ReviewList from '../Customer/ApplicationDetails/component/ReviewList';


const DetailedApplicationPage = () => {
    const { auth } = useAuth();
    const username = auth?.decoded?.sub;
    const [isCreator, setIsCreator] = useState(false)
    const [ownReview, setOwnReview ] = useState(null);

    useEffect(() => {
        checkRoleStatus()
    }, [auth])


    const params = useParams();
    const URL = `http://localhost:8080/application/${params.name}`

    const [application, setApplication] = useState({})
    const [version, setVersion] = useState("1.0")
    const [appLocation, setAppLocation] = useState('')

    const getApplication = () => {
        axios.get(URL)
        .then(res => {
            setApplication(res.data)
            setAppLocation(res.data.versions[0].appLocation)
        })
        .catch(err => {
            console.log(err)
        })
        
    }

    useEffect(() => {
        getApplication()
    }, [])

    const getReview = () => {
        axios.get(`http://localhost:8080/review/${username}/${params.name}`)
            .then(res => {
                setOwnReview(res.data);
            })
            .catch(err => {
                console.log(err.message);
                setOwnReview(null);
            });
    }

    useEffect(() => {
        getReview();
    }, [application])

    // useEffect(() => {
    //     console.log(application?.creator?.username)
    //     if (application?.creator?.username === auth?.decoded?.sub) {
    //         // setIsCreator(false)
    //         console.log("yay")
    //     } else {
    //         setIsCreator(false)
    //     }
    // }, [application])

    
    const checkRoleStatus = () => {
        auth?.roles?.map((role) => {
            if (role === "Creator") {
                setIsCreator(true) // TODO check if creator id matches application id
                // console.log(auth?.decoded?.sub)
            }
        })
    }

    const downloadApplication = async (e) => {
        e.preventDefault();

        try {
            console.log("METHOD STARTED");
            console.log(appLocation);
            console.log(application.name);
            const response = await axios.get(`http://localhost:8080/application/download/${appLocation}/${application.name}`);
            console.log("SUCCESSFUL");
        } catch (err) {
            console.log("Something went wrong...")
        }
    }

  return (
    <div className='app'>
        <div className='app-controls'>
            <img className='icon' alt='application logo' src={application.icon} />
            <h1>{application.name}</h1>
            { isCreator ? (
                <>
                    <Link className='edit-button' to={'/*'}>Edit</Link>
                    <Link className='delete-button' to={'/*'}>Delete</Link>
                </>
            ) : (
                <>
                    <Link className='delete-button' to={''}>
                        <span onClick={downloadApplication}>Download</span>
                    </Link>
                </>
            )}
        </div>
        <hr />
        <div className='app-version'>
            <h2>Version</h2>
            <div className='version-content'>
                <dropdown className='version-selector'>
                    <select value={version} onChange={(e) => setVersion(e.target.value)}>
                        {application?.versions?.map((version) => (
                            <option>{parseFloat(version.number).toFixed(1)}</option>
                        ))}
                    </select>
                    <FontAwesomeIcon className='dropdown-icon' icon={faCaretDown} />
                </dropdown>
                { isCreator ? (
                    <>
                        <Link className='version-button' to={'/*'}>Add minor version</Link>
                        <Link className='version-button' to={'/*'}>Add major version</Link>
                    </>
                ) : (null)}
            </div>
        </div>
        <hr />
        <div className='menu-wrapper'>
            <ul className='menu'>
                {application?.screenshots?.map((image) => (
                    <li className='item' key={image}><img src={image} /></li>
                ))}
            </ul>
        </div>
        <hr />
        <div className='ratings-header'>
            <h2>Ratings & Reviews</h2>
            <button className='see-all-button'>See All</button>
        </div>
        <div className='overall-rating'>
            <p className='rating-number'>{application.avgRating?.toFixed(1)}</p>
            <p>out of 5</p>
        </div>
        <ReviewList ownReview = {ownReview} reviews = {application?.reviews} app = {application?.name}/>
        <hr />
        <div className='app-description'>
            <h2>Description</h2>
            <p>{application.description}</p>
        </div>
    </div>
  )
}

export default DetailedApplicationPage