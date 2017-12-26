/*app.factory("userservice",function($http){
    var BASE_URL="http://localhost:8002/socialrestend";
    var userservice ={};
	
	
	userservice.getAllUser=function(){
		return $http.get(BASE_URL+"/User/getAllUsers");		
	}
	
	
	
	userservice.createUser=function(user){
		console.log("****** inside user service--createUser()*****")
		return $http.post(BASE_URL+"/User/register",user);		
	}
	
	
	
	
	return userservice;
});*/