var chart;
function profitDispatchCharts(profitDispatchData,clickable){
    if(arguments.length==1){
        clickable = true;
    }
    chart = new Highcharts.Chart({
        chart: {
                renderTo:'profitplan-container',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '利润分配图表'
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
                },
                events:{
                        click:function(event){
                            if(clickable){
                                $(".notice-tip").html("编辑模式：< 减少 > 增加 ctrl 退出编辑");
                                var point = event.point;
                                targetPoint = point;
                                //此时增加键盘监听
                                if(!clickbinded){
                                    try{
                                        $(document).unbind("keyup",dispatchMouseClick);
                                    }catch(e){}
                                    $(document).keyup(dispatchMouseClick);    
                                }
                            }
                        }
                }
            }
        },
        series: [{
            type: 'pie',
            name: '利润',
            data: profitDispatchData
        }]
    });
};
var targetPoint = {};
var profitDispatchData;
var clickbinded = false;
/*
    获取数据后进行展示
*/
/*
    获取数据后进行展示
*/
function dispatchMouseClick(event){
    //判断keycode,up增加,down减少
    clickbinded = true;
    var keyCode = event.keyCode;
    switch(keyCode){
        case 37:
            if(targetPoint.y>0){
                profitDispatchData[targetPoint.x] = [targetPoint.name,--targetPoint.y];
                var nextX = (targetPoint.x+1)%profitDispatchData.length;
                var nextName = profitDispatchData[nextX].name;
                var nextY = profitDispatchData[nextX].y;
                profitDispatchData[nextX] = [nextName,++nextY];
                chart.series[0].setData(profitDispatchData);
            }
            break;
        case 39:
            
            var nextX = (targetPoint.x+1)%profitDispatchData.length;
            var nextName = profitDispatchData[nextX].name;
            var nextY = profitDispatchData[nextX].y;
            if(nextY>0){
                profitDispatchData[nextX] = [nextName,--nextY];
                profitDispatchData[targetPoint.x] = [targetPoint.name,++targetPoint.y];
                chart.series[0].setData(profitDispatchData);
            }
            break;
        case 17:
            $(document).unbind("keyup",dispatchMouseClick);
            $(".notice-tip").html("");
            clickbinded = false;
            break;
        default:
            break;

    }
}