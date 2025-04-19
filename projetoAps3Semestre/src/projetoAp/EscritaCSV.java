package projetoAp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class EscritaCSV {
	public static void escreveCsvAluno(List<Aluno> linhas, String filePath) {
		try(	OutputStream arquivo = new FileOutputStream(filePath);
				OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
				PrintWriter escreve = new PrintWriter(arquivoEscrito, true);
				){
			for(Aluno linha: linhas) {
				escreve.println(linha.getId() + ";" + linha.getNome());
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		
	}
	
	public static void escreveCsvCurso(List<Curso> linhas, String filePath) {
		try(	OutputStream arquivo = new FileOutputStream(filePath);
				OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
				PrintWriter escreve = new PrintWriter(arquivoEscrito, true);
				){
			for(Curso linha: linhas) {
				escreve.println(linha.getCod() + "," + linha.getNome() + "," + linha.getNivel() + "," + linha.getAno());
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		
	}
}
