package projetoAp;

import java.io.File;

public class GerenciarArquivos {
    static String basePath = System.getProperty("user.dir"); 
	static String arquivoSelecionado;

    public static void decidirArquivo(int opcao1) {
		if (opcao1 == 1 || opcao1 == 2) {
			arquivoSelecionado = "Cursos";
		} else if (opcao1 == 3 || opcao1 == 4) {
			arquivoSelecionado = "Alunos";
		} 
	}

	public static void decidirArquivoNota(int opcao1, String nomeCurso, String nivelCurso, int anoCurso) {
		if (opcao1 == 5 || opcao1 == 6) {
			arquivoSelecionado = nomeCurso + "_" + nivelCurso + "_" + anoCurso;
		}
	}

	public static String CriarArquivoNota (String nomeCurso, String nivelCurso, int anoCurso) {
		arquivoSelecionado = nomeCurso + "_" + nivelCurso + "_" + anoCurso;
		return basePath + File.separator + "Files" + File.separator + arquivoSelecionado + ".csv";

	}

	public static String CaminhoCompleto() {
		return basePath + File.separator + "Files" + File.separator + arquivoSelecionado + ".csv";
	}
}
