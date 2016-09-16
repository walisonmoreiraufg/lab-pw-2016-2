<html>
<head>
<title>Cálculo de IMC</title>
</head>
<body>
	<h1>Cálculo de IMC</h1>
	<form>
		Peso: <input type="text" name="peso" value="${param.peso}"><br>
		Altura: <input type="text" name="altura" value="${param.altura}"><br>
		Sexo: <input type="text" name="sexo" value="${param.sexo}"><br>
		<button>Calcular</button>
	</form>
    <b>${resultadoImc}</b>
</body>
</html>
