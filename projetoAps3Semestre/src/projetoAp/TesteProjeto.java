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
		
		while (opcao > 6 || opcao < 0) {
			System.out.println("Valor Invalido");
			System.out.println("\n====== MENU DE CURSOS ======");
			System.out.println("1 - Cadastrar novo curso");
			System.out.println("2 - Listar cursos");
			System.out.println("3 - Cadastrar Aluno");
			System.out.println("4 - Listar Alunos");
			System.out.println("5 - Cadastrar Nota");
			System.out.println("6 - Listar Notas");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
						
			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Erro: a opção não é um número válido.");
			}
		}
		
		
		switch (opcao) {
			case 1:
				GerenciarArquivos.decidirArquivo(opcao);
				System.out.print("Nome do curso: ");
				String nomeCurso = scanner.nextLine();

				System.out.print("Nível do curso: ");
				String nivel = scanner.nextLine();

				System.out.print("Ano do curso: ");
				int ano = 0;
				try {
					 ano = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}
				
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
				int id = 0;
				try {
					 id = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}
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
				int anCurso = 0;
				try {
					anCurso = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}

				GerenciarArquivos.decidirArquivoNota(opcao,nCurso, niCurso, anCurso);

				System.out.println("Digite o Id do aluno: ");
				int alunoid = 0;
				try {
					alunoid = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}

				System.out.println("Digite a nota da NP1:");
				float np1 = 0;
				try {
					np1 = Float.parseFloat(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}

				System.out.println("Digite a nota da NP2:");
				float np2 = 0;
				try {
					np2 = Float.parseFloat(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}

				System.out.println("Digite a nota da Reposição:");
				String reposicaoInput = scanner.nextLine();
				float reposicao = 0;
				try {
					reposicao = reposicaoInput.isEmpty() ? -1 : Float.parseFloat(reposicaoInput);
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}

				System.out.println("Digite a nota do exame:");
				String exameInput = scanner.nextLine();
				float exame = 0;
				try {
					exame = exameInput.isEmpty() ? -1 : Float.parseFloat(exameInput);
				} catch (NumberFormatException e) {
					System.out.println("Erro: Insira somente números");
				}


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