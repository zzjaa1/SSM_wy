window.onload=function () {
    $('.container1').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '报修处理情况'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
            name: 'Browser share',
            data: [
                ['进行中', 25],
                ['未处理', 30],
                /*{
                 name: 'Chrome',
                 y: 12.8,
                 sliced: true,
                 selected: true
                 },*/
                ["已完成",45]
            ]
        }]
    });
    $('.container2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '报修评分情况'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
            name: 'Browser share',
            data: [
                ['满意（4.5-3颗星）',10],
                ['不满意（2.5-0.5颗星）',30],
                /*{
                 name: 'Chrome',
                 y: 12.8,
                 sliced: true,
                 selected: true
                 },*/
                ["很满意（5颗星）",60]
            ]
        }]
    });
};