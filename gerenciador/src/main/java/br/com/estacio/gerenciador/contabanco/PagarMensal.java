package br.com.estacio.gerenciador.contabanco;

public class PagarMensal {
	
	private double descontaCc = 12;
	private double descontaPp = 20;
	
	//construtor
	public PagarMensal(double descontaCc, double descontaPp) {
		this.descontaCc = descontaPp;
		this.descontaPp = descontaPp;
	}
	
	public double getDescontaCc() {
	    return descontaCc;
	}

	public void setDescontaCc(double descontaCc) {
	    this.descontaCc = descontaCc;
	}
	
	public double getDescontaPp() {
	    return descontaPp;
	}

	public void setDescontaPp(double descontaPp) {
	    this.descontaPp = descontaPp;
	}
}
