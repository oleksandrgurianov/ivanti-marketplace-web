import axios from 'axios';
import React, { useEffect, useState } from 'react'
import ApplicationBasic from './ApplicationBasic';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown} from '@fortawesome/free-solid-svg-icons'
import '../../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import loading from "../../../images/loading.gif";
import { useStateWithCallbackLazy } from 'use-state-with-callback';

const AllApplicationsPage = () => {
    const [applicationsArray, setApplicationArray] = useState([]);

    const [name, setName] = useStateWithCallbackLazy('');

    const [sort, setSort] = useStateWithCallbackLazy('');

    let token = localStorage.getItem("token");

    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    function searchApps(e) {
        setName(e, () => {
            getApplications();
        })
    }

    function sortApps(e) {
        setSort(e, () => {
            getApplications();
        })
    }

    const getApplications = () => {
         axios.get(`http://localhost:8080/application?name=${name}&sort=${sort}`)
            .then(res => {
                setApplicationArray(res.data);
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        getApplications();
    }, [applicationsArray]);

    return (
        <>
            <div className='my-apps'>
                <div className='my-apps-controls'>
                    <h1 className='title'>Apps</h1>
                    <input className='search-field' type='text' placeholder='Search' onChange={e => searchApps(e.target.value)}/>
                    <div className='dropdown'>
                        <select onChange={e => sortApps(e.target.value)}>
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