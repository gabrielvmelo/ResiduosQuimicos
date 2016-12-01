package residuosquimicos

class Laboratorio {
    CentroList centro
    DepartamentoList departamento
    LaboratorioList laboratorio
    Usuario solicitante
    Usuario responsavel

    static hasMany = [residuos: Residuo]

    static constraints = {
        centro blank: false
        departamento blank: false
        laboratorio blank: false
        solicitante nullable: true
        responsavel nullable: true
    }

}
