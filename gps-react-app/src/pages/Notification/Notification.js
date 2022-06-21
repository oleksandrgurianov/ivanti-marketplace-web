import React, { useEffect, useState } from 'react'
import {over} from 'stompjs';
import SockJS from 'sockjs-client';
import useAuth from "../../hooks/useAuth";

let stompClient = null;
const Notification = () => {
    const storedUsername = localStorage.getItem("username")

    useEffect(() => {
        connect()
    }, []);



    const setMessageValue =(e) =>{
        setPrivateMessage(e.target.value)
    }
    const [privateMessage, setPrivateMessage] = useState('');
    const [userData, setUserData] = useState({
            username: storedUsername,
            CreatorUsername: 'Bob',
            connected: false,
            message: '',
            AppId: 9
    });

        useEffect(() => {
            console.log(userData);
        }, [userData]);

       const connect = () => { //Connect automatically when press add review in the Customer and connect with login in the Creator
            let Sock = new SockJS('http://localhost:8080/ws');
            stompClient = over(Sock);
            stompClient.connect({}, onConnected, onError);
        }

        const onConnected = () => {
            setUserData({...userData, "connected": true});
            stompClient.subscribe('/notifications/messages', onPrivateNotification);
        }

        const onPrivateNotification = (payload) => {
            const payloadData = JSON.parse(payload.body);
            if (storedUsername === userData.CreatorUsername){
                console.log("PAYLOAD", payload)
            alert(userData.username + " sent a new review for your app nº" + userData.AppId + " : " + payloadData);
            }
        }

        const onError = (err) => {
            console.log("ERROR", err);
        }

        const sendNotification = () => { //sends notification
            if (stompClient) {
                stompClient.send('/app/message', {}, JSON.stringify(privateMessage));  //sends the notification to the CreatorId (if connected)
                setUserData({...userData, "message": ""});
            }
        }

        return (null
           /* <div className="container">
                     <>
                          {userData.connected ? //customer leaving a review
                        <>
                            <div className="send-notification">
                                <input type="text" className="input-message" placeholder="enter the message"
                                   value={privateMessage} onChange={setMessageValue}/>
                                <button type="button" className="send-button" onClick={sendNotification}>send</button>
                            </div>
                         </>
                        :
                        <div className="leave-review">
                            <h1>APP logo</h1>
                        <button type="button" onClick={connect}>Leave a Review</button>
                        </div>}
                    </>
                }
            </div>*/
        )
    }

export default Notification
