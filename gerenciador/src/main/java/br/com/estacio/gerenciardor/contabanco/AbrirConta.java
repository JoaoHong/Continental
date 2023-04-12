package br.com.estacio.gerenciardor.contabanco;



public class AbrirConta{
	public static void mainAbrirConta(String[] args) {
		ContaBanco resContaBanco = new ContaBanco();
		resContaBanco.numConta = 1234;
		resContaBanco.tipo = "CC";
	}
}