class ImdbViewModel {
	constructor() {
		this.movies = ko.observableArray([]);
		this.genre = ko.observable("Drama");
		this.fromYear = ko.observable(1970);
		this.toYear = ko.observable(1979);
		this.genres = ko.observableArray([]);
	}

	init = () => {
		fetch("http://localhost:8100/imdb/api/v1/genres", {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(genres => {
			genres.sort();
			this.genres(genres);
		});
	}

	list = () => {
		fetch(`http://localhost:8100/imdb/api/v1/movies?genre=${this.genre()}&fromYear=${this.fromYear()}&toYear=${this.toYear()}`, {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(movies => {
			movies.sort((left, right) => left.title.localeCompare(right.title));
			this.movies(movies);
		});
	}
}

let imdbViewModel = new ImdbViewModel();

window.onload = () => {
	ko.applyBindings(imdbViewModel);
	imdbViewModel.init();
}