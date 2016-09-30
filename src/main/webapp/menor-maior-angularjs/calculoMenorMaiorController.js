angular.module("menorMaior").controller("calculoMenorMaiorController", function ($scope) {
	$scope.calcular = function () {
	  if ($scope.idade < 18) {
	    alert("Menor");
	  } else {
	    alert("Maior");
	  }
	};
});
