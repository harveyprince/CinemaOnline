function profitChartsEmp(){
    $('#profit-container').html('');
    $('#profit-container').removeAttr('data-highcharts-chart');
}
function profitCharts(data){
    $('#profit-container').highcharts({
        title: {
            text: "Profit' Sum By Year"
        },
        xAxis: {
            title: {
                text: 'Year'
            }
        },
        yAxis: {
            title: {
                text: 'ProfitSum'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'profits'
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