function ageChartsEmp(){
    $('#age-container').html('');
    $('#age-container').removeAttr('data-highcharts-chart');
}
function ageCharts(data){
    $('#age-container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Age Form'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Age',
            data: data
        }]
    });
}
    

function sexChartsEmp(){
    $('#sex-container').html('');
    $('#sex-container').removeAttr('data-highcharts-chart');
}
function sexCharts(data){
    $('#sex-container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'Sex<br>Form',
            align: 'center',
            verticalAlign: 'middle',
            y: 50
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                dataLabels: {
                    enabled: true,
                    distance: -50,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        fontWeight: 'bold',
                        color: 'white',
                        textShadow: '0px 1px 2px black'
                    }
                },
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%']
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            innerSize: '50%',
            data: data
        }]
    });
}

function locationChartsEmp(){
    $('#location-container').html('');
    $('#location-container').removeAttr('data-highcharts-chart');
}
function locationCharts(data){
    $('#location-container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Location Form'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Location',
            data: data
        }]
    });
}
function cardChartsEmp(){
    $('#card-container').html('');
    $('#card-container').removeAttr('data-highcharts-chart');
}
function cardCharts(data){
    $('#card-container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Card Status Form'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Card Stauts',
            data: data
        }]
    });
}
function personChartsEmp(){
    $('#person-day-container').html('');
    $('#person-day-container').removeAttr('data-highcharts-chart');
}
function personCharts(data){
    $('#person-day-container').highcharts({
        title: {
            text: "Persons' Sum By Day"
        },
        xAxis: {
            categories: ['1','2','3','4','5','6','7','8','9','10',
            '11','12','13','14','15','16','17','18','19','20',
            '21','22','23','24','25','26','27','28','29','30','31']
        },
        yAxis: {
            title: {
                text: 'PeronsSum'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'persons'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'sum-line',
            data: data
        }]
    });
}
function filmAttendenceChartsEmp(){
    $('#film-attendence-container').html('');
    $('#film-attendence-container').removeAttr('data-highcharts-chart');
}
function filmAttendenceCharts(datax,datay){
    $('#film-attendence-container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Film Attendence'
        },
        xAxis: {
            categories: datax
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Attendence'
            }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Attendence',
            data: datay

        }]
    });
}
function hallAttendenceChartsEmp(){
    $('#hall-attendence-container').html('');
    $('#hall-attendence-container').removeAttr('data-highcharts-chart');
}
function hallAttendenceCharts(datax,datay){
    $('#hall-attendence-container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Hall Attendence'
        },
        xAxis: {
            categories: datax
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Attendence'
            }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Attendence',
            data: datay

        }]
    });
}
function paywayChartsEmp(){
    $('#payway-container').html('');
    $('#payway-container').removeAttr('data-highcharts-chart');
}
function paywayCharts(data){
    $('#payway-container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Payway Form'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Payway',
            data: data
        }]
    });
}
