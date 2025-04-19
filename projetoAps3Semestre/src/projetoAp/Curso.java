package projetoAp;

public class Curso {
	private int cod;
	private String nome;
	private String nivel;
	private int ano;
	
	public Curso(int aCod, String aNome, String aNivel, int aAno) {
		this.cod = aCod;
		this.nome = aNome;
		this.nivel = aNivel;
		this.ano = aAno;
	}
	
	public String getNome() {
		return nome;
	}
	public int getCod() {
		return cod;
	}
	public String getNivel() {
		return nivel;
	}
	public int getAno() {
		return ano;
	}
	
}
