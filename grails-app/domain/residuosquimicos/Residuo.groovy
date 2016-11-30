package residuosquimicos

class Residuo {
    String nome
    String descricao
    double peso
    Date dataCadastro
    Date dataRemocao

    static belongsTo = [laboratorio:Laboratorio]

    static constraints = {
        nome blank:false
        descricao blank:false
        dataRemocao nullable: true
    }


}
