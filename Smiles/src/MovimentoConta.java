import java.util.*;

public class MovimentoConta {
	ContaMilhagem contaMilhagemdeOrigem, contaMilhagemdeDestino;
	int valorTransacao, tipodaTransacao;
	String nomedaFonte;
	Date d;

	public String getNomeExtrato() {
		String nomeT = this.contaMilhagemdeOrigem.cliente.nome;
		String primeiroNome;
		String ultimoNome;
		if (nomeT.indexOf(' ') != -1) {
			primeiroNome = (nomeT.substring(0, nomeT.indexOf(' ')))
					.toUpperCase();
		} else
			primeiroNome = nomeT;
		if (nomeT.indexOf(' ') == -1) {
			ultimoNome = null;
		} else {
			ultimoNome = nomeT
					.substring(nomeT.lastIndexOf(' '), nomeT.length())
					.toUpperCase();
		}
		String nomeA = null;
		switch (contaMilhagemdeOrigem.cliente.sexo) {
		case 0:
			nomeA = ultimoNome + ',' + primeiroNome + " MR.";
			break;
		case 1:
			nomeA = ultimoNome + ',' + primeiroNome + " MRS.";
			break;
		default:
			return null;
		}
		return nomeA;

	}

	public MovimentoConta(ContaMilhagem origem, int valor,
			ContaMilhagem destino, String nomedaFonte, Date date) {
		this.contaMilhagemdeOrigem = origem;
		this.valorTransacao = valor;
		this.contaMilhagemdeDestino = destino;
		this.nomedaFonte = nomedaFonte;
		this.d = date;
	}
}
