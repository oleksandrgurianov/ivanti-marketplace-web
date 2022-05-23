import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams, Link } from 'react-router-dom'
import "../../../styles/MyAppsPage.css"
import { AiOutlinePlusCircle } from 'react-icons/ai'
import ApplicationList from "./components/ApplicationList";

const MyAppsPage = () => {
    const [creator, setCreator] = useState({});

    const getCreator = () => {
        axios.get(`http://localhost:8080/api/user/creator/${id}`)
            .then(response => {
                setCreator(response.data);
                console.log(response.data);
            })
            .catch(err => {
                console.log(err);
            })
    }

    const {id} = useParams();

    useEffect(() => {
        getCreator();
    }, []);

    return (
        <>
            {Object.keys(creator).length !== 0 ? (
                <>
                    <h1>Hello, {creator.firstName} {creator.lastName}</h1>
                    <div className='my-apps'>
                        <div className='title'>
                            <h1>My Apps:</h1>
                        </div>
                        <div className='title-buttons'>
                            <div className='add-button'>
                                <Link to={`/creator/${id}/myApps/addApplication`}>
                                    Add App <AiOutlinePlusCircle />
                                </Link>
                            </div>
                        </div>
                    </div>
                    <ApplicationList />
                </>
            ) : (
                <p>Access denied</p>
            )}
        </>
    )
}

export default MyAppsPage