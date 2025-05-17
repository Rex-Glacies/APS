package projetoAp;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteProjeto {

    public static int verificarNumeroInteiros(String mensagem) {
		Scanner scanner = new Scanner(System.in);
		int numero = 0;
		boolean valida = false;

		while (!valida) {
			System.out.println(mensagem);

			try {
				numero = Integer.parseInt(scanner.nextLine());
				valida = true;
			} catch (NumberFormatException e) {
				System.out.println("Erro: Insira somente números.");
			}
		}

		return numero;

    }

	public static Float verificarNumeroFloat(String mensagem) {
		Scanner scanner = new Scanner(System.in);
		Float numero = 0f;
		boolean valida = false;

		while (!valida) {
			System.out.println(mensagem);

			try {
				numero = Float.parseFloat(scanner.nextLine());
				valida = true;
			} catch (NumberFormatException e) {
				System.out.println("Erro: Insira somente números.");
			}
		}

		return numero;

    }

	public static float verificarNumeroFloatOpcional(String menssagem) {
		Scanner scanner = new Scanner(System.in);
		float numero = -1f;

		while (true) {
			System.out.println(menssagem);
			String resposta = scanner.nextLine();

			if (resposta.isEmpty()) {
				return numero;
			}

			try {
				return Float.parseFloat(resposta);
			} catch (NumberFormatException e) {
				System.out.println("Erro: Insira somente números.");
			}
		}
	}
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

				int ano = verificarNumeroInteiros("Ano do curso: ");
				
				Curso ncurso = new Curso(nomeCurso, nivel, ano);
				EscritaCSV.escreveCsvCurso(ncurso);
				
				break;
			case 2:
				GerenciarArquivos.decidirArquivo(opcao);
				LeituraCSV.leCsvCurso();
				break;
			case 3:
				GerenciarArquivos.decidirArquivo(opcao);
				int id = verificarNumeroInteiros("Id do aluno: ");

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

				int anCurso =  verificarNumeroInteiros("Ano do curso para inserir a nota: ");


				GerenciarArquivos.decidirArquivoNota(opcao,nCurso, niCurso, anCurso);

				int alunoid = verificarNumeroInteiros("Digite o Id do aluno: ");

				float np1 = verificarNumeroFloat("Digite a nota da NP1:");

				float np2 = verificarNumeroFloat("Digite a nota da NP2:");

				float reposicao = verificarNumeroFloatOpcional("Digite a nota da Reposição:");

				float exame = verificarNumeroFloatOpcional("Digite a nota do exame:");
	


				Nota nNota = new Nota(alunoid, np1, np2, reposicao, exame);
				EscritaCSV.escreveNota(nNota);
				break;
			case 6:
				System.out.println("Nome do curso: ");
				String lernCurso = scanner.nextLine();

				System.out.println("Nivel do curso: ");
				String lerniCurso = scanner.nextLine();

				int leranCurso = verificarNumeroInteiros("Ano do curso: ");

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