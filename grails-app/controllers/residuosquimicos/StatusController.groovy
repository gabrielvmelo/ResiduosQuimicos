package residuosquimicos

class StatusController {

    def index() { }

    def numeroResiduos(){
        double totalResiduos = Residuo.all.size()
        return totalResiduos
    }

    def numeroLaboratorios(){
        double totalLabs = Laboratorio.all.size()
        return totalLabs
    }
}
