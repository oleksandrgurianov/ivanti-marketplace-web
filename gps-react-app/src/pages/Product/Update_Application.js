import React, {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import "./ApplicationCss.css";
import ReactDOM from "react-dom";


function Update_Application() {

    function SaveArchiveIcon(e) {
        let file = e.target.files[0] //the file
        let reader = new FileReader() //this for convert to Base64
        reader.readAsDataURL(e.target.files[0]) //start conversion...
        reader.onload = function (e) { //.. once finished..
            let rawLog = reader.result.split(',')[1]; //extract only the file data part

            setLoadingIcon("Loading...");

            let dataSend = {
                dataReq: {data: rawLog, name: file.name, type: file.type},
                fname: "uploadFilesToGoogleDrive"
            }; //preapre info to send to API
            fetch('https://script.google.com/macros/s/AKfycby3Ey1lmmyX9CAsRlanTAU4FveEyfKqnjrYQPTaaBHUEN6Z3OrF/exec', //your AppsScript URL
                {method: "POST", body: JSON.stringify(dataSend)}) //send to Api
                .then(res => res.json()).then((a) => {
                changeIcon(a.url);
                setLoadingIcon("");
            }).catch((e) => {
                setLoadingIcon("Something went wrong please try again later.\n" + e);
            })
        }
    }
    function SaveArchiveImage(e) {
        let file = e.target.files[0] //the file
        let reader = new FileReader() //this for convert to Base64
        reader.readAsDataURL(e.target.files[0]) //start conversion...
        reader.onload = function (e) { //.. once finished..
            let rawLog = reader.result.split(',')[1]; //extract only the file data part

            setLoadingImage("Loading...");

            let dataSend = {
                dataReq: {data: rawLog, name: file.name, type: file.type},
                fname: "uploadFilesToGoogleDrive"
            }; //preapre info to send to API
            fetch('https://script.google.com/macros/s/AKfycby3Ey1lmmyX9CAsRlanTAU4FveEyfKqnjrYQPTaaBHUEN6Z3OrF/exec', //your AppsScript URL
                {method: "POST", body: JSON.stringify(dataSend)}) //send to Api
                .then(res => res.json()).then((a) => {
                    AddImage(a.url);
                setLoadingImage("");
                }).catch((e) => {
                setLoadingImage("Something went wrong please try again later.\n" + e);
                })
        }
    }

    useEffect(() => {
            GetProductByName();
        }, []);

    const {Name} = useParams();

    const GetProductByName = () => {
            axios.get(`http://localhost:8080/application/creator/appToUpdate/` + Name)
                .then(res => {
                    setId(res.data.id);
                    setIcon(res.data.icon);
                    setName(res.data.name);
                    setDescription(res.data.description);
                    setArrayImages(res.data.images);
                }).catch(e => {
                setId(null);
                setIcon(null);
                setName(null);
                setDescription(null);
                setArrayImages(null);
            })
    }

    //App info
    const [id, setId] = useState("");
    const [icon, setIcon] = useState("");
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [arrayImages, setArrayImages] = useState([])

    //Loading screens
    const [loadingImage, setLoadingImage] = useState("");
    const [loadingIcon, setLoadingIcon] = useState("");

    //Change app info
    function changeIcon(url) {

        let includeID = url.replace("file/d/", "uc?export=view?&id=");
        let ChangeView = includeID.replace("/view?usp=drivesdk", "");

        setIcon(ChangeView);
    };
    const changeTitle = (e) => {
            setName(e.target.value);
        };
    const changeDescription = (e) => {
            setDescription(e.target.value);
    }
    function AddImage(url) {
        let includeID = url.replace("file/d/", "uc?export=view?&id=");
        let ChangeView = includeID.replace("/view?usp=drivesdk", "");

        if (arrayImages === null) {
            setArrayImages(ChangeView);
        } else if (arrayImages.length < 10) {
            arrayImages.push(ChangeView);
            setArrayImages(arrayImages);
        }
        setArrayImages(arrayImages);
    }
    const RemoveImage = (e) => {
        for (let i = 0; i < arrayImages.length; i++) {
            if (arrayImages[i] === e.target.value) {
                arrayImages.splice(i, 1);
                ReactDOM.render( <LoadImages/>, document.getElementById('images'));
                return;
            }
        }
    }

    //Save changes
    const SaveChanges = () => {
        axios.put(`http://localhost:8080/application`,
            {
                'id': id,
                'name': name,
                'description': description,
                'images': arrayImages,
                'icon': icon
            })
            .then(function(){})
            .catch(function (){})
    }
    const SaveApp = () => {
        var checkInput = CheckInput();

        if (checkInput !== "") {
            alert(checkInput);
        } else {
            SaveChanges();
        }
    }
    const CheckInput = () => {

        let result = "";

        if (icon === "") {
            result += "Please add a icon. \n";
        }
        if (description === "") {
            result += "Please add a discription. \n";
        }
        if (name === "") {
            result += "Please add a title. \n";
        }
        if (arrayImages !== null) {
            if (arrayImages.length > 10 || arrayImages.length === 0) {
                result += "Please add at least 1 image. \n";
            }
        } else {
            result += "Please add at least 1 image. \n";
        }
        return result;
    }

    //Display images
    function LoadImages() {
        return (
            <div id="images">
                {arrayImages.map(image => (
                    <div className={"image"}>
                        <img src={image}  height="333"/>
                        <button value={image} onClick={RemoveImage}>Delete</button>
                    </div>
                ))}
            </div>
        );
    }

    if(name !== null){
        return(
            <div className="container">
                <div className="basic_Info">
                    <input type="file" accept="image/jpeg, image/png" id="customFile" onChange={(e) => SaveArchiveIcon(e)}/>
                    <p> {loadingIcon} </p>
                    <br/>
                    <div className={"title_div"}>
                        <img className={"icon"} src={icon}/>
                        <input className={"InputTitle"} type="text" placeholder="Title" name="Title" value={name} onChange={changeTitle}/>
                    </div>
                    <hr className={"line"}/>
                </div>

                <div className="images">
                    <input type="file" accept="image/jpeg, image/png" id="customFile" onChange={(e) => SaveArchiveImage(e)}/>
                    <p> {loadingImage} </p>
                    <br/>
                    <LoadImages/>
                </div>

                <div className="other_Info">
                    <p className={"DescriptionText"}>Description</p>
                    <textarea className={"description"} type="textarea" placeholder="Description" name="description" value={description} onChange={changeDescription}/>
                </div>

                <Link className={"button"}  onClick={SaveApp} to={`/app/${name}`}>Save changes</Link>
            </div>
        );
    }
    else {
        return(
            <div className="container">
                <p> Not found!! </p>
            </div>
        );
    }
}
export default Update_Application;