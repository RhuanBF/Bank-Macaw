
package BancoDados;

public class ModeloCliente {
    
    public class Cliente {
    private Integer id;
    private String nome;
    private String celular;
    private String email;
    private String senha;
    private String cpf;
    private String dtnascimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCpf (){ //Adicionei o CPF para deixar o cliente mais unico, vemos depois
        return cpf;
    }
    public void setCpf (String cpf){
        this.cpf = cpf;
    }
    //testeeeeeee
    public String getDtnascimento(){
        return dtnascimento;
    }
    
    public void setDtnascimento (String dtnascimento){
        this.dtnascimento = dtnascimento;
    }
        
    }
    
}
