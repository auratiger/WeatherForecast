
let ctx = document.getElementById('myChart').getContext('2d');
let lineChart = Chart.Line(ctx, {
    data: {
        datasets: [{
            label: 'Temperatures 1',
            data: [],
            fill: null,
            borderColor: "#9370DB",
        }, {
            label: 'Temperatures 2',
            data: [],
            fill: null,
            borderColor: "#c84adb",
        }],
        labels: [
            '01:00', '02:00', '03:00', "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00","12:00",
            "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", '00:00',
        ]
    },
    options: {
        responsive: true,
        hover: {
            mode: 'label'
        },
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true,
                    steps: 10,
                    stepValue: 5,
                    max: 50,
                }
            }]
        }
    }
});

let daily = function(result) {
    let temps = [];
    result[0].map(x => {
        temps.push(x)
    });
    let hourlyTemps = [];
    result[1].map(x => {
        hourlyTemps.push(x)
    });

    lineChart.data.datasets[0].data = temps;
    lineChart.data.datasets[1].data = hourlyTemps;
    lineChart.update();
};

$("#btn").click(function(e) {
    e.preventDefault();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/WebApplication_war/rest/tutorial",
        data: {
            city: $("#city").val(),
            field: $("#field").val(),
            date: $("#date").val(),
            // hour: $("#hour").val()
            value: $("#value").val(),
        },
        success: function (result) {
            daily(result);
        },
        error: function(result) {
            alert('error');
        }
    });
});