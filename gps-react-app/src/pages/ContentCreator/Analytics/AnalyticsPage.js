import { Line } from "react-chartjs-2";
import {registerables, Chart} from 'chart.js';
import {useEffect, useState} from "react";
import axios from "axios";
import { Link } from 'react-router-dom'

function AnalyticsPage() {
    Chart.register(...registerables)
    const [Applications, setApplications] = useState([]);
    useEffect(() => {
        GetAllApplications();
    },[Applications]);

    const GetAllApplications =() => {
        axios.get(`http://localhost:8080/application/creator/1/statistics`)
            .then(res => {
                setApplications(res.data);
            })
            .catch(err => {
                console.log(err.message);
            });
    }

    return (
        <div>
            <h2>Analytics</h2>
            {Applications.map(graphs =>
                <div>
                    <hr/>
                    <div className={"AppDownloads"}>
                    {/* <Link to={`/app/${name}`}>
            <img height={"50"} src={icon} />
          </Link>                    */}
                        <Link to={`/app/${graphs.name}`}>
                            <img src={graphs.icon}/>
                        </Link>
                        <h4>{graphs.name}</h4>
                        <p></p>
                        
                        <div>
                            <h5>Total Downloads for 2021: {graphs.totalDownloads}</h5>
                            <div style={{width: 300}}>
                                <Line  data={ {
                                    labels: graphs.downloads.map((data) => data.month),
                                    datasets: [
                                        {
                                            fill: {
                                                target: 'origin',
                                                above: '#ddddff',
                                                below: 'rgb(0, 0, 255)'
                                            },
                                            label: "Downloads",
                                            data: graphs.downloads.map((data1) => data1.amount),
                                        }]}}
                                       options={ {
                                           maintainAspectRatio: true,
                                           tension: 0.4,
                                       }}
                                />
                            </div>
                        </div>
                    </div>
                </div>)}
        </div>
    );
}
export default AnalyticsPage;