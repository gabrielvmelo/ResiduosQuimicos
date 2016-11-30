package residuosquimicos

class Usuario {

    static final int FACILITADOR = 4
    static final int ADMINISTRADOR = 5
    String nome
    String senha
    String ramal
    String email
    int tipo
    boolean associado

    static constraints = {
        nome nullable: false, blank: false
        senha nullable: false, blank: false
        tipo nullable: false, blank: false
    }

    Usuario(String nome, String email, String senha) {
        this.nome = nome
        this.email = email
        this.senha = senha
        this.associado = false
    }

    void setAdmin() {
        this.tipo = ADMINISTRADOR
    }

    void setFacilitador() {
        this.tipo = FACILITADOR
    }
}