import React from "react";
import { Bar} from "react-chartjs-2";

function BarChart({chartData}) {
    return <Bar data={chartData} options={{
        indexAxis: 'y',
        plugins: {
            legend: {
                display: false,
            },

        },
        scales: {
            x: [{
                grid: {
                    display: false
                }
            }],
            y: [{
                grid: {
                    display: false
                }
            }]
        }
    }}/>;
}

export default BarChart;
