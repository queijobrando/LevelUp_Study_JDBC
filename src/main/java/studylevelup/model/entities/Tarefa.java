package studylevelup.model.entities;

public class Tarefa {
    private Integer Id;
    private String nome;
    private String descricao;
    private Usuario usuario;

    public Tarefa(){

    }

    public Tarefa(Integer id, String nome, String descricao, Usuario usuario) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Tarefa(String nome, String descricao, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Tarefa: " +
                "\n" + nome +
                "\n" + descricao;
    }
}
