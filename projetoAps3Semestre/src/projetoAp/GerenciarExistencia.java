package projetoAp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class GerenciarExistencia {
    public static File file = new File(GerenciarArquivos.CaminhoCompleto());
    public static String linha;

    public static BufferedReader AbrirArqivo() {
  
        if (!file.exists()) {
            return null;
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            return new BufferedReader(inputStreamReader);
            //String linha;
 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean CursoIgual(String dados) {
        BufferedReader br = AbrirArqivo();

        if (br == null) {
            return false;
        }

        try {
            

            while ((linha = br.readLine()) != null) {
                if (linha.equals(dados)) {
                    return true;
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;

    }

    public static boolean alunoIdIgual(int dados) {
        BufferedReader br = AbrirArqivo();

        if (br == null) {
            return false;
        }

        try {
            
            while ((linha = br.readLine()) != null) {
                String[] campo = linha.split(";");
                if (campo.length > 0 &&  campo[0].equals(String.valueOf(dados))) {
                    return true;
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}

