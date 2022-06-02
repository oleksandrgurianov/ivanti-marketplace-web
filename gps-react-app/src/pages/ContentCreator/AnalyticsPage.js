import { Line } from "react-chartjs-2";
import {registerables, Chart} from 'chart.js';
import React, {useEffect, useState} from "react";
import axios from "axios";
import { Link } from 'react-router-dom'
import "../../styles/ContentCreator/AnalyticsPage.css";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCaretDown} from "@fortawesome/free-solid-svg-icons";

function AnalyticsPage() {
    Chart.register(...registerables)
    const [applications, setApplications] = useState([]);
    let token = localStorage.getItem("token");
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    useEffect(() => {
        getAllApplications();
    },[applications]);

    const getAllApplications =() => {
        axios.get(`http://localhost:8080/user/Bob/statistics`)
            .then(res => {
                setApplications(res.data);
            })
            .catch(err => {
                console.log(err.message);
            });
    }

    return (
        <div className={"analytics"}>
            <div className={"analytics-controls"}>
                <h1 className={"title"}>Analytics</h1>
                <input className={"search-field"} type="text"  placeholder="Search"/>
                <div className={"year-dropdown"}>
                    <select>
                        <option value="2022">2022</option>
                        <option value="2021">2021</option>
                    </select>
                    <FontAwesomeIcon className="dropdown-icon" icon={faCaretDown} />
                </div>
            </div>
            <hr/>
            {applications.map(app =>
                <>
                    <div className={"app-downloads"}>
                        <Link to={`/creator/1/myApps/${app.name}`}>
                            <img src={app.icon}/>
                        </Link>
                        <p>{app.name}</p>
                        <div className={"downloads-graph"}>
                            <h3 className={"graph-title"}>DOWNLOADS</h3>
                            <div className={"graph-numbers"}>
                                <h4 className={"number"}>{app.totalDownloads}</h4>
                                <h5 className={"raise"}>+7%</h5>
                            </div>
                            <div className={"graph"}>
                                <Line  data={ {
                                    labels: app.downloads.map((data) => data.month),
                                    datasets: [
                                        {
                                            fill: {
                                                target: 'origin',
                                                above: 'rgb(130, 192, 250)',
                                            },
                                            label: "DOWNLOADS",
                                            data: app.downloads.map((data1) => data1.amount),
                                        }]}}
                                       options={ {
                                           maintainAspectRatio: true,
                                           tension: 0,
                                       }}
                                />
                            </div>
                        </div>
                    </div>
                    <hr/>
                </>)}
        </div>
    );
}
export default AnalyticsPage;