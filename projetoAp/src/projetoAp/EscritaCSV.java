package projetoAp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
public class EscritaCSV {
	public static void escreveCSV(List<String> linhas, String filePath) {
		
		try(	OutputStream arquivo = new FileOutputStream(filePath);
				OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
				PrintWriter escreve = new PrintWriter(arquivoEscrito, true);
				){
			for(String linha: linhas) {
				escreve.println(linha);
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
	}
}
