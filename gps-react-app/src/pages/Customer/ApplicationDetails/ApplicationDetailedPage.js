import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams, Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faCaretDown, faChevronLeft, faChevronRight} from '@fortawesome/free-solid-svg-icons'
import { FaStar } from 'react-icons/fa'



const ApplicationDetailedPage = () => {

    let params = useParams();

    const [application, setApplication] = useState({});
    const [appLocation, setAppLocation] = useState();
    const [name, setName] = useState();
    const [version, setVersion] = useState();
    const [arrayOfBytes, setArrayOfBytes] = useState({});


    const getApplication = () => {
        axios.get(`http://localhost:8080/application/${params.name}`)
            .then(response => {
                setApplication(response.data);
                setName(response.data.name);
                setAppLocation(response.data.versions[0].appLocation);
                console.log(response.data);
                console.log(appLocation);
                console.log(name);
            })
            .catch(err => {
                console.log(err);
            })
    }
    function base64ToArrayBuffer(base64) {
        let binaryString = window.atob(base64);
        let binaryLen = binaryString.length;
        let bytes = new Uint8Array(binaryLen);
        for (let i = 0; i < binaryLen; i++) {
            let ascii = binaryString.charCodeAt(i);
            bytes[i] = ascii;
        }
        return bytes;
    }

    const saveByteArray = (name, byte)  => {
        let blob = new Blob([byte], {type: "image/png"});
        let link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        let fileName = name;
        link.download = fileName;
        link.click();
    };


    const downloadApplication = async (e) => {
        e.preventDefault();
        try {
            console.log("METHOD STARTED");
            console.log(appLocation);
            console.log(name);
            const response = await axios.get(`http://localhost:8080/application/download/${appLocation}/${name}`)
                .then(
                    response => {
                        setArrayOfBytes(response.data);
                        let bytes = base64ToArrayBuffer(arrayOfBytes.arrayOfBytes)
                        saveByteArray(name, bytes);
                        console.log(arrayOfBytes);
                        console.log(arrayOfBytes.arrayOfBytes);
                    }
                )
            console.log("SUCCESSFUL");
        } catch (err){
            console.log("Something went wrong");
        }
    }

    useEffect(() => {
        getApplication();
    }, []);

    return (
        <div className='app'>
            <div className={"app-controls"}>
                <img className='icon' alt='application logo' src={application.icon}/>
                <h1>{application.name}</h1>
                <Link className="delete-button" to={''}>
                    <span onClick={downloadApplication}>Download</span>
                </Link>
            </div>
            <hr/>
            <div className='app-version'>
                <h2>Version</h2>
                <div className={"version-content"}>
                    <dropdown className={"version-selector"}>
                        <select value={version} onChange={e=>setVersion(e.target.value)}>
                            { application.versions != null &&
                                application.versions.map((version) => (
                                    <option>{parseFloat(version.number).toFixed(1)}</option>
                                ))}
                        </select>
                        <FontAwesomeIcon className="dropdown-icon" icon={faCaretDown} />
                    </dropdown>
                </div>
            </div>
            <hr/>
            <div className='menu-wrapper'>
                <ul className='menu'>
                    { application.screenshots != null && application.screenshots.map((image) => (
                        <li className='item' key={image}><img src={image}/></li>
                    ))}
                </ul>
            </div>
            <hr/>
            <div className={"ratings-header"}>
                <h2>Ratings & Reviews</h2>
                <button className={"see-all-button"}>See All</button>
            </div>
            <div className={"overall-rating"}>
                <p className={"rating-number"}>{application.avgRating}</p>
                <p>out of 5</p>
            </div>
            <div className={"app-reviews"}>
                { application.reviews != null && application.reviews.map(review =>
                    <div className={"review-card"}>
                        <div className={"card-title"}>
                            <p className={"text"}>{review.title}</p>
                            <p className={"date"}>3y ago</p>
                        </div>
                        <div className={"card-stars"}>
                            <p className={"stars"}>
                                {[...Array(5)].map((star, i) => {
                                    const ratingValue = i + 1;
                                    return (
                                        <label>
                                            <FaStar
                                                className={"star"}
                                                color={ratingValue <= review.rating ? "#4F4746" : "#e4e5e9"}
                                                size={15}
                                            />
                                        </label>
                                    )
                                })}
                            </p>
                            <p className={"nickname"}>{review.customer}</p>
                        </div>
                        <p className={"card-description"}>{review.description}</p>
                    </div>
                )}
            </div>
            <hr/>
            <div className='app-description'>
                <h2>Description</h2>
                <p>{application.description}</p>
            </div>
        </div>
    )
}

export default ApplicationDetailedPage