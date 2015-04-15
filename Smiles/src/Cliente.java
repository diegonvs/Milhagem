public class Cliente extends Cpf {
	Cpf cpf;
	String nome;
	int idade, sexo; //0 para masculino e 1 para feminino
	double renda;
	
	public String toString() {
		String r = "Nome: " + this.nome + "\n";
		r = r + "CPF: " + this.cpf + "\n";
		return r;
	}
	
	public void getPrimeiroNome(String nome) {
		String primeiroNome = "";
		for (int i = 0; i < nome.length(); i++) {
			if ((i == 0) && (nome.substring(i, i + 1).equalsIgnoreCase(" "))) {
				System.out
						.println("Erro: Nome digitado iniciado com tecla ESPAÇO.");
				break;
			} else if (!nome.substring(i, i + 1).equalsIgnoreCase(" ")) {
				primeiroNome += nome.substring(i, i + 1);
			} else
				break;
		}
		System.out.println(primeiroNome);
	}

	public Cliente(int numero,int dig,String nome,int idade,double renda,int sexo) {
		super(numero,dig);
		//this.cpf = new Cpf(numero,dig);
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.sexo = sexo;
	}
}