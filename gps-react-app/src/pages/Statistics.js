import {useState} from "react";
import {registerables, Chart} from 'chart.js';
import BarChart from "../components/Charts/BarChart";
import LineChart from "../components/Charts/LineChart";
import PieChart from "../components/Charts/PieChart";


function Statistics() {
    Chart.register(...registerables)

    const [graphData, setGraphData] = useState({
        labels: [5, 4, 3, 2, 1],
        datasets: [
            {
                fill: {
                    target: 'origin',
                    above: '#ddddff',   // Area will be red above the origin
                    below: 'rgb(0, 0, 255)'    // And blue below the origin
                },
                label: "Rating",
                data: [],
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
            <div style={{ width: 300 }}>
                <LineChart/>
            </div>
            <div style={{ width: 300 }}>
                <PieChart/>
            </div>
        </div>
    );
}
export default Statistics;
