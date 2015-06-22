
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
            pointFormat: '{series.name}: <b>{point.y:.3f}</b>'
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
function typeAttendenceChartsEmp(){
    $('#type-attendence-container').html('');
    $('#type-attendence-container').removeAttr('data-highcharts-chart');
}
function typeAttendenceCharts(datax,datay){
    $('#type-attendence-container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'FilmType Attendence'
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
            pointFormat: '{series.name}: <b>{point.y:.3f}</b>'
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
            pointFormat: '{series.name}: <b>{point.y:.3f}</b>'
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