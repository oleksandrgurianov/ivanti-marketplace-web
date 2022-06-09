import React, { useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAdd } from '@fortawesome/free-solid-svg-icons'
import { FaStar } from 'react-icons/fa'
import Popup from "./Popup";
import AddReviewForm from "./AddReviewForm";

function ReviewList({ reviews }) {
    const [openPopup, setOpenPopup] = useState(false)
    const [review, setReview] = useState({
        rating: 3,
        title: "Yooooo",
        description: "Yooooo"
    })

    function Click() {
        setOpenPopup(true)
    }

    return (
        <div>
            <div className={"app-reviews"}>
                <Popup openPopup={openPopup}><AddReviewForm review={review} setOpenPopup={setOpenPopup} /></Popup>
                <div className={"add-review-card"} onClick={Click}> <FontAwesomeIcon icon={faAdd} /></div>
                {reviews != null && reviews.map(review =>
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
                    </div>
                )}
            </div>
        </div>
    )
}

export default ReviewList;