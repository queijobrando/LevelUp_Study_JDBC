package studylevelup.model.entities;

import java.util.Date;

public class Usuario extends Pessoa{
    private Integer id;
    private String nickname;
    private String senha;

    public Usuario(){

    }

    public Usuario(String nome, String email, Date dataNascimento, String nickname, String senha) {
        super(nome, email, dataNascimento);
        this.nickname = nickname;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String email, Date dataNascimento, String nickname, String senha) {
        super(nome, email, dataNascimento);
        this.nickname = nickname;
        this.senha = senha;
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Perfil: " +
                "\nNome: " + getNome() +
                "\nEmail: " + getEmail()
                ;
    }
}
