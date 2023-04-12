package br.com.estacio.gerenciador.contabanco;

public class ContaBanco {
	int numConta;
	String tipo;
	String dono;
	float saldo;
	boolean status;
	void retorno() {
		System.out.println("Número: " + this.numConta);
		System.out.println("Tipo: " + this.tipo);
		System.out.println("Dono: " + this.dono);
		System.out.println("Saldo: " + this.saldo + "R$");
		System.out.println("Status: " + this.status);
	}
}
