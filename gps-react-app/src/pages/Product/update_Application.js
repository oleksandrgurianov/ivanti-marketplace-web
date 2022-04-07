import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";

function update_Application() {

    useEffect(() => {
        GetProductByName();
    },[]);

    const {appName} = useParams();

    const [application, setApplication] = useState('');

    const GetProductByName =() => {
        setApplication(null);
        axios.put(`http://localhost:8080/products/` + appName)
            .then(res => {
                setApplication(res.data);
            })
    }

    return(
        <div className="container">
            <div className="basic_Info">

            </div>
            <div className="images">
                {Application.images.map(image => (
                    <img className={"image"} src={image}/>
                ))}
            </div>
            <div className="reviews">

            </div>
            <div className="other_Info">

            </div>
        </div>
    );
}

export default update_Application;