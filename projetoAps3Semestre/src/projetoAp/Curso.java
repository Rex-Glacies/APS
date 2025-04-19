package projetoAp;

public class Curso {
	
	private String nome;
	private String nivel;
	private int ano;
	
	public Curso(String aNome, String aNivel, int aAno) {
		
		this.nome = aNome;
		this.nivel = aNivel;
		this.ano = aAno;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getNivel() {
		return this.nivel;
	}
	public int getAno() {
		return this.ano;
	}
	
}
