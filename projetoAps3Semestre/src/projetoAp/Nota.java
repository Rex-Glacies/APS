package projetoAp;

public class Nota {
    private int idAluno;
    private float np1;
    private float np2;
    private float reposicao;
    private float exame;

    public Nota(int aIdAluno, float aNp1, float aNp2, float aReposicao, float aExame) {
        this.idAluno = aIdAluno;
        this.np1 = aNp1;
        this.np2 = aNp2;
        this.reposicao = aReposicao;
        this.exame = aExame;
    }

    public int getIdAluno() {
        return idAluno;
    }


    public float getNp1() {
        return np1;
    }


    public float getNp2() {
        return np2;
    }
    
    public float getReposicao() {
        return reposicao;
    }


    public float getExame() {
        return exame;
    }

}
