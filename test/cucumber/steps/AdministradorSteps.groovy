import pages.CreateLaboratorioPage
import pages.CreateResiduoPage
import pages.IndexAdministrador
import pages.IndexResiduo
import pages.ShowResiduo
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioController
import residuosquimicos.Residuo
import residuosquimicos.ResiduoController
import residuosquimicos.StatusController

import static cucumber.api.groovy.EN.*
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/**
 * Created by gvmgs on 04/11/16.
 */

 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 //controlador

 def criarResiduo(nomeRes, pesoRes, data, laboratorio){
     def lab = Laboratorio.findByLaboratorio(laboratorio)
     def residuo = new Residuo([nome: nome, descricao:"None", peso: (double)peso, dataCadastro: (new Date(data)), laboratorio:lab])
     def controlador = new ResiduoController()
     assert residuo.laboratorio != null
     controlador.request.method = "POST"
     assert controlador.request.post
     controlador.save(residuo)
     assert controlador.response.status == 201
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

And(~/^o resíduo "([^"]*)" pesando (\d+) criado na data "([^"]*)" está cadastrado$/) { String res2, int peso2, String data2 ->
    to CreateResiduoPage
    at CreateResiduoPage
    page.createResiduo(res2, peso2, data2)
    at ShowResiduo
}

And(~/^o resíduo "([^"]*)" pesando (\d+) criado na data "([^"]*)" está cadastrado$/) { String res3, int peso3, String data3 ->
    to CreateResiduoPage
    at CreateResiduoPage
    page.createResiduo(res3, peso3, data3)
    at ShowResiduo
}

When(~/^Eu visito a pagina principal de administrador$/) { ->
    to IndexAdministrador
    at IndexAdministrador
}

Then(~/^o peso total de residuos é igual a (\d+) pesos"$/) { int pesoTotal ->
    page.checkPeso(pesoTotal)
}

And(~/^e eu tenho (\d+) como total de residuos"$/) { int num ->
    page.checkResiduos(num)
}

When(~/^Eu clico em gerar relatorio geral$/) { ->
    to IndexAdministrador
    at IndexAdministrador
    page.gerarRelatorio("01/01/1500")
}

Then(~/^Eu posso visualizar na tela os resíduos "([^"]*)", "([^"]*)" e "([^"]*)"$/) { String res1, String res2, String res3 ->
    at RelatorioAdimistrador
    hasResiduo(res1)
    hasResiduo(res2)
    hasResiduo(res3)
}

When(~/^Eu coloco a data "([^"]*)" e clico para gerar relatorio a partir desta data$/) { String data ->
    to IndexAdministrador
    at IndexAdministrador
    page.gerarRelatorio(data)
}

Then(~/^Eu visualizo o residuo "([^"]*)" na tela$/) { String res ->
    at RelatorioAdimistrador
    hasResiduo(res)
}
