var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",
      
    })
   
  
  
          .when("/mywall", {
        templateUrl : "pages/mywall.html",
        
    })
    
    .when('/blog', {templateUrl : 'blog/blog.html',	controller : 'blogController'})
    .when('/adminBlog',{templateUrl : 'blog/adminBlog.html',controller : 'adminBlogController'})
.when('/register', {templateUrl : 'User/register.html',controller : 'usercontroller'})
	.when('/login', {templateUrl : 'User/login.html',controller : 'usercontroller'})
    
    

    

    
});

/*var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",																										
       
    })
   
    .when("/login", {
        templateUrl : "User/login.html",
        controller : 'UserController'
        
    })
    .when("/register", {
        templateUrl : "User/register.html",
        controller : 'UserController'
        
    })
 .when("/mywall", {
        templateUrl : "User/mywall.html",
        
    })    

.when('/blog', {templateUrl : 'Blog/blog.html',	controller : 'BlogController'})
.when('/adminBlog',{templateUrl : 'Blog/adminBlog.html',controller : 'adminBlogController'})
});   */