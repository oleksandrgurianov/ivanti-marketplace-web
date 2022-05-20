import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams, Link } from 'react-router-dom'

// icons
import { AiOutlinePlusCircle, AiOutlineSearch, AiFillCaretDown } from 'react-icons/ai'
import MyApps from '../Application/ApplicationPage';
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

    const fakeCreator = () => {
        setCreator({
            firstName: "firstName",
            lastName: "lastName"
        })
    }

    useEffect(() => {
        getCreator();
        // fakeCreator();
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
                            {/* <AiOutlineSearch />
                            <p>Sort <AiFillCaretDown /></p> */}
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