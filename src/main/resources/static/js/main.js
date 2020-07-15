const apiUrlAll = "http://localhost:8080/api/v1/city/all";

let app = new Vue({
    el: '#app',
    data: {
        cities: []
    },
    mounted() {
        axios
            .get(apiUrlAll)
            .then(response => this.cities = response.data)
    }
});

