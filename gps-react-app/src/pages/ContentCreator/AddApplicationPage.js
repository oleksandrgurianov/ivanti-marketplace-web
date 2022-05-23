import React, {useState} from "react";
import "../../styles/ContentCreator/AddAndUpdateApplicationPage.css";
import axios from 'axios';
import ReactDOM from "react-dom";
import {useParams, useNavigate, Link} from "react-router-dom";

function AddApplicationPage() {

    let navigate = useNavigate();

    // google api requests
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
    function SaveArchiveApp(e){
        let file = e.target.files[0] //the file
        let reader = new FileReader() //this for convert to Base64
        reader.readAsDataURL(e.target.files[0]) //start conversion...
        reader.onload = function (e) { //.. once finished..
            let rawLog = reader.result.split(',')[1]; //extract only the file data part

            setLoadingApp("Loading...");

            let dataSend = {
                dataReq: {data: rawLog, name: file.name, type: file.type},
                fname: "uploadFilesToGoogleDrive"
            }; //preapre info to send to API
            fetch('https://script.google.com/macros/s/AKfycby3Ey1lmmyX9CAsRlanTAU4FveEyfKqnjrYQPTaaBHUEN6Z3OrF/exec', //your AppsScript URL
                {method: "POST", body: JSON.stringify(dataSend)}) //send to Api
                .then(res => res.json()).then((a) => {
                changeApp(a.url);
                setLoadingApp("");
            }).catch((e) => {
                setLoadingApp("Something went wrong please try again later.\n" + e);
            })
        }
    }

    const {id} = useParams();

    //Variables
    const [icon, setIcon] = useState("");
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [arrayImages, setArrayImages] = useState([])
    const [app, setApp] = useState("");

    //Loading screens
    const [loadingImage, setLoadingImage] = useState("");
    const [loadingIcon, setLoadingIcon] = useState("");
    const [loadingApp, setLoadingApp] = useState("");
    const [loadingSavingApp, setLoadingSavingApp] = useState("");

    //Save changes
    function changeIcon(url) {

        let includeID = url.replace("file/d/", "uc?export=view?&id=");
        let ChangeView = includeID.replace("/view?usp=drivesdk", "");

        setIcon(ChangeView);
    };
    const changeName = (e) => {
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
        //ReactDOM.render( <div id="images"><LoadImages/></div>, document.getElementById('images'));
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
    function changeApp(url) {

        let includeID = url.replace("file/d/", "uc?export=view?&id=");
        let ChangeView = includeID.replace("/view?usp=drivesdk", "");

        setApp(ChangeView);
    };

    //Display images
    function LoadImages() {
        return (
            <div id="images">
                {arrayImages.map(image => (
                    <div >
                        <img className={"image"} src={image}/>
                        <button className={"RemoveImage"} value={image} onClick={RemoveImage}>Delete</button>
                    </div>
                ))}
            </div>
        );
    }

    //Save app
    const SendRequest = () =>{
        axios.post(`http://localhost:8080/application`,
            {
                'name': name,
                'description': description,
                'screenshots': arrayImages,
                'icon':icon,
                'appLocation': app,
                'creatorId':id
            })
            .then(function () {})
            .catch(function (){});
    }
    const CheckInput = () =>{

        let result = "";

        if(icon == ""){
            result += "Please add a icon. \n";
        }
        if(description == ""){
            result +="Please add a description. \n";
        }
        if(name == "" ){
            result += "Please add a title. \n";
        }
        if(arrayImages == null || arrayImages.length == 0) {
            result += "Please add at least 1 image. \n";
        }
        if(app == "") {
            result += "Please make sure to include the url to the application. \n";
        }
        return result;
    }
    const SaveApp = () =>{
        let checkInput = CheckInput();

        if(checkInput != ""){
            alert(checkInput);}
        else{
            SendRequest();
            let path = `/creator/` + id;
            navigate(path);
        }
    }


    return (
        <div className="container">
            <span id={"error"}></span>

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
                        <i></i> Add Icon
                    </label>
                    <input id="Add-icon"  className={"addIconButton"} type="file" accept="image/jpeg, image/png" text={"Add icon"} onChange={(e) => SaveArchiveIcon(e)}/>
                    <p className={"IconLoading"}> {loadingIcon} </p>
                </div>
                <hr className={"line"}/>
                <div className={"basic_Info"}>
                    <h3 className={"nameLabel"}>Name: </h3>
                    <input className={"InputTitle"} type="text" value={name} onChange={changeName}/>
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
                <h3 className={"AppLabel"} >App:</h3>
                <label htmlFor="Add-app" className="Add-app">
                    <i></i> Add app
                </label>
                <input id={"Add-app"} className={"addAppButton"} type="file" accept="application/zip" onChange={(e) => SaveArchiveApp(e)}/>
                <p className={"AppLoading"}> {loadingApp} </p>
            </div>

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

export default AddApplicationPage;
