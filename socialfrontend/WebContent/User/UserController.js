


app.controller("UserController", function ($scope,$location,$http) {
	 $scope.msg = "Register  page";
	 $scope.user={username:'',firstname:'',lastname:'',email:'',password:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.registerUser=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:8002/socialrestend/user/register",$scope.user).then(function(response){
		 
			 console.log("Registerd Successfully")
						});
		 
	 }
	 
	 
	 
	 $scope.login=function()
	 {
		 console.log("in login method");
		 $http.post("http://localhost:8002/socialrestend/user/login",$scope.user).then(function(response)
				 {
			
			 
			 $scope.user=response.data;
	
			 $location.path("/login")
				 });
		 
	 }
});



app.controller("UserController", function ($scope,$location,$http,$rootScope) {

	 $scope.logout=function()
	 {
	 
		 console.log( $rootScope.currentuser.email)
			$http.get("http://localhost:8002/socialrestend/user/logout/"+ $rootScope.currentuser.email)
				.then(function(response)
				{
					 $rootScope.currentuser=null;
					 $location.path("/login")
					
				},function(error)
				{
					
				});
	 
	 }
	 
	 
	 
	 


	
});