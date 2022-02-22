class DashboardViewModel {
	constructor() {
		// domain related observables
		this.stocks = ko.observableArray([]);
		this.symbol = ko.observable("");
		this.windowSize = ko.observable(10);
		this.isMonitoring = ko.observable(false);
		this.connected = ko.observable(false);
		this.previousPrice = 0;
		// websocket view model
		this.socket = new WebSocket(AppConfig.WS_URL);
		this.socket.onopen = (event) => {
			this.connected(true);
			toastr.success("Connected!", "", AppConfig.TOASTR_CONFIG);
		};
		this.socket.onmessage = (message) => {
			let total = 0.0;
			if (!this.isMonitoring()) return;
			let e = JSON.parse(message.data);
			console.log(e);
			total = total + Number(e.p) * Number(e.q);
			this.data.datasets[0].data.push(Number(e.p));
			let now = new Date().toTimeString();
			now = now.replace(/.*(\d{2}:\d{2}:\d{2}).*/, '$1');
			this.data.labels.push(now);
			if (this.data.datasets[0].data().length > this.windowSize()) {
				let sliceIndex = this.data.datasets[0].data().length
					- this.windowSize();
				this.data.datasets[0].data(
					this.data.datasets[0].data.slice(sliceIndex)
				);
				this.data.labels(this.data.labels.slice(sliceIndex));
			}
		};

		this.data = {
			labels: ko.observableArray([]),
			datasets: [
				{
					label: [],
					backgroundColor: "rgba(220,220,220,0.2)",
					borderColor: "rgba(220,220,220,1)",
					pointColor: "rgba(220,220,220,1)",
					pointStrokeColor: "#fff",
					pointHighlightFill: "#fff",
					pointHighlightStroke: "rgba(220,220,220,1)",
					data: ko.observableArray([])
				}
			]
		};

		this.changeLng = this.changeLng.bind(this);
		this.i18n = this.i18n.bind(this);
		this.translate = this.translate.bind(this);
		this.start = this.start.bind(this);
		this.stop = this.stop.bind(this);
	}

	// i18n
	changeLng(lng) {
		i18n.setLng(lng, () => {
			this.i18n();
		});
	};

	i18n() {
		$(document).i18n();
	};

	translate(word) {
		return i18n.t(word);
	};

	// starts monitoring
	start() {
		this.isMonitoring(true);
		this.data.datasets[0].label.push(this.symbol());
		toastr.success(i18n.t("messageMonitoringStarted"), "", AppConfig.TOASTR_CONFIG);
	};

	// stops monitoring
	stop() {
		this.isMonitoring(false);
		toastr.warning(i18n.t("messageMonitoringStoped"), "", AppConfig.TOASTR_CONFIG);
	};

};

var dashBoardViewModel = new DashboardViewModel();

$(() => {
	i18n.init(AppConfig.I18N_CONFIG, (t) => {
		$(document).i18n();
		ko.applyBindings(dashBoardViewModel);
	});
});
