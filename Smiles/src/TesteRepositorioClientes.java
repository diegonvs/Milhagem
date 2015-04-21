public class TesteRepositorioClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositorioClientes rc = new RepositorioClientes();
		Cliente c1 = new Cliente(108797804,10,"Diego Nascimento",18,100,0);
		Cliente c2 = new Cliente("12345678910","Carabino Tiro Certo",50,16000,0);
		rc.incluir(c1);
		rc.incluir(c2);
		rc.listar();
	}

}
