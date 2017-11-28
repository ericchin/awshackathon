<%@ include file="/init.jsp" %>

<%
String series = (String) request.getAttribute("series");
%>

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
				pointInterval: 2629746000,
				pointStart: Date.UTC(2017, 4, 1, 0, 0, 0)
			}
		},

		series: <%= series %>,

		tooltip: {
			formatter: function() {
				return Chart.dateFormat('%M:%S', this.y);
			}
		},

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