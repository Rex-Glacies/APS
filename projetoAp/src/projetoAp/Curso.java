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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
