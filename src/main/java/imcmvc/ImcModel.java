package imcmvc;
public class ImcModel {

  public static float calcularImc(float peso, float altura) {
    return peso / (altura * altura);
  }
  
  public static String resultadoImc(float peso, float altura, String sexo) {
    return resultadoImc(calcularImc(peso, altura), sexo);
  }

  public static String resultadoImc(float imc, String sexo) {
    if (sexo == null) {
      return "Resultado indeterminado.";
    }

    String result = "";
    if (sexo.equalsIgnoreCase("M")) {
      if (imc < 20.7) {
        result = "Abaixo do peso.";
      } else if (imc < 26.4) {
        result = "Peso normal.";
      } else if (imc < 27.8) {
        result = "Marginalmente acima do peso.";
      } else if (imc < 31.1) {
        result = "Acima do peso ideal.";
      } else {
        result = "Obeso.";
      }
    } else if (sexo.equalsIgnoreCase("F")) {
      if (imc < 19.1) {
        result = "Abaixo do peso.";
      } else if (imc < 25.8) {
        result = "Peso normal.";
      } else if (imc < 27.3) {
        result = "Marginalmente acima do peso.";
      } else if (imc < 32.3) {
        result = "Acima do peso ideal.";
      } else {
        result = "Obeso.";
      }
    } else {
      result = "Resultado indeterminado. Sexo desconhecido.";
    }
    return result;
  }
  
}

