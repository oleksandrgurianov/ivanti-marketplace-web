import { Line } from "react-chartjs-2";
import {Applications} from "../components/Charts/DownloadData";
import {registerables, Chart} from 'chart.js';

function DownloadStatistics() {
    Chart.register(...registerables)

    return (
        <div>
            {Applications.map(graphs =>
                <div className="Graph">
                    <h2>{graphs.name}</h2>
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
                                   tension: 0.4
                               }}
                        />
                    </div>
                </div>)}
        </div>
    );
}
export default DownloadStatistics;