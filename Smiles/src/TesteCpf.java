public class TesteCpf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpf c1 = new Cpf("10879780410");
		Cpf c2 = new Cpf(123456789, 10);
		System.out.println("Construtor Sobrecarregado de String: ");
		System.out.println(c1.getNumero());
		System.out.println(c1.getDigito());
		System.out.println("Construtor Sobrecarregado de inteiros: ");
		System.out.println(c2.getNumero());
		System.out.println(c2.getDigito());
		System.out.println("Métodos toString() e getCpf(): ");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c1.getCpf());
		System.out.println(c2.getCpf());

	}

}
