import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { FaStar } from 'react-icons/fa'
import '../../../styles/ContentCreator/ApplicationPage.css'
import axios from 'axios'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faChevronLeft, faChevronRight} from '@fortawesome/free-solid-svg-icons'
import $ from 'jquery';

const ApplicationPage = () => {
    let params = useParams();

    const [application, setApplication] = useState({});
    const [version, setVersion] = useState("1.0");

    const getApplication = () => {
        axios.get(`http://localhost:8080/application/details/${params.name}`)
        .then(response => {
            setApplication(response.data);
            console.log(response.data);
        })
        .catch(err => {
            console.log(err);
        })
    }

    const deleteApplication = () => {
      axios.delete(`http://localhost:8080/application/${params.name}`)
          .then(response => {
            setApplication(response.data);
            console.log(response.data);
          })
          .catch(err => {
            console.log(err);
          })
    }

    const deleteVersion = () => {
        axios.post(`http://localhost:8080/application/version/delete`, {
            'appName': params.appName,
            'number': version
        })
            .then(response => {
                console.log(response.data);
            })
            .catch(err => {
                console.log(err);
            })
    }

    useEffect(() => {
        getApplication();
    }, []);


    /* SCROLLING VIA ARROWS
    let scrollDuration = 300;

    let leftPaddle = document.getElementsByClassName('left-paddle');

    let rightPaddle = document.getElementsByClassName('right-paddle');

    let itemsLength = $('.item').length;

    let itemSize = $('.item').outerWidth(true);

    let paddleMargin = 20;

    let getMenuWrapperSize = () => {
        return $('.menu-wrapper').outerWidth();
    };

    let menuWrapperSize = getMenuWrapperSize();

    $(window).on('resize', () => {
        menuWrapperSize = getMenuWrapperSize();
    });

    let getMenuSize = function () {
        return itemsLength * itemSize;
    };

    let menuSize = getMenuSize();

    let menuInvisibleSize = menuSize - menuWrapperSize;

    let getMenuPosition = function () {
        return $('.menu').scrollLeft();
    };

    $('.menu').on('scroll', function() {
        menuInvisibleSize = menuSize - menuWrapperSize;

        let menuPosition = getMenuPosition();

        let menuEndOffset = menuInvisibleSize - paddleMargin;

        if (menuPosition <= paddleMargin) {
            $(leftPaddle).addClass('hidden');
            $(rightPaddle).removeClass('hidden');
        } else if (menuPosition < menuEndOffset) {
            $(leftPaddle).removeClass('hidden');
            $(rightPaddle).removeClass('hidden');
        } else if (menuPosition >= menuEndOffset) {
            $(leftPaddle).removeClass('hidden');
            $(rightPaddle).addClass('hidden');
        }
    });

    $(rightPaddle).on('click', function() {
        $('.menu').animate( { scrollLeft: menuInvisibleSize}, scrollDuration);
    });

    $(leftPaddle).on('click', function() {
        $('.menu').animate( { scrollLeft: '0' }, scrollDuration);
    });
    */

    return (
        <div className='app'>

            {/*
                <div className='sidebar'>
                    <h4>Version</h4>
                    <select className={"versions"} value={version} onChange={e=>setVersion(e.target.value)}>
                        { application.versions != null &&
                            application.versions.map((version) => (
                                <option>{parseFloat(version.number).toFixed(1)}</option>
                        ))}
                    </select>
                    <div className='buttons-left' >
                        <div className="button-left">
                            <Link  to={`/creator/1/myApps/${application.name}/addMinorVersion`}>Add minor version</Link> | <Link to={`/creator/1/myApps/${application.name}/addMajorVersion`}>Add major version</Link>
                        </div>
                    </div>
                    <h4>Category:</h4>
                    <div className='categories'>
                        <a href='src/pages/AppCatalogue/index'>Utilities</a>
                    </div>
                </div>
            */}

            <div className={"app-controls"}>
                <img className='icon' alt='application logo' src={application.icon}/>
                <h1>{application.name}</h1>
                <Link className="edit-button" to={`/creator/1/myApps/${application.name}/updateApplication`}>Edit</Link>
                <Link className="delete-button" to={`/creator/1/myApps`} onClick={deleteApplication}>Delete</Link>
            </div>
            <hr/>
            <div className='menu-wrapper'>
                <ul className='menu'>
                    { application.images != null && application.images.map((image) => (
                        <li className='item' key={image}><img src={image}/></li>
                    ))}
                </ul>
                {/* ARROWS
                    <div className="paddles">
                        <button className="left-paddle paddle hidden">
                            <FontAwesomeIcon className={"paddle-icon"} icon={faChevronLeft}/>
                        </button>
                        <button className="right-paddle paddle">
                            <FontAwesomeIcon className={"paddle-icon"} icon={faChevronRight}/>
                        </button>
                    </div>
                */}
            </div>
            <hr/>
            <div className={"ratings-header"}>
                <h2>Ratings & Reviews</h2>
                <button className={"see-all-button"}>See All</button>
            </div>
            <div className={"overall-rating"}>
                <p className={"rating-number"}>3.6</p>
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
                            <p className={"nickname"}>Nickname</p>
                        </div>
                        <p className={"card-description"}>{review.description}</p>
                        <button className={"reply-button"}>Reply</button>
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

export default ApplicationPage