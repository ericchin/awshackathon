import Highcharts3d from "./utils/highcharts-3d.es";
import Highcharts from "highcharts/highcharts.src";

let default3dEdgeColor = {
	borderColor: 'transparent',
	edgeColor: 'transparent'
};

Highcharts3d(Highcharts);

// API for Highcharts can be found at: http://api.highcharts.com/highcharts

class Chart {
	static dateFormat(format, time) {
		return Highcharts.dateFormat(format, new Date(time));
	}

	constructor(config) {
		this.config = config;
	}

	renderChart(container) {
		this.config.chart.renderTo = container;

		if (this.config.chart.options3d) {
			this.config = Object.assign(this.config, default3dEdgeColor);
		}

		let chart = new Highcharts.Chart(
			container,
			this.config
		);
	}
}

export default Chart;