import React, { useEffect, useState } from 'react'
import Application from './Application'
import axios from 'axios';
import {useParams} from "react-router-dom";
import { Section, List } from '../../design/ApplicationListStyled';

const ApplicationList = () => {
    const [applications, setApplications] = useState({});

    const [name, setName] = useState('');

    const [sort, setSort] = useState('');

    const {id} = useParams();

    let urlParams = new URLSearchParams(window.location.search);

    function getApplicationsByCreator() {
        axios.get(`http://localhost:8080/application/creator/${id}`, {
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
        getApplicationsByCreator();
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

        getApplicationsByCreator();
    }

    return (
        <div>
            <div className='title-controls'>
                <input type="text" id="searchInput" placeholder="Search" value={name}
                       onChange={(e) => setName(e.target.value)}/>
                <select id="sort" value={sort} onChange={(e) => setSort(e.target.value)}>
                    <option value="nameAsc">Name Ascending</option>
                    <option value="nameDesc">Name Descending</option>
                    <option value="ratingAsc">Rating Ascending</option>
                    <option value="ratingDesc">Rating Descending</option>
                </select>
                <button type="button" onClick={searchAndSort}>Update</button>
            </div>
            <Section>
                <List>
                    {applications.length > 0 ? (
                        <>
                            {applications.map((app) => (
                                <Application key={app.name} name={app.name} icon={app.icon}/>
                            ))}
                        </>
                    ) : (
                        <p>Loading applications</p>
                    )
                    }
                </List>
            </Section>
        </div>
    )
}

export default ApplicationList