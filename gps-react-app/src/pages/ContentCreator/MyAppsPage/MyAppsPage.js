import React, { useEffect, useState } from 'react'
import Application from './components/Application'
import axios from 'axios';
import '../../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import { useParams, Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown, faCirclePlus} from '@fortawesome/free-solid-svg-icons'
import ApplicationBasicCreator from './ApplicationBasicCreator';
import loading from "../../../images/loading.gif";

const MyAppsPage = () => {
    const [applicationsArray, setApplicationsArray] = useState({});

    const {username} = useParams();

    const getApplications = () => {
        axios.get(`http://localhost:8080/application/creator/${username}`)
            .then(res => {
                setApplicationsArray(res.data);
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        getApplications();
    }, []);

    return (
        <>
            <div className='my-apps'>
                <div className='my-apps-controls' style={{justifyContent: "normal"}}>
                    <h1 className='title'>My Apps</h1>
                    <Link to='/creator/username/myApps/addApplication'><FontAwesomeIcon className='add-icon' icon={faCirclePlus}/></Link>
                </div>
                <hr/>
                {applicationsArray.myApplications ? (
                    <div className='my-apps-list'>
                        {applicationsArray.myApplications && applicationsArray.myApplications.map((app) => (
                            <ApplicationBasicCreator key={app.name} name={app.name} icon={app.icon}/>
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
