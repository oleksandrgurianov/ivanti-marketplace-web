import {useState} from "react";
import {registerables, Chart} from 'chart.js';
import {AppData} from "../components/Charts/Data";
import BarChart from "../components/Charts/BarChart";
import LineChart from "../components/Charts/LineChart";
import PieChart from "../components/Charts/PieChart";


function Statistics() {
    Chart.register(...registerables)

    const [graphData, setGraphData] = useState({
        labels: AppData.map((data) => data.rating),
        datasets: [
            {
                label: "Rating",
                data: AppData.map((data) => data.amount),
                backgroundColor: [
                    "rgba(75,192,192,1)",
                    "#ecf0f1",
                    "#50AF95",
                    "#f3ba2f",
                    "#2a71d0",
                ],
                borderColor: "black",
                borderWidth: 2,
            },
        ],
    });
    return (
        <div>
            <div style={{ width: 300 }}>
                <BarChart chartData={graphData} />
            </div>
            <div style={{ width: 700 }}>
                <LineChart chartData={graphData} />
            </div>
            <div style={{ width: 700 }}>
                <PieChart chartData={graphData} />
            </div>
        </div>
    );
}
export default Statistics;
