var taskManagerModule = angular.module('BookStoreApplication', ['ngAnimate']);

taskManagerModule.controller('BookResourceImpl', function ($scope,$http) {
	
	var urlBase="http://localhost:8080/BookStoreApplication";
	$scope.toggle=true;
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
	//get all tasks and display initially
	$http.get(urlBase+'/books').
    	success(function(data) {
	        $scope.tasks = data;
	        for(var i=0;i<$scope.tasks.length;i++){
	           	 $scope.selection.push($scope.tasks[i].taskId);
	        }
    });
	
	//add a new task
	$scope.addTask = function addTask() {
		 $http.post(urlBase + '/book/create/' +$scope.cost+'/'+$scope.createDate+'/'+$scope.description+'/'+$scope.isbn+'/'+$scope.title+'/'+$scope.idpublisher).
		  success(function(data) {
			 alert("Task added");
			 $scope.tasks = data;	
			 $scope.taskName="";
			 $scope.taskDesc="";
			 $scope.taskPriority="";
			 $scope.taskStatus="";
			 $scope.toggle='!toggle';			 
		    });
		}
	};
	