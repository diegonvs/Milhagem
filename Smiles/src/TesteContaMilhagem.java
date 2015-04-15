public class TesteContaMilhagem {

	public static void main(String[] args) {
		Cliente c = new Cliente(108797804, 10, "Diego", 18, 200, 0);
		Cliente c2 = new Cliente(739540687, 70, "Teste", 19, 100, 0);
		IdentificadorConta ic = new IdentificadorConta(100);
		IdentificadorConta ic2 = new IdentificadorConta(100);
		ContaMilhagem cm1 = new ContaMilhagem(ic, c);
		ContaMilhagem cm2 = new ContaMilhagem(ic2, c2);
		// ////////////////////////////////////////////////////////////////////////
		System.out.println(cm1.saldo);
		System.out.println(cm2.saldo);
		// ////////////////////////////////////////////////////////////////////////
		cm1.Creditar(20);
		System.out.println(cm1.saldo);
		cm2.Creditar(20);
		System.out.println(cm2.saldo);

	}

}
