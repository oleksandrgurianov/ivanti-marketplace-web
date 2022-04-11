import React, { useEffect, useState } from 'react'
import Application from './Application'
import ApplicationService from '../../../services/ApplicationService'
import axios from 'axios';
import {useParams} from "react-router-dom";


const ApplicationList = () => {
    
    const [applications, setApplications] = useState([]);
    
    const {id} = useParams();


    const getApplicationsByCreator = () => {
        axios.get("http://localhost:8080/application/creator/" + id)
        .then(response => {
            setApplications(response.data);
            console.log(response.data);
        })
        .catch(err => {
            console.log(err);
        })
    }

    useEffect(() => {
        getApplicationsByCreator();
    }, []);
    
    return (
        <>
            {applications.length > 0 ? (
                <>
                    <h1>{applications.length}</h1>
                    {applications.map((app) => (
                        // <p key={app.name}>test</p>
                        <Application key={app.name} name={app.name} icon={app.icon} />
                    ))}
                </>
            ) : (
                <p>Loading applications</p>
            )}
        </>
    )
}

export default ApplicationList