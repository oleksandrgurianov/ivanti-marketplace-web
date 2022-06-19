import React, {useEffect, useState} from "react";
import axios from "axios";
import "../../../styles/ContentCreator/AnalyticsPage.css";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCaretDown} from "@fortawesome/free-solid-svg-icons";
import AnalyticsPerMonth from "./component/AnalyticsPerMonth";
import AnalyticsPerVersion from "./component/AnalyticsPerVersion";

function AnalyticsPage() {
    const [appsForMonth, setAppsForMonth] = useState([]);
    const [appsForVersion, setAppsForVersion] = useState([]);
    const [isMonth, setIsMonth] = useState(true);
    const [year, setYear] = useState(0);

    let username = localStorage.getItem("username");

    useEffect(() => {
        getAllApplicationsAnalyticsForMonth();
    }, [isMonth, year]);

    useEffect(() => {
        getAllApplicationsAnalyticsForVersion();
    }, [isMonth]);

    const getAllApplicationsAnalyticsForMonth = () => {
        axios.get(`http://localhost:8080/user/` + username + `/statistics?year=` + year)
            .then(res => {
                setAppsForMonth(res.data);
            })
            .catch(err => {
                console.log(err.message);
            });
    }
    const getAllApplicationsAnalyticsForVersion = () => {
        axios.get(`http://localhost:8080/user/` + username + `/statistics/version`)
            .then(res => {
                setAppsForVersion(res.data);
            })
            .catch(err => {
                console.log(err.message);
            });
    }

    return (
        <div className={"analytics"}>
            <div className={"analytics-controls"}>
                <h1 className={"title"}>Analytics</h1>
                <input className={"search-field"} type="text" placeholder="Search"/>
                <div className={"year-dropdown"}>
                    <select>
                        <option value="2022" onClick={() => setYear(2022)}>2022</option>
                        <option value="2021" onClick={() => setYear(2021)}>2021</option>
                    </select>
                    <FontAwesomeIcon className="dropdown-icon" icon={faCaretDown}/>
                </div>
            </div>
            <hr/>
            <div className="radio-button">
                <input
                    type="radio"
                    checked={isMonth}
                    onClick={() => setIsMonth(true)}
                />
                <label onClick={() => setIsMonth(true)}>Per Month</label>
                <input
                    type="radio"
                    checked={!isMonth}
                    onClick={() => setIsMonth(false)}
                />
                <label onClick={() => setIsMonth(false)}>Per Version</label>
            </div>
            {isMonth ?
                <AnalyticsPerMonth applications={appsForMonth}/> :
                <AnalyticsPerVersion applications={appsForVersion}/>
            }
        </div>
    );
}

export default AnalyticsPage;