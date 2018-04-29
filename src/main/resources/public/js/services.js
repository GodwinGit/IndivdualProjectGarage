angular.module('app.services', []).factory('Garage', function($resource) {
  return $resource('/api/v1/garages/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
