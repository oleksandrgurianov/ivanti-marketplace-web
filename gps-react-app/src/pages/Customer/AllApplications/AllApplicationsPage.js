import axios from 'axios';
import React, { useEffect, useState } from 'react'
import ApplicationBasic from './ApplicationBasic';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown} from '@fortawesome/free-solid-svg-icons'
import '../../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import loading from "../../../images/loading.gif";

const AllApplicationsPage = () => {
    const [applicationsArray, setApplicationArray] = useState([]);

    let token = localStorage.getItem("token");

    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    useEffect(() => {
        getApplications();
    }, []);

    const getApplications = () => {
        axios.get(`http://localhost:8080/application`)
        .then(res => {
            setApplicationArray(res.data);
            console.log(res.data);
        })
        .catch(err => {
            console.log(err);
        })
    }

    return (
        <>
            <div className='my-apps'>
                <div className='my-apps-controls'>
                    <h1 className='title'>Apps</h1>
                    <input className='search-field' type='text' placeholder='Search'/>
                    <div className='dropdown'>
                        <select>
                            <option value="nameAsc">Name &uarr;</option>
                            <option value="nameDesc">Name &darr;</option>
                            <option value="popularity">Popularity</option>
                        </select>
                        <FontAwesomeIcon className="dropdown-icon" icon={faCaretDown}/>
                    </div>
                </div>
                <hr/>
                {applicationsArray.applications ? (
                    <div className='my-apps-list'>
                        { applicationsArray.applications && applicationsArray.applications.map((app) => (
                            <ApplicationBasic key={app.name} name={app.name} icon={app.icon} />
                        ))}
                    </div>
                ) : (
                    <img className={"loading-apps"} src={loading}/>
                )}
            </div>
        </>
    )
}

export default AllApplicationsPage