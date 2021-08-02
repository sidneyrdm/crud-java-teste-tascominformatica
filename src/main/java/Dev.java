public class Dev {

    private int id;
    private String nome;
    private String projeto;
    private int idade;

    public Dev(){
    }

    public Dev(int id, String nome, String projeto, int idade){
        this.id = id;
        this.nome = nome;
        this.projeto = projeto;
        this.id = idade;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getProjeto(){
        return projeto;
    }

    public void setProjeto(String projeto){
        this.projeto = projeto;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", projeto='" + projeto + '\'' +
                ", idade=" + idade +
                '}';
    }
}



