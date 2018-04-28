angular.module('app.controllers', []).controller('GarageListController', function($scope, $state, popupService, $window, Garage) {
  $scope.garages = Garage.query(); //fetch all garages. Issues a GET to /api/vi/garages

  $scope.deleteGarage = function(garage) { // Delete a Garage. Issues a DELETE to /api/v1/garages/:id
    if (popupService.showPopup('Are you sure you want to delete this?')) {
      garage.$delete(function() {
        $scope.garages = Garage.query(); 
        $state.go('garages');
      });
    }
  };
}).controller('GarageViewController', function($scope, $stateParams, Garage) {
  $scope.garage = Garage.get({ id: $stateParams.id }); //Get a single Vehicle.Issues a GET to /api/v1/garages/:id
}).controller('GarageCreateController', function($scope, $state, $stateParams, Garage) {
  $scope.garage = new Garage();  //create new vehicle instance. Properties will be set via ng-model on UI

  $scope.addGarage = function() { //create a new garage. Issues a POST to /api/v1/garages
    $scope.garage.$save(function() {
      $state.go('garages'); // on success go back to the list i.e. garages state.
    });
  };
}).controller('GarageEditController', function($scope, $state, $stateParams, Garage) {
  $scope.updateGarage = function() { //Update the edited garage. Issues a PUT to /api/v1/garages/:id
    $scope.garage.$update(function() {
      $state.go('garages'); // on success go back to the list i.e. garages state.
    });
  };

  $scope.loadGarage = function() { //Issues a GET request to /api/v1/garages/:id to get a garage to update
    $scope.garage = Garage.get({ id: $stateParams.id });
  };

  $scope.loadGarage(); // Load a garage which can be edited on UI
});
