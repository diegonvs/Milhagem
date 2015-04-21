
public class TesteCliente {

	public static void main(String[] args) {
		Cliente c1 = new Cliente(108797804, 10, "Diego Nascimento", 18, 100, 0);
		System.out.println(c1.getPrimeiroNome());
		System.out.println(c1.toString());
		System.out.println(c1.getUltimoNome());
		Cliente c2 = new Cliente("12345678910","Diego Nascimento",18,100,0);
		System.out.println(c2.getCpf());
		
	}

}
