import React, {useState, useEffect} from 'react'
import {FaStar} from 'react-icons/fa'
import Popup from "./Popup";
import AddReplyForm from "./AddReplyForm";
import axios from "axios";

function AdminReviewList({ reviews, app }) {
    const [openPopup, setOpenPopup] = useState(false)

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/review/${id}`)
            .then(res => {
                console.log(res.status);
            })
            .catch(err => {
                console.log(err.message);
            });
    }

    return (
        <div>
            <div className={"app-reviews"}>
                <Popup openPopup={openPopup}><AddReplyForm setOpenPopup={setOpenPopup} app={app}/></Popup>
                {reviews?.map(review =>
                    <div className={"review-card"}>
                        <div className={"card-title"}>
                            <p className={"text"}>{review.title}</p>
                            <p className={"date"}>{review.timePassed}</p>
                        </div>
                        <div className={"card-stars"}>
                            <p className={"stars"}>
                                {[...Array(5)].map((star, i) => {
                                    const ratingValue = i + 1;
                                    return (
                                        <label>
                                            <FaStar
                                                color={ratingValue <= review.rating ? "#4F4746" : "#e4e5e9"}
                                                size={15}
                                            />
                                        </label>
                                    )
                                })}
                            </p>
                            <p className={"nickname"}>{review.customerName}</p>
                        </div>
                        <p className={"card-description"}>{review.description}</p>

                        {review?.reply ?
                            <>
                                <br/>
                                <b>Content-creator:</b>
                                <hr/>
                                <div className={"card-title"}>
                                    <p className={"text"}>{review?.reply?.title}</p>
                                </div>
                                <p className={"card-description"}>{review.reply?.description}</p>
                                <button className={"reply-button"}>Update</button>
                                <button className={"reply-button"}>Delete</button>
                            </> : <button className={"reply-button"}>Reply</button>}
                    </div>
                )}
            </div>
        </div>
    )
}

export default AdminReviewList;