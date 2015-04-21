public class IdentificadorConta {
	long numero;

	public int calcularDigitoVerificador(long numero) {
		int soma = 0;
		String numeroS = Long.toString(numero);
		for (int i = 0; i < numeroS.length(); i++) {
			soma = soma + numeroS.charAt(i) - 48;
		}
		return soma % 99;
	}

	public boolean verificarValidadeDigito(int num) {
		if (calcularDigitoVerificador(this.numero) == num) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		String n = "Identificador: "+ this.numero;
		return n;
	}
	public IdentificadorConta(long numero) {
		this.numero = numero;
	}
}
