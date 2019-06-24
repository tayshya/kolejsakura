angular.module("MySakuraEventApp").factory("EventList", function($http) {
  var getEvents = function(cb) {
  		$http({
  			method : 'GET',
  			url : 'http://localhost:8080/sakuraevent/category',
  		}).success(function(data, status, headers, config) {
  			cb(null, data);
  		}).error(function(data, status, headers, config) {
  			cb(data);
  		});
  	}


  var getEventsRead = function(cb) {
  		$http({
  			method : 'GET',
  			url : 'http://localhost:8080/sakuraevent/event',
  		}).success(function(data, status, headers, config) {
  			cb(null, data);
  		}).error(function(data, status, headers, config) {
  			cb(data);
  		});
  	}


  var postEvent = function(cb, data) {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/sakuraevent/event',
			data : data,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});

	}

  var putEvent = function(data, cb) {
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/sakuraevent/event',
			data : data,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var deleteEvent = function(id, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/sakuraevent/event/' + id,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}

	var deletePart = function(pid, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/sakuraevent/event/participant/' + pid,
		}).success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
			cb(null, data);
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			cb(data);
		});
	}
  
  
  return {
		getEvents : getEvents,
		  getEventsRead : getEventsRead,
		postEvent : postEvent,
	    putEvent : putEvent,
		deleteEvent : deleteEvent,
		deletePart :deletePart
		
  }
});
