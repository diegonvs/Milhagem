public class RepositorioClientes {

	private Cliente[] elementos;
	private int qtd;

	public RepositorioClientes() {
		elementos = new Cliente[150];
		qtd = 0;
	}

	public Cliente buscar(String chave) {
		Cliente r = null;
		for (int i = 0; i < qtd; i++) {
			if (chave.equals(elementos[i].getCpf())) {
				r = this.elementos[i];
				return r;
			}
		}
		return null;
	}

	public void incluir(Cliente c) {
		if (qtd < this.elementos.length && c != null) {
			this.elementos[qtd++] = c;
		} else {
			System.out.println("O repositório está cheio ou cliente é nulo! ");
		}
	}

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
			if (elementos[i].getCpf().equals(cpf.getCpf())) {
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
			System.out.println(elementos[i].toString());
		}
		System.out.println("----------------------------");
	}

}
