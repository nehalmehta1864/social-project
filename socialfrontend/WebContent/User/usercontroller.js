
app.controller("usercontroller", function ($scope,$location,$http,$rootScope) {
	 $scope.msg = "Register  page";
	 $scope.Users={firstname:'',lastname:'',email:'',password:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.register=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:8002/socialrestend/register",$scope.User).then(function(response){
		 
			 console.log("Registerd Successfully")
			 $scope.Users=response.data;
			 $location.path("/login")
								
			},function(error){
			
			});
		 
	 }
	 
	 
	 
	 $scope.login=function()
	 {
		 console.log("in login method");
		 $http.post("http://localhost:8002/socialrestend/login",$scope.Users).then(function(response)
				 {
			
			 
			 $scope.Usersdet=response.data;
			 $rootScope.currentuser=response.data;
			 console.log("ROLE"+$rootScope.currentuser.role)
			 $location.path("/blog")
				 });
		 
	 }
	 
});



app.controller("logoutcontroller", function ($scope,$location,$http,$rootScope) {

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
/*app.controller('UserController',['$scope','UserService','$cookies','$location','$rootScope','$cookieStore','$http',
	function($scope, userservice,$cookies, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside UserController")
	this.user={
		errorCode : '',
		errorMsg : '',
		userID : '',
		userName : '',
		userPassword : '',
		isOnline : '' ,
		lastSeenOnline : '',
		userRole : '',
		
	};
	
	$rootScope.currentUser ={
			userID : '',
			userName : '',
			userPassword : '',
			isOnline : '' ,
			lastSeenOnline : '',
			userRole : '',
		};
	
	$scope.users = [];
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	};
	$scope.createUser = function(user) {
		console.log("Creating user");
		userservice.createUser(user)
		.then(
				function(d) {
					$location.path("/register")
					$scope.user=d;
					alert("Please wait for the admin approval");
				},
				function(errResponse) {
					console.error('Error while creating user');
				});
	};
	$scope.reset = function() {
		$scope.user = {
				userID : '',
				userName : '',
				userPassword : '',
				isOnline : '' ,
				lastSeenOnline : '',
				userRole : '',
		};
		$scope.regform.$setPristine(); 
	};
	$scope.submit = function() {
		{
			console.log('Saving New User');
			$scope.createUser(this.user);
		}
		$scope.reset();
	};
	$scope.login =function(){
		console.log('Performing Login operations');		
		userservice.login($scope.user)
		.then(
				function(d){
					$cookieStore.put('currentUser',d);
					$rootScope.currentUser=d;
					$rootScope.myUser=$rootScope.currentUser;
					var role=$rootScope.currentUser.userRole;
			    	if(role==='ROLE_USER'){
					$location.path("/login")
			    	}
			    	if(role==='ROLE_ADMIN'){
			    		$location.path("/login")
			    	}
				},
				function(errResponse) {
					console.error('Error while login');
				});
	};
	$scope.logout=function(){
		console.log("Logout User");
		user=$cookieStore.get('currentUser');
		userservice.logout(user)
		.then(
				function(){
					$cookieStore.remove('currentUser');
					$location.path("/logout")
				},
				function(errResponse) {
					console.error('Error while logout');
				});
	};
	

	$scope.getAllUsers=function(){
		console.log("Getting all users")
		$scope.getUserFriends()
		userservice.getAllUsers()
		.then(
				function(d){
					this.user=$cookieStore.get('currentUser');
					var userid=this.user.userID;
					var index=d.findIndex(x => x.userID==userid);
					d.splice(index,1);
					this.users=d;
					this.friends=$rootScope.friends;
					for(i=0;i<friends.length;i++){
						for(j=0;j<users.length;j++){
						if(friends[i].friendId===users[j].userID){
							d.splice(j,1);
						}
						}
					}
					$rootScope.users=d;					
					$location.path("/getAllUsers")
				},
				function(errResponse){
					console.error('Error while getting users')
				});
	};
	
	
	
}])










app.controller("UserController", function ($scope,$location,$http) {
	 $scope.msg = "Register  page";
	 $scope.user={username:'',firstname:'',lastname:'',email:'',password:'',role:'ROLE_USER',isonline:'NO'};
	 $scope.registerUser=function()
	 {
		 console.log("in register controller angualar");
		
		 $http.post("http://localhost:8002/socialrestend/user/registerUser",$scope.user).then(function(response){
		 
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
	 
	 
	 
	 


	
});*/