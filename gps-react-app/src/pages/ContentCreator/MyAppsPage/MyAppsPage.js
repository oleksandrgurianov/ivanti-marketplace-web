import React, { useEffect, useState } from 'react'
import axios from 'axios';
import '../../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCirclePlus } from '@fortawesome/free-solid-svg-icons'
import loading from "../../../images/loading.gif";
import useAuth from '../../../hooks/useAuth';
import BasicApplication from '../../../components/BasicApplication';

const MyAppsPage = () => {

    const { auth } = useAuth();
    const authorisation = {
        headers: { Authorization: 'Bearer ' + auth?.accessToken }
    }
    const [applications, setApplications] = useState([]);

    const getApplicationsByCreator = () => {
        const URL = `http://localhost:8080/application/creator/${auth?.decoded?.sub}`

        axios.get(URL, authorisation)
        .then(res => {
            setApplications(res.data.myApplications)
        })
        .catch(err => {
            console.log(err)
        })
    }

    useEffect(() => {
        getApplicationsByCreator()
    }, [])

    return (
        <>
            <div className='my-apps'>
                <div className='my-apps-controls' style={{justifyContent: "normal"}}>
                    <h1 className='title'>My Apps</h1>
                    <Link to='/creator/add-app'><FontAwesomeIcon className='add-icon' icon={faCirclePlus}/></Link>
                </div>
                <hr/>
                {applications.length !== 0 ? (
                    <div className='my-apps-list'>
                        {applications?.map((app) => (
                            <BasicApplication key={app.name} name={app.name} icon={app.icon}/>
                        ))}
                    </div>
                ) : (
                    <img className={"loading-apps"} src={loading}/>
                )}
            </div>
        </>
    )
}

export default MyAppsPage;
