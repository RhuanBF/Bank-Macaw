package Backendverificacao;

import BancoDados.ClienteBD;


public class Verificacao {

    public String vitao(String usuario, String senha) {
        String msg;

        if (usuario.isEmpty() || senha.isEmpty()) {
            return " Dado inválido! Preencha todos os campos.";
        }

        ClienteBD cliente = new ClienteBD();
        boolean login = cliente.loginCliente(usuario, senha);

        if (login) {
            msg = "Login realizado com sucesso!";
        } else {
            msg = "Usuário ou senha incorretos.";
        }
        return msg;
    }
}