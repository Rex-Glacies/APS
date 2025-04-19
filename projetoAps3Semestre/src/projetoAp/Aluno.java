package projetoAp;

public class Aluno {
	
	private int id;
	private String nome;
	
	public Aluno(int aId, String aNome) {
		this.id = aId;
		this.nome = aNome;
	}
	
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	
}
