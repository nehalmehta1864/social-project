app.controller("blogController", function($scope, $http, $location) {
	function fetchAllBlog() {
		console.log("Fetching all blogs");
		$http.get("http://localhost:8002/socialrestend/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	}
	;
	fetchAllBlog();
	$scope.insertBlog = function() {
		console.log('entered insertBlog');
		$http.post('http://localhost:8002/socialrestend/insertBlog',	$scope.blog)
		.then(fetchAllBlog(), function(response) 
		{
			console.log("successful blog entered");
			$location.path("/blog")
		});
	};
	$scope.deleteBlog = function(blogId) {
		console.log("entering in delete blog");
		$http.get("http://localhost:8002/socialrestend/deleteBlog/"+ blogId)
				.success(fetchAllBlog(), function(response) {
			console.log('successful deletion');
			$scope.refresh();
			$location.path("/blog");

		});
	};
	$scope.likeBlog=function(blogId)
	{
		console.log("enterd into like ");
		$http.get('http://localhost:8002/socialrestend/incLike/'+ blogId)
		.success(fetchAllBlog(),function(response)
				{
				console.log("like incremented")
				$scope.refresh();
				$location.path("/blog");
				});
	};
});