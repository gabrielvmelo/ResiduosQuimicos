package residuosquimicos

class StatusController {

    def index() { }

    def numeroResiduos(){
        double totalResiduos = Residuos.all.size()
        return totalResiduos
    }
}
