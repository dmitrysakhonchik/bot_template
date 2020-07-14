const apiURL = "http://localhost:8080/api/v1/city/all";
new Vue({
    el: '#app',
    data() {
        return {
            cities: []
        }
    },
    created() {
        fetch(apiURL )
            .then(response => {
                return response.json();
            })
            .then(cities => {
                this.cities = cities;
            })
    }
});