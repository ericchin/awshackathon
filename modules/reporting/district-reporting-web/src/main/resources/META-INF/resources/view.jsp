<%@ include file="/init.jsp" %>

<h1><liferay-ui:message key="district-reporting-web.caption"/></h1>

<div id="<portlet:namespace/>chartContainer">
</div>

<aui:script require="reporting-js/js/chart.es" sandbox="true">
	var Chart = reportingJsJsChartEs.default;

	var displayContainer = document.getElementById('<portlet:namespace />chartContainer');

	var config = {
		chart: {},

		title: {
			text: 'Avg Mile Time by District'
		},

		yAxis: {
			pointStart: 0,
			title: {
				text: 'Mile Time'
			},
			type: 'datetime',
			labels: {
				format: '{value:%M:%S}'
			}
		},

		xAxis: {
				title: {
					text: 'Average Mile Time'
			},
			type: 'datetime'
		},

		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'middle'
		},

		plotOptions: {
			series: {
				label: {
					connectorAllowed: false
				},
				pointInterval: 2629746000, // one hour
					pointStart: Date.UTC(2015, 4, 1, 0, 0, 0)
			}
		},

		series: [{
			name: 'Student 1',
			data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
		}, {
			name: 'Student 2',
			data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
		}, {
			name: 'Student 3',
			data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
		}, {
			name: 'Student 4',
			data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
		}],

		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
				chartOptions: {
					legend: {
						layout: 'horizontal',
						align: 'center',
						verticalAlign: 'bottom'
					}
				}
			}]
		}
	};

	var reportingChart = new Chart(config);

	reportingChart.renderChart(displayContainer);
</aui:script>