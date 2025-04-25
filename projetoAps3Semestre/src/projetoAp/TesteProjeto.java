package projetoAp;

import java.util.Scanner;

public class TesteProjeto {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	int opcao = 0;

	do {
		System.out.println("\n====== MENU DE CURSOS ======");
		System.out.println("1 - Cadastrar novo curso");
		System.out.println("2 - Listar cursos");
		System.out.println("3 - Cadastrar Aluno");
		System.out.println("4 - Listar Alunos");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
		opcao = Integer.parseInt(scanner.nextLine());

		
		switch (opcao) {
			case 1:
				GerenciarArquivos.decidirArquivo(opcao);
				System.out.print("Nome do curso: ");
				String nomeCurso = scanner.nextLine();

				System.out.print("Nível do curso: ");
				String nivel = scanner.nextLine();

				System.out.print("Ano do curso: ");
				int ano = Integer.parseInt(scanner.nextLine());
				
				Curso ncurso = new Curso(nomeCurso, nivel, ano);
				EscritaCSV.escreveCsvCurso(ncurso);
				System.out.println("Curso cadastrado com sucesso");
				break;
			case 2:
				GerenciarArquivos.decidirArquivo(opcao);
				LeituraCSV.leCsvCurso();
				break;
			case 3:
				GerenciarArquivos.decidirArquivo(opcao);
				System.out.println("Id do aluno: ");
				int id = Integer.parseInt(scanner.nextLine());
				
				System.out.println("Nome do aluno: ");
				String nomeAluno = scanner.nextLine();

				Aluno naluno = new Aluno(id, nomeAluno);
				EscritaCSV.escreveCsvAluno(naluno);

				System.out.println("Aluno cadatrado com sucesso");
				break;
			case 4:
				GerenciarArquivos.decidirArquivo(opcao);
				LeituraCSV.leCsvAluno();
				break;
			case 0:
				System.out.println("Saindo...");
				break;

	
		}
			
	} while (opcao !=0);

	scanner.close();
}

}