package br.com.estacio.gerenciador.contabanco;

public class FecharConta {
	public static void mainFecharConta(String[] args) {
		ContaBanco resContaBanco = new ContaBanco();
		resContaBanco.numConta = 1235;
		resContaBanco.tipo = "CC";
		resContaBanco.dono = "Otavio Lopes";
		resContaBanco.saldo = 24;
		resContaBanco.status = true;
	}
	
}