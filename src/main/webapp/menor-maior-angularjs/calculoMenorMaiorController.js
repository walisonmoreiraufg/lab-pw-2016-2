angular.module("menorMaior").controller("calculoMenorMaiorController", function ($scope, $http) {
  $scope.calcular = function () {
    $http.get('menormaiorrest?idade=' + $scope.idade).
      then(function(response) {
          alert(response.data.resultado);
          alert(response.data.dataDeProcessamento);
      });
    //if ($scope.idade < 18) {
    //    alert("Menor");
    //  } else {
    //    alert("Maior");
    //  }
  };
});
