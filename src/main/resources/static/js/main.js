const apiUrlAll = "http://localhost:8080/api/v1/city/all";

new Vue({
    el: '#app',
    data: {
        cities: [],
        city: '',
        information: '',
        editing: '',
        editingName: '',
        editingInfo: ''

    },
    methods: {
        getUnits: function () {
            axios
                .get(apiUrlAll)
                .then(response => this.cities = response.data)
        },

        deleteCity: function (id) {
            axios
                .delete("http://localhost:8080/api/v1/city/" + id)
                .then(() => this.getUnits())
            console.log(id)
        },

        addCity: function (name, info) {
            axios
                .post("http://localhost:8080/api/v1/city/", {
                    name,
                    info
                })
                .then(() => {
                    this.getUnits();
                    this.city = '';
                    this.information = '';
                })
        },

        editCity: function (id) {
            this.editing = id;
            this.editingName = this.cities.find(el => el.id === id).name;
            this.editingInfo = this.cities.find(el => el.id === id).info;
        },

        cancel: function () {
            this.editing = '';
            this.editingName = '';
            this.editingInfo = '';
        },

        update: function (id, name, info) {
            axios
                .put("http://localhost:8080/api/v1/city/" + id, {
                    name,
                    info
                })
                .then(() => {
                    this.getUnits();
                    this.cancel();
                })
        }
    },
    beforeMount() {
        this.getUnits()
    }
});




