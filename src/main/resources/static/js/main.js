var app = angular.module("queueManager", []);

app.controller('EmployeeController', function ($scope, $http) {
    $http({
        method: 'GET',
        url:    '/employees/get-all'
    }).then(function (response) {
        $scope.employees = response.data;
    });

    $scope.getEmployee = function ($employee) {
        $http({
            method: 'GET',
            url:    '/employees/get/' + $employee.id
        }).then(function (response) {
            $scope.emp = response.data;
        });
    };

    $scope.saveEmployee = function () {
        $http({
            method: 'POST',
            url:    '/employees/save',
            data:   $scope.emp
        }).then(function (response) {
            $scope.employees = response.data;
            $scope.emp = {};
        });
    };

    $scope.updateEmployee = function () {
        $http({
            method: 'POST',
            url:    '/employees/update',
            data:   $scope.emp
        }).then(function (response) {
            $scope.employees = response.data;
            $scope.emp = {};
        });
    };

    $scope.deleteEmployee = function ($employee) {
        $http({
            method: "GET",
            url:    "/employees/delete/" + $employee.id,
        }).then(function (response) {
            $scope.employee = response.data;
            $scope.emp = {};
        });
    };
});

app.controller('BoardController', function ($scope, $http) {
    $http({
        method: 'GET',
        url:    '/boards/get-all'
    }).then(function (response) {
        $scope.boards = response.data;
    });

    $scope.getBoard = function ($board) {
        $http({
            method: 'GET',
            url:    '/boards/get/' + $board.id
        }).then(function (response) {
            $scope.brd = response.data;
        });
    };

    $scope.saveBoard = function () {
        $http({
            method: 'POST',
            url:    '/boards/save',
            data:   $scope.brd
        }).then(function (response) {
            $scope.boards = response.data;
            $scope.brd = {};
        });
    };

    $scope.updateBoard = function () {
        $http({
            method: 'POST',
            url:    '/boards/update',
            data:   $scope.brd
        }).then(function (response) {
            $scope.boards = response.data;
            $scope.brd = {};
        });
    };

    $scope.deleteBoard = function ($board) {
        $http({
            method: "GET",
            url:    "/boards/delete/" + $board.id,
        }).then(function (response) {
            $scope.employee = response.data;
            $scope.brd = {};
        });
    };
});
