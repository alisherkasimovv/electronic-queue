var app = angular.module("queueManager", []);

app.controller('EmployeeController', function ($scope, $http) {
    var object = [];

    $http({
        method: 'GET',
        url:    '/employees/get-all'
    }).then(function (response) {
        $scope.employees = response.data.employees;
        $scope.boards = response.data.boards;
        $scope.services = response.data.services;
        $scope.departments = response.data.departments;

        $scope.obj = response;
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
        $scope.obj = $scope.emp;
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

app.controller('ServiceController', function ($scope, $http) {
    $http({
        method: 'GET',
        url:    '/services/get-all'
    }).then(function (response) {
        $scope.services = response.data;
    });

    $scope.getService = function ($service) {
        $http({
            method: 'GET',
            url:    '/services/get/' + $service.id
        }).then(function (response) {
            $scope.srv = response.data;
        });
    };

    $scope.saveService = function () {
        $http({
            method: 'POST',
            url:    '/services/save',
            data:   $scope.srv
        }).then(function (response) {
            $scope.services = response.data;
            $scope.srv = {};
        });
    };

    $scope.updateService = function () {
        $http({
            method: 'POST',
            url:    '/services/update',
            data:   $scope.srv
        }).then(function (response) {
            $scope.services = response.data;
            $scope.srv = {};
        });
    };

    $scope.deleteService = function ($service) {
        $http({
            method: "GET",
            url:    "/services/delete/" + $service.id
        }).then(function (response) {
            $scope.services = response.data;
            $scope.srv = {};
        });
    };
});

app.controller('DepartmentController', function ($scope, $http) {
    $http({
        method: 'GET',
        url:    '/departments/get-all'
    }).then(function (response) {
        $scope.departments = response.data;
    });

    $scope.getDepartment = function ($department) {
        $http({
            method: 'GET',
            url:    '/departments/get/' + $department.id
        }).then(function (response) {
            $scope.drp = response.data;
        });
    };

    $scope.saveDepartment = function () {
        $http({
            method: 'POST',
            url:    '/departments/save',
            data:   $scope.drp
        }).then(function (response) {
            $scope.departments = response.data;
            $scope.drp = {};
        });
    };

    $scope.updateDepartment = function () {
        $http({
            method: 'POST',
            url:    '/departments/update',
            data:   $scope.drp
        }).then(function (response) {
            $scope.departments = response.data;
            $scope.drp = {};
        });
    };

    $scope.deleteDepartment = function ($department) {
        $http({
            method: "GET",
            url:    "/departments/delete/" + $department.id
        }).then(function (response) {
            $scope.departments = response.data;
            $scope.drp = {};
        });
    };
});
