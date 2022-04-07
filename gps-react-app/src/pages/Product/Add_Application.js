import React, {useState} from "react";
import "./ApplicationCss.css";
import axios from 'axios';

function Add_Application() {

    const [icon, setIcon] = useState("");
    const [finalIcon, setFinalIcon] = useState("https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350");
    const [title, setTitle] = useState("");
    const [image, setImage] = useState("");
    const [arrayImages, setArrayImages] = useState([])
    const [description, setDescription] = useState("");
    const [app, setApp] = useState("");
    const [finalApp, setfinalApp] = useState("");

    const changeIcon = (e) => {
        setIcon(e.target.value);
    };
    const AddIcon = () =>{
        setFinalIcon(icon);
    }
    const changeTitle = (e) => {
        setTitle(e.target.value);
    };
    const changeImage = (e) => {
        setImage(e.target.value);
    };
    const AddImage = () =>{
        if(arrayImages.length < 10) {
            arrayImages.push(image);
            console.log(arrayImages);
        }
        else {
            console.log("error");
        }
    }
    const changeDescription = (e) =>{
        setDescription(e.target.value);
    }
    const changeApp=(e)=>{
        setApp(e.target.value)
    }
    const changeFinalApp=()=>{
        setfinalApp(app)
    }

    const SendRequest = () =>{
        axios.post(`http://localhost:8080/application`,
        {
            'title': title,
            'description': description,
            'images': arrayImages,
            'icon':finalIcon,
            'appUrl': finalApp
        })
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
    }

    const SaveApp = () =>{
        var checkInput = CheckInput();

        if(checkInput != ""){
            alert(checkInput);}
        else{
            SendRequest();
        }
    }

    const CheckInput = () =>{

        let result = "";

        if(finalIcon == ""){
            result += "Please add a icon. \n";
        }
        if(description == ""){
            result +="Please add a discription. \n";
        }
        if(title == "" ){
            result += "Please add a title. \n";
        }
        if(arrayImages == null || arrayImages.length == 0) {
            result += "Please add at least 1 image. \n";
        }
        if(finalApp == "") {
            result += "Please make sure to include the url to the application. \n";
        }
        return result;
    }


    return(
        <div className="container">
            <span id={"error"}></span>
            <div className="basic_Info">
                <input type="text" placeholder="icon url" name="Icon" value={icon} onChange={changeIcon}/>
                <button onClick={AddIcon}>Add icon</button>

                <br/>

                <div className={"title_div"}>
                    <img className={"icon"}   src={finalIcon}/>
                    <input className={"InputTitle"} type="text" placeholder="Title" name="Title" value={title} onChange={changeTitle}/>
                </div>

                <hr className={"line"}/>
            </div>

            <div className="images">
                <input type="text" placeholder="image url" name="Image" value={image} onChange={changeImage}/>
                <button onClick={AddImage}>Add image</button>
                <br/>
                {arrayImages.map(image => (
                    <img className={"image"} src={image}/>
                ))}
            </div>

            <div className="other_Info">
                <input type="text" placeholder="app url" name="app" value={app} onChange={changeApp}/>
                <button onClick={changeFinalApp}>Conform application url</button>
                <p className={"DescriptionText"}>Description</p>
                <textarea   className={"description"} type="textarea" placeholder="Description" name="description" value={description} onChange={changeDescription}/>
            </div>
            <button onClick={SaveApp} >Save</button>
        </div>
    );
}

export default Add_Application;
