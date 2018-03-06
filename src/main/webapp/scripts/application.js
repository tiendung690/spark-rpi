angular.module('pi4jDemo', [])
.controller('relayCtrl', function($scope, $http) {
    $scope.errorMessage =
        'Cannot connect to target host (network problem?)';
    $scope.showError = false;
    $scope.onRelay1Click = function(event) {
        var url = 'api/setRelay?relayNr=1&state=';
        url += $scope.relay1 ? 'off' : 'on';
        $http.get(url).then(function(response) {
            $scope.relay1 = response.data.relay1;
            $scope.showError = false;
            var audio = new Audio(
                $scope.relay1 ? 'sounds/relay-off.wav': 'sounds/relay-on.wav'
            );
            audio.play();
        }, function onError(response) {
            $scope.showError = true;
        })
    };
    $scope.onRelay2Click = function() {
        var url = 'api/setRelay?relayNr=2&state=';
        url += $scope.relay2 ? 'off' : 'on';
        $http.get(url).then(function(response) {
            $scope.relay2 = response.data.relay2;
            $scope.showError = false;
            var audio = new Audio(
                $scope.relay2 ? 'sounds/relay-off.wav': 'sounds/relay-on.wav'
            );
            audio.play();
        }, function onError(response) {
            $scope.showError = true;
        })
    };
    $http.get('api/getRelay?relayNr=1')
        .then(function(response){
            $scope.relay1 = response.data.relay1;
        });
    $http.get('api/getRelay?relayNr=2')
        .then(function(response){
            $scope.relay2 = response.data.relay2;
        });
});
