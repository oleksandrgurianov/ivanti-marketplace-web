import React, {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import "../../design/ApplicationCss.css";
import ReactDOM from "react-dom";


function Update_Application() {

    let navigate = useNavigate();

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
            let path = `/` ;
            navigate(path);
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
                        <img className={"image"} src={image} />
                        <button className={"RemoveImage"} value={image} onClick={RemoveImage}>Delete</button>
                    </div>
                ))}
            </div>
        );
    }

    if(name !== null){
        return(
            <div className="container">
                    <div>
                        <img className={"icon"} src={icon}/>
                        <h1 className={"name"}>{name}</h1>
                        <div className={"buttonsLeft"}>
                            <button className={"PreviewButton"}>Preview</button>
                            <button className={"DoneButton"} onClick={SaveApp}>Done</button>
                        </div>
                    </div>
                    <div>
                        <hr className={"topLine"}/>
                    </div>
                    <div>
                    <div className={"basic_Info"}>
                        <h3 className={"IconLabel"}>Icon:</h3>
                        <img className={"BigIcon"} src={icon}/>
                        <label htmlFor="Add-icon" className="Add-Icon">
                            <i></i> Replace
                        </label>
                        <input id="Add-icon"  className={"addIconButton"} type="file" accept="image/jpeg, image/png" text={"Add icon"} onChange={(e) => SaveArchiveIcon(e)}/>
                        <p className={"IconLoading"}> {loadingIcon} </p>
                    </div>
                    <hr className={"line"}/>
                    <div className={"basic_Info"}>
                        <h3 className={"nameLabel"}>Name: </h3>
                        <input className={"InputTitle"} type="text" value={name} onChange={changeTitle}/>
                    </div>

                    <hr className={"line"}/>
                </div>
                <div className="add-Screenshots">
                    <h3 className={"screenshotLabel"}>Screenshots:</h3>
                    <label htmlFor="Add-screenshot" className="Add-screenshot">
                        <i></i> Add new
                    </label>
                    <input id={"Add-screenshot"} type="file" accept="image/jpeg, image/png" onChange={(e) => SaveArchiveImage(e)}/>
                    <p className={"ScreenshotLoading"}> {loadingImage} </p>
                </div>
                <LoadImages/>
                <div>
                    <hr className={"line"}/>
                </div>
                <div>
                    <h3 className={"DescriptionText"}>Details:</h3>
                    <textarea className={"Description"} type="textarea" value={description} onChange={changeDescription}/>
                </div>
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