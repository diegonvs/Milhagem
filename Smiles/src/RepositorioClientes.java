
public class RepositorioClientes {

	private Cliente[] elementos;
	private int qtd;
	
	public RepositorioClientes() {
		elementos = new Cliente[100];
		qtd = 0;
	}
	
	public Cliente buscar(Cpf cpf) {
		Cliente r = null;
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].getCpf().equals(cpf)) {
				r = elementos[i];
				break;
			}
		}
		return r;
	}
	
	public void incluir(Cliente novo) {
		if (qtd < this.elementos.length) {
			if (this.buscar(novo.cpf.getCpf()) == null) {	//esse daqui bernard		
				this.elementos[qtd++] = novo;
			} else {
				System.err.println("Elemento ja existe!");
			}
		} else {
			System.err.println("Repositorio cheio!");
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
			System.out.println("Dados do cliente " + (i+1));
			System.out.println(elementos[i]);
		}
		System.out.println("----------------------------");
	}
}
