angular.module("menorMaior", ["ngRoute"]);

angular.module("menorMaior").config(function ($routeProvider) {

    $routeProvider.when("/calculo", {
        templateUrl: "menor-maior-angularjs/calculoMenorMaiorView.html",
        controller: "calculoMenorMaiorController"
    });

    $routeProvider.when("/bemvindo", {
        templateUrl: "menor-maior-angularjs/bemVindoView.html",
    });

    $routeProvider.otherwise({redirectTo: "/bemvindo"});
});