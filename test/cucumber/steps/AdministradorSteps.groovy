import pages.CreateResiduoPage
import pages.IndexAdministrador
import pages.RelatorioAdmistrador
import pages.ShowResiduo
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioList
import residuosquimicos.Residuo
import residuosquimicos.ResiduoController

import static cucumber.api.groovy.EN.*
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/**
 * Created by gvmgs on 04/11/16.
 */

 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 //controlador

 def criarResiduo(nome, peso, data, laboratorio){
     def lab = Laboratorio.findByLaboratorio(laboratorio)
     def controlador = new ResiduoController()
     def date = new Date(data)
     def residuo = new Residuo([nome: nome, descricao:"None", peso: (double)peso, dataCadastro: date, laboratorio:lab])
     controlador.save(residuo)
     if(lab.residuos == null) lab.residuos = [residuo]
     else lab.residuos.add(residuo)
     lab.save(flush: true)
     controlador.response.reset()

 }

 Given(~/^o residuo "([^"]*)" de peso (\d+) e data de criaçao "([^"]*)" foi criado no sistema$/) { String nome, int peso, String data ->
     criarResiduo(nome, peso, data, LaboratorioList.LABORATORIO_DE_FARMACOLOGIA_E_CANCEROLOGIA_EXPERIMENTAIS)
     assert Residuo.findByNome(nome) != null
 }

 def count = 1
 When(~/^eu tento verificar o número de resíduos vinculados aos departamentos no sistema$/) { ->
     count = Residuo.count()
 }
 Then(~/^o sistema retorna (\d+)$/) { int num ->
     assert num == count
 }

//----------------------------------------------------------------------------------------------------------------------------------------------


Given(~/^o resíduo "([^"]*)" pesando (\d+) criado na data "([^"]*)" está cadastrado$/) { String res1, int peso, String data ->
    to CreateResiduoPage
    at CreateResiduoPage
    page.createResiduo(res1, peso, data)
    at ShowResiduo
}

When(~/^Eu visito a pagina principal de administrador$/) { ->
    to IndexAdministrador
    at IndexAdministrador
}



/*When(~/^Eu clico em gerar relatorio geral$/) { ->
    to IndexAdministrador
    at IndexAdministrador
    page.gerarRelatorio("01/01/1500")
}

Then(~/^Eu posso visualizar na tela os resíduos "([^"]*)", "([^"]*)" e "([^"]*)"$/) { String res1, String res2, String res3 ->
    at RelatorioAdmistrador
    page.hasResiduo(res1)
    page.hasResiduo(res2)
    page.hasResiduo(res3)
}

When(~/^Eu coloco a data "([^"]*)" e clico para gerar relatorio a partir desta data$/) { String data ->
    to IndexAdministrador
    at IndexAdministrador
    page.gerarRelatorio(data)
}

Then(~/^Eu visualizo o residuo "([^"]*)" na tela$/) { String res ->
    at RelatorioAdmistrador
    page.hasResiduo(res)
}*/

Then(~/^o peso total de residuos é igual a (\d+) pesos$/) { int pesoTotal ->
    page.checkPeso(pesoTotal)
}
And(~/^eu tenho (\d+) como total de residuos$/) { int num ->
    page.checkNum(num)
}