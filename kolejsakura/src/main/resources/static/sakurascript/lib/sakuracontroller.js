angular.module('MySakuraEventApp')

 /*myapp.config(['$routeProvider',function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'sakura.html',
		controller: 'SakuraController'
	})
	.when('/event', {
		templateUrl: 'event.html',
		controller: 'SakuraController'
	})
	.when('/view', {
		templateUrl: 'viewEvent.html',
		controller: 'SakuraController'
	})
	.when('/info', {
		templateUrl: 'info.html',
		controller: 'SakuraController'
	})
	.when('/login', {
		templateUrl: 'login.html',
		controller: 'SakuraController'
	})
	.otherwise({
		redirectTo: '/'
	})
	
	
}]);*/



myapp.controller('SakuraController',['$scope','EventList',
function($scope,EventList){


  EventList.getEvents(function(err, data) {
                if (!err) {
                  $scope.categoryList = data;
                  $scope.eventList = data;
                  console.log(data);
                };
              });


//      EventList.getEventsRead(function(err, data) {
//                    if (!err) {
//  //                    $scope.categoryList = data;
//                      $scope.eventList = data;
//                      console.log(data);
//                    };
//                  });
////  				}

  

  $scope.selectCategory = function(category) {
    	$scope.selectedCategory = category;
        }


  $scope.selectEvent = function(event) {
    	$scope.selectedEvent = event;
        }
  $scope.participants=[];
  $scope.selectedparticipants=[];
  $scope.keep_part={};

  $scope.addEventParticipant = function(){
    $scope.participants.push({participantName:$scope.participants.participant});
    $scope.participants.participant="";
  };

  $scope.deleteEventParticipant = function(index){
    $scope.participants.splice(index,1);
  }

  $scope.addParticipant = function(){
    $scope.selectedEvent.participants.push({participantName: $scope.participantName});
    $scope.participantName = "";
  };

  $scope.keepParticipant= function(participant){
    angular.copy(participant, $scope.keep_part);
    $scope.selectedparticipants.push($scope.keep_part.pID);
    console.log($scope.selectedparticipants);
  }

$scope.deleteParticipant= function(index){
  $scope.selectedEvent.participants.splice(index,1);
}
  $scope.pushEID = function(eid) {
      $scope.id = eid;
      	}

  $scope.deleteEvent = function(id) {
      var id;
      id = $scope.id;
      EventList.deleteEvent(id,function(err, data) {
        		if (!err) {
        		$scope.msg = 'success';
          }
      EventList.getEvents(function(err,data) {
        		if (!err) {
      		$scope.categoryList = data;
        		$scope.eventList = data;
        		console.log(data);
        												};
        											});
        										});
            $('#deleteModal').modal('hide');
        	}

  $scope.addEvent = function() {
  if ($scope.categoryList.selectedOption.categoryType != undefined
  										&& $scope.EventTitle != undefined
  										&& $scope.EventDescription != undefined
  										&& $scope.participants != undefined) {
  									var event = {
  										categoryType : $scope.categoryList.selectedOption.categoryType,
  										eventName : $scope.EventTitle,
  										eventDescription : $scope.EventDescription,
  										participants : $scope.participants,
  									};

                  EventList.postEvent(function(data,err){
                        if(!err){
                          EventList.getEvents(function(err,data){
                            if(!err){
                              $scope.categoryList = data;
                              $scope.eventList = data;
                              console.log(data);
                            };
                          });
                          $scope.categoryList.selectedOption.categoryType = "";
                          $scope.EventTitle="";
                          $scope.EventDescription="";
                          $scope.participants="";
                          $scope.participants=[];
                        }
                      },event);
                  }else{
                    alert("Kindly complete the empty options.");
                  }
                }
    $scope.updateEvent = function(selectedparticipants){

      if(selectedparticipants!=null){
        EventList.putEvent($scope.selectedEvent,function(err, data) {
            if (!err) {
                 EventList.getEvents(function(err,data) {
                			if (!err) {
               				$scope.categoryList = data;
                				$scope.eventList = data;
                				console.log(data);
                				};
                			});
                		}
                	});

                  var p=0;
                  while(p < selectedparticipants.length){
                    var pid;
                    pid = selectedparticipants[p];

                    EventList.deletePart(pid,function(err,data){
                      if(!err){
                        $scope.msg = 'success';
                      }
                    });
                    p++
                    if(p> selectedparticipants.length)
                    break;
                  }
            	}else{
                EventList.putEvent(
                  $scope.selectedEvent,function(err,data){
                    if (!err){
                      EventList.getEvents(function(err,data){
                        if(!err){
                         $scope.categoryList = data;
                          $scope.eventList = data;
                          console.log(data);
                        };
                      });
                    }
                  });
              }$('#updateModal').modal('hide');
            }
    $scope.Create = function() {
      $('#createEvent').modal('hide');
        	}
    $scope.Edit = function() {
      $('#readEventModal').modal('hide');
        	}
    $scope.Update = function(){
      $('#updateEventModal').modal('hide');
    }
}
]);
