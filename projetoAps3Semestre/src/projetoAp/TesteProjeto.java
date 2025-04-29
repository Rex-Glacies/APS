package projetoAp;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteProjeto {
	public static void main(String[] args) throws FileNotFoundException {

	Scanner scanner = new Scanner(System.in);
	int opcao = 0;

	do {
		System.out.println("\n====== MENU DE CURSOS ======");
		System.out.println("1 - Cadastrar novo curso");
		System.out.println("2 - Listar cursos");
		System.out.println("3 - Cadastrar Aluno");
		System.out.println("4 - Listar Alunos");
		System.out.println("5 - Cadastrar Nota");
		System.out.println("6 - Listar Notas");
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
				break;
			case 4:
				GerenciarArquivos.decidirArquivo(opcao);
				LeituraCSV.leCsvAluno();
				break;
			case 5:
				System.out.println("Nome do curso para inserir a nota: ");
				String nCurso = scanner.nextLine();

				System.out.println("Nivel do curso para inserir a nota: ");
				String niCurso = scanner.nextLine();

				System.out.println("Ano do curso para inserir a nota: ");
				int anCurso = Integer.parseInt(scanner.nextLine());

				GerenciarArquivos.decidirArquivoNota(opcao,nCurso, niCurso, anCurso);

				System.out.println("Digite o Id do aluno: ");
				int alunoid = Integer.parseInt(scanner.nextLine());

				System.out.println("Digite a nota da NP1:");
				float np1 = Float.parseFloat(scanner.nextLine());

				System.out.println("Digite a nota da NP2:");
				float np2 = Float.parseFloat(scanner.nextLine());

				System.out.println("Digite a nota da Reposição:");
				String reposicaoInput = scanner.nextLine();
				float reposicao = reposicaoInput.isEmpty() ? -1 : Float.parseFloat(reposicaoInput);

				System.out.println("Digite a nota do exame:");
				String exameInput = scanner.nextLine();
				float exame = exameInput.isEmpty() ? -1 : Float.parseFloat(exameInput);


				Nota nNota = new Nota(alunoid, np1, np2, reposicao, exame);
				EscritaCSV.escreveNota(nNota);
				break;
			case 6:
				System.out.println("Nome do curso: ");
				String lernCurso = scanner.nextLine();

				System.out.println("Nivel do curso: ");
				String lerniCurso = scanner.nextLine();

				System.out.println("Ano do curso: ");
				int leranCurso = Integer.parseInt(scanner.nextLine());

				GerenciarArquivos.decidirArquivoNota(opcao,lernCurso, lerniCurso, leranCurso);

				LeituraCSV.leCsvNota();
				break;

			case 0:
				System.out.println("Saindo...");
				break;

	
		}
			
	} while (opcao !=0);

	scanner.close();
}

}