package projetoAp;

import java.util.List;

public class TesteProjeto {
	public static void main(String[] args) {

		//List<Aluno> alunos = LeituraCSV.leCsvAluno("Files/Alunos.csv");		
		
		//alunos.add(new Aluno(2, "Lucas"));
		
		//EscritaCSV.escreveCsvAluno(alunos, "Files/Alunos.csv");
		
		//alunos = LeituraCSV.leCsvAluno("Files/Alunos.csv");
		
		List<Curso> cursos = LeituraCSV.leCsvCurso("Files/Cursos.csv");
		
		cursos.add(new Curso("Python", "Avançado", 4));
		
		EscritaCSV.escreveCsvCurso(cursos, "Files/Cursos.csv");
		
		cursos = LeituraCSV.leCsvCurso("Files/Cursos.csv");
		
		
	}
}
