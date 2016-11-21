package residuosquimicos

import grails.transaction.Transactional

@Transactional(readOnly = true)

class AdministradorController {

      def index() { }

      def resumoSistema() {
        def pesoTotal = 0
        def qntResiduos = 0;

        Laboratorio.all.each {
            it.residuos.each {
                pesoTotal+=it.peso
                qntResiduos++
            }
        }

        [peso: pesoTotal, qntResiduos: qntResiduos]
    }

    def relatory() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio)
        def date = params.date
        def residuos = []
        if(laboratorioInstance != null) {
            laboratorioInstance.residuos.each {
                if(it.dataCadastro >= date) {
                    residuos.push(it)
                }
            }
        }
        [residuos: residuos]
    }

}
