package residuosquimicos

import grails.transaction.Transactional

@Transactional(readOnly = true)

class AdministradorController {

      def index() {
          redirect(action: 'resumoSistema')
      }

      def resumoSistema() {
        def pesoTotal = 0
        def qntResiduos = 0;

        Laboratorio.all.each {
            it.residuos.each {
                pesoTotal+=it.peso
                qntResiduos++
            }
        }

        [peso: pesoTotal, numResiduos: qntResiduos]
    }

    def relatory() {
        def date = params.date
        def residuos = []

        Laboratorio.all.each{
            it.residuos.each{
                if(it.dataCadastro >= date){
                    residuos.push(it)
                }
            }
        }

        [residuos: residuos]
    }

    def relatoryGeral(){
        def residuos = []

        Laboratorio.all.each{
            it.residuos.each{
                residuos.push(it)
            }
        }

        render(view: 'relatory', model: [residuos: residuos])
    }

}
