
public class TesteIdentificadorConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentificadorConta iC = new IdentificadorConta(1234);
		System.out.println(iC.verificarValidadeDigito(10));
		System.out.println(iC.calcularDigitoVerificador(1234));
		////////////////////////////////////////////////////////
		
	}

}
