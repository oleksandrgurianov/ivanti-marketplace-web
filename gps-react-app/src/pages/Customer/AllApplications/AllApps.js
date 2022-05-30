import React, { useEffect, useState } from 'react'
import Application from './components/Application'
import axios from 'axios';
import '../../../styles/ContentCreator/MyAppsPage/MyAppsPage.css';
import { useParams, Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown, faCirclePlus, faMagnifyingGlass} from '@fortawesome/free-solid-svg-icons'

const MyAppsPage = () => {
    const [applications, setApplications] = useState({});

    const [name, setName] = useState('');

    const [sort, setSort] = useState('');

    const {id} = useParams();

    let urlParams = new URLSearchParams(window.location.search);

    function getAllApplications() {
        axios.get(`http://localhost:8080/application`, {
            params: {
                name: urlParams.get('name'),
                sort: urlParams.get('sort')
            }
        })
            .then(response => {
                setApplications(response.data);
                console.log(applications);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        getAllApplications();
    }, []);

    function searchAndSort() {
        if (name && sort) {
            let newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname + '?name=' + name + '&sort=' + sort;
            window.history.pushState({path: newUrl}, '', newUrl);
        } else if (name) {
            let newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname + '?name=' + name;
            window.history.pushState({path: newUrl}, '', newUrl);
        } else if (sort) {
            let newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname + '?sort=' + sort;
            window.history.pushState({path: newUrl}, '', newUrl);
        }

        getAllApplications();
    }

    return (
        <div>
            {Object.keys(creator).length !== 0 ? (
                <div className={"my-apps"}>
                    <div className={"my-apps-controls"}>
                        <h1 className={"title"}>My Apps</h1>
                        <Link to={`/creator/${id}/myApps/addApplication`}><FontAwesomeIcon className={"add-icon"} icon={faCirclePlus}/></Link>
                        <input className={"search-field"} type="text"  placeholder="Search" value={name} onChange={(e) => setName(e.target.value)}/>
                        <div className={"dropdown"}>
                            <select value={sort} onChange={(e) => setSort(e.target.value)}>
                                <option value="nameAsc">Name Ascending</option>
                                <option value="nameDesc">Name Descending</option>
                                <option value="ratingAsc">Rating Ascending</option>
                                <option value="ratingDesc">Rating Descending</option>
                            </select>
                            <FontAwesomeIcon className="dropdown-icon" icon={faCaretDown} />
                        </div>
                        <button className={"search-button"} type="button" onClick={searchAndSort}><FontAwesomeIcon icon={faMagnifyingGlass}/></button>
                    </div>
                    <hr/>
                    <div className={"my-apps-list"}>
                        { applications.length > 0 ? (
                            <>
                                { applications.map((app) => (
                                    <Application key={app.name} name={app.name} icon={app.icon}/>
                                )) }
                            </>
                        ) : (
                            <p>Loading applications</p>
                        ) }
                    </div>
                </div>
            ) : (
                <p>Access denied</p>
            )}
        </div>
    )
}

export default MyAppsPage