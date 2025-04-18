package projetoAp;

public class Aluno {
	private String nome;
	private int id;
	public Aluno(String aNome, int aId) {
		this.nome = aNome;
		this.id = aId;
	}
	
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
