import java.util.*;

public class TesteMovimentoConta {

	public static void main(String[] args) {
		Cliente c = new Cliente(108797804, 10, "Diego Nascimento", 18, 200, 0);
		Cliente c2 = new Cliente(739540687, 70, "Teste", 19, 100, 1);
		IdentificadorConta ic = new IdentificadorConta(100);
		IdentificadorConta ic2 = new IdentificadorConta(100);
		ContaMilhagem cm1 = new ContaMilhagem(ic, c);
		ContaMilhagem cm2 = new ContaMilhagem(ic2, c2);
		MovimentoConta mc1 = new MovimentoConta(cm1, 200, cm2,
				"Diego Nascimento", new Date());
		MovimentoConta mc2 = new MovimentoConta(cm2, 200, cm1, "Teste",
				new Date());
		System.out.println(cm1.saldo);
		System.out.println("1");
		System.out.println(cm2.saldo);
		System.out.println("2");
		System.out.println(mc1.getNomeExtrato());
		System.out.println(mc2.getNomeExtrato());
		System.out.println(mc1.d);
		System.out.println(mc2.d);

	}
}
