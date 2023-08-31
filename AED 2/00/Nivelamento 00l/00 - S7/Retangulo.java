class Retangulo{
	private double base, altura;
	
	Retangulo(){
		setBase(MyIO.readDouble("Escreva um valor para a base: "));
		setAltura(MyIO.readDouble("Escreva um valor para a altura: "));
	}
	Retangulo(int base, int altura){
	  setBase(base);
	  setAltura(altura);
	}
	public void setBase(double base){
		this.base = base;
	}
	public void setAltura(double altura){
		this.altura = altura;
	}

	public double getAltura(){
		return this.altura;
	}
	public double getBase(){
		return this.base;
	}

	public double getPerimetro(){
		return 2*(this.base+this.altura);
	}
	public double getDiagonal(){
		return Math.sqrt( (base*base) + (altura*altura) );
	}
}
