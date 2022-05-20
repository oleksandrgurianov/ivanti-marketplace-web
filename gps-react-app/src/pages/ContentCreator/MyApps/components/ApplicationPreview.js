import React, {useEffect, useState} from "react";
import axios from 'axios';

function ApplicationPreview({appName}) {

    const [product, setProduct] = useState({});

    useEffect(() => {
        View_Products_Default();
    },[]);

    const View_Products_Default =() => {
        axios.get(`http://localhost:8080/application/details/` + appName)
            .then(res => {
                setProduct(res.data);
            })
    }

    return(
        <div className="container">
            <div className="box">
                <div className="product__info">
                    <div className="title">
                        <h1>{product.name1}</h1>
                        <span>{product.name2}</span>
                    </div>
                    <div className="price">
                        <span>{product.price} </span>
                    </div>
                    <div className="description">
                        <h3>Description</h3>
                        <h4>{product.description}</h4>
                    </div>
                    <button className="buy--btn">Details</button>
                </div>
            </div>
        </div>
    );
}

export default ApplicationPreview;