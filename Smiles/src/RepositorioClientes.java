import java.util.Arrays;

public class RepositorioClientes {

	private Cliente[] elementos;
	private int qtd;

	public RepositorioClientes() {
		elementos = new Cliente[100];
		qtd = 0;
	}

	public Cliente buscar(Cpf c) {
		Cliente r = null;
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].getCpf().equals(c)) {
				r = elementos[i];
				return r;
			}
		}
		return null;
	}

	public String buscarB(Cpf c) {
		Cliente r = null;
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].getCpf().equals(c)) {
				r = elementos[i];
				return r.toString();
			}
		}
		return null;
	}

	public void incluir(Cliente c) {
		if (qtd < this.elementos.length) {
			//if (this.buscar(c.cpf.getCpf().equals(null))) {
				this.elementos[++qtd] = c;
			} else {
				System.out.println("Elemento já existe!");
			}
		//} else {
			System.out.println("Repositorio cheio!");
		}
	//}

	public void alterar(Cliente cliente) {
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].equals(cliente)) {
				elementos[i] = cliente;
				break;
			}
		}
	}

	public boolean excluir(Cpf cpf) {
		boolean r = false;
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].getCpf().equals(cpf)) {
				elementos[i] = null;
				elementos[i] = elementos[--qtd];
				elementos[qtd] = null;
				r = true;
				break;
			}
		}
		return r;
	}

	public void listar() {
		System.out.println("--- CLIENTES CADASTRADOS ---");
		for (int i = 0; i < qtd; i++) {
			System.out.println("Dados do cliente: " + (i + 1));
			System.out.println(elementos[i]);
		}
		System.out.println("----------------------------");
	}
}
