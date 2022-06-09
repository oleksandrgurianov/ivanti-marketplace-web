import { useRef, useState, useEffect } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClose } from '@fortawesome/free-solid-svg-icons'
import ReviewForm from "../../../../styles/ReviewForm.css"
import { FaStar } from 'react-icons/fa'

function AddReviewForm({ review, setOpenPopup }) {
    const titleRef = useRef();

    const [title, setTitle] = useState(review != null ? review.title : "");
    const [description, setDescription] = useState(review != null ? review.description : "");

    const [validTitle, setValidTitle] = useState(false);
    const [validDescription, setValidDescription] = useState(false);

    const [rating, setRating] = useState(review != null ? review.rating : 0)
    const [hover, setHover] = useState(0)


    useEffect(() => {
        setValidTitle(title.length > 0);
    }, [title])

    useEffect(() => {
        setValidDescription(description.length > 0);
    }, [description])

    function handleSubmit() {

    }
    function closePopUp() {
        setOpenPopup(false)
    }


    return (
        <>
            <section>
                <div className="review-header">
                    <h1>Submit Review</h1><div onClick={closePopUp}><FontAwesomeIcon className="close" icon={faClose} color="red" /></div>
                </div>
                <p className={"stars"}>
                    {[...Array(5)].map((star, i) => {
                        const ratingValue = i + 1;
                        return (
                            <label>
                                <input
                                    type="radio"
                                    name="rating"
                                    value={ratingValue}
                                    onClick = {() => {setRating(ratingValue)}}
                                />
                                <FaStar
                                    className="star"
                                    color={ratingValue <= (hover || rating) ? "#4F4746" : "#e4e5e9"}
                                    size={30}
                                    onMouseEnter={() => {setHover(ratingValue)}}
                                    onMouseLeave={() => {setHover(0)}}
                                />
                            </label>
                        )
                    })}
                </p>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="title"> Title: </label>
                    <input
                        type="text"
                        id="title"
                        ref={titleRef}
                        autoComplete="off"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        required
                    />
                    <label htmlFor="description"> Description: </label>
                    <textarea
                        rows={5}
                        type="text"
                        id="description"
                        autoComplete="off"
                        onChange={(e) => setDescription(e.target.value)}
                        value={description}
                        required
                    />
                    <button disabled={!validDescription || !validTitle ? true : false}>Submit</button>
                </form>
            </section>
        </>
    )
}

export default AddReviewForm