import React, {useEffect, useState} from "react";
import axios from "axios";

function Add_Application() {

    useEffect(() => {
        GetProductByName();
    },[]);


    const GetProductByName =() => {
        setApplication(null);
        axios.post(`http://localhost:8080/App/`)
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

export default Add_Application;