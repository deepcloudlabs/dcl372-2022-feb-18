class WorldViewModel {
	constructor() {
		this.countries = ko.observableArray([]);
		this.continent = ko.observable();
		this.continents = ko.observableArray([]);
	}

	init = () => {
		fetch("http://localhost:8100/world/api/v1/continents", {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(continents => {
			continents.sort();
			this.continents(continents);
		});
	}

	list = () => {
		fetch(`http://localhost:8100/world/api/v1/countries?continent=${this.continent()}`, {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(countries => {
			countries.sort((left, right) => left.name.localeCompare(right.name));
			this.countries(countries);
		});
	}
}

let worldViewModel = new WorldViewModel();

window.onload = () => {
	ko.applyBindings(worldViewModel);
	worldViewModel.init();
}