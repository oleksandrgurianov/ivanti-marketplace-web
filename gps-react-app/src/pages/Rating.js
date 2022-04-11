import {registerables, Chart} from 'chart.js';
import BarChart from "../components/Charts/BarChart";
import {Application} from "../components/Charts/RatingData";

function Rating() {
    Chart.register(...registerables)

    const graphData = {
        labels: [5, 4, 3, 2, 1],
        datasets: [
            {
                label: "Rating",
                data: [Application.rating.fiveStar, Application.rating.fourStar, Application.rating.threeStar, Application.rating.twoStar, Application.rating.oneStar],
                backgroundColor: [
                    "rgba(75,192,192,1)",
                    "red",
                    "#50AF95",
                    "#f3ba2f",
                    "#2a71d0",
                ],
                borderColor: [
                    "rgba(75,192,192,1)",
                    "#ecf0f1",
                    "#50AF95",
                    "#f3ba2f",
                    "#2a71d0",
                ],
                borderWidth: 2,
            },
        ]
    };
    return (
        <div>
            <h2>{Application.rating.averageStar}</h2>
            <div style={{ width: 300 }}>
                <BarChart chartData={graphData} />
            </div>
        </div>
    )
}
export default Rating;