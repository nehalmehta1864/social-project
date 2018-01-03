app.factory("userServices", function($http) {
	var BASE_URL = "http://localhost:8002/socialrestend/";
	var userServices = {};

	userServices.getAllUser = function() {
		return $http.get(BASE_URL + "/getAllUsers");
	}
});