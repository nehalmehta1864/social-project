
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",																										
       
    })
   
    .when("/login", {
        templateUrl : "User/login.html",
       
    })
    .when("/register", {
        templateUrl : "User/register.html",
        
    })
 .when("/mywall", {
        templateUrl : "User/mywall.html",
        
    })    

.when('/blog', {templateUrl : 'blog/blog.html',	controller : 'blogController'})
.when('/adminBlog',{templateUrl : 'blog/adminBlog.html',controller : 'adminBlogController'})
});   