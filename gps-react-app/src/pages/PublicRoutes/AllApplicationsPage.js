import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown} from '@fortawesome/free-solid-svg-icons'
import '../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import loading from "../../images/loading.gif";
import { useStateWithCallbackLazy } from 'use-state-with-callback';
import BasicApplication from '../../components/BasicApplication';

const AllApplicationsPage = () => {
    const [applications, setApplications] = useState([]);

    const [name, setName] = useStateWithCallbackLazy('');

    const [sort, setSort] = useStateWithCallbackLazy('');

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
                setApplications(res.data.applications);
                console.log(res.data.applications);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        getApplications();
    }, [applications]);

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
                {applications ? (
                    <div className='my-apps-list'>
                        { applications?.map((app) => (
                            <BasicApplication key={app.name} name={app.name} icon={app.icon} />
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