import {useState, useEffect} from "react";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faClose} from '@fortawesome/free-solid-svg-icons'
import ReviewForm from "../../../../styles/ReviewForm.css"
import {FaStar} from 'react-icons/fa'
import axios from "axios";

function AddReplyForm({reply, setOpenPopup, app}) {
    const url = "http://localhost:8080/review";
    let username = localStorage.getItem("username");

    const [validTitle, setValidTitle] = useState(false);
    const [title, setTitle] = useState(reply != null ? reply.title : "");

    const [validDescription, setValidDescription] = useState(false);
    const [description, setDescription] = useState(reply != null ? reply.description : "");

    useEffect(() => {
        if (reply != null) {
            setTitle(reply?.title)
            setDescription(reply?.description)
        }
    }, [])

    useEffect(() => {
        setValidTitle(title?.length > 0);
    }, [title])

    useEffect(() => {
        setValidDescription(description?.length > 0);
    }, [description])

    const handleSubmit = () => {
        axios.put(url, {
            id: reply?.id,
            title: title,
            description: description
        })
            .then(res => {
                console.log(res.data);
            });
        setOpenPopup(false)
    }

    return (
        <>
            <section>
                <div className="review-header">
                    <h1>Submit Reply</h1>
                    <div onClick={() => {
                        setOpenPopup(false)
                    }}><FontAwesomeIcon className="close" icon={faClose} color="red"/></div>
                </div>
                <div className="form">
                    <label htmlFor="title"> Title: </label>
                    <input
                        type="text"
                        id="title"
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
                    <button onClick={handleSubmit}
                            disabled={!validDescription || !validTitle ? true : false}>Submit
                    </button>
                </div>
            </section>
        </>
    )
}

export default AddReplyForm