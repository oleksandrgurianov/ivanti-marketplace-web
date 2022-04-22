import React, {useState} from "react";
import "./ApplicationCss.css";
import axios from 'axios';
import ReactDOM from "react-dom";
import {useParams,useNavigate} from "react-router-dom";

function Add_Application() {

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
                    <div className={"image"}>
                        <img src={image}  height="333"/>
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
                'title': name,
                'description': description,
                'images': arrayImages,
                'icon':icon,
                'appLocation': app,
                'CreatorId':id
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


if(loadingSavingApp === "") {
    return (
        <div className="container">
            <span id={"error"}></span>
            <div className="basic_Info">
                <input type="file" accept="image/jpeg, image/png" text={"Add icon"}
                       onChange={(e) => SaveArchiveIcon(e)}/>
                <p> {loadingIcon} </p>

                <div className={"title_div"}>
                    <img className={"icon"} src={icon}/>
                    <input className={"InputTitle"} type="text" placeholder="Title" name="Title" value={name}
                           onChange={changeName}/>
                </div>

                <hr className={"line"}/>
            </div>

            <div className="images">
                <div className={"AddImage"}>
                    <input className={"AddImageButton"} type="file" accept="image/jpeg, image/png"
                           onChange={(e) => SaveArchiveImage(e)}/>
                    <p> {loadingImage} </p>
                </div>

                <LoadImages/>
            </div>

            <div className="other_Info">
                <input type="file" accept="application/pdf, application/json" onChange={(e) => SaveArchiveApp(e)}/>
                <p> {loadingApp} </p>
                <br/>
                <p className={"DescriptionText"}>Description</p>
                <textarea className={"description"} type="textarea" placeholder="Description" name="description"
                          value={description} onChange={changeDescription}/>
                <button className={"SaveButton"} onClick={SaveApp}>Save</button>
            </div>
        </div>
    );
    }
    else{
        return(
            <div className="container">
                <h1>Saved</h1>
                <button className={"SaveButton"} onClick={setLoadingSavingApp("")}>Back</button>
            </div>
        );
    }
}

export default Add_Application;
