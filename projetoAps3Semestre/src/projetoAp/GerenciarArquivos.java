package projetoAp;

import java.io.File;

public class GerenciarArquivos {
    static String basePath = System.getProperty("user.dir"); // pega o diretório onde o programa foi iniciado
	static String arquivoSelecionado;

    public static void decidirArquivo(int opcao1) {
		if (opcao1 == 1 || opcao1 == 2) {
			arquivoSelecionado = "Cursos";
		} else if (opcao1 == 3 || opcao1 == 4) {
			arquivoSelecionado = "Alunos";
		}
		
	}

	public static String CaminhoCompleto() {
		return basePath + File.separator + "Files" + File.separator + arquivoSelecionado + ".csv";
	}
}
