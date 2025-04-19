package projetoAp;

import java.util.List;

public class TesteProjeto {
	public static void main(String[] args) {

		List<Aluno> alunos = LeituraCSV.leCsvAluno("Files/Alunos.csv");		
		
		alunos.add(new Aluno(2, "Lucas"));
		
		EscritaCSV.escreveCsvAluno(alunos, "Files/Alunos.csv");
		
		alunos = LeituraCSV.leCsvAluno("Files/Alunos.csv");
		
		
	}
}
