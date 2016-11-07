import cucumber.api.PendingException
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioController
import residuosquimicos.Residuo
import residuosquimicos.ResiduoController
import residuosquimicos.StatusController

import javax.xml.crypto.Data

import static cucumber.api.groovy.EN.*

/**
 * Created by gvmgs on 04/11/16.
 */

Given(~/^resíduos "([^"]*)", "([^"]*)" e "([^"]*)" foram criados$/) { String res1, String res2, String res3 ->
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res1, 5)
    at ShowResiduo
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res2, 2)
    at ShowResiduo
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res3, 5)
    at ShowResiduo

}

When(~/^Eu tenho a  visualização das opções de relatŕorios$/) { ->
    to GerarRelatorio
    at GerarRelatorio

}
And(~/^Eu clico no botão de gerar relatorio$/) { ->
    page.gerarRelatorioAtual()

}
Then(~/^Eu posso visualizar na tela os resíduos "([^"]*)", "([^"]*)" e "([^"]*)"$/) { String res1, String res2, String res3 ->
    at ShowRelatorio

}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Given(~/^na data atual não existem residuos armazenados no sistema$/) { ->
    to GerarRelatorio
    at GerarRelatorio

}

When(~/^Eu tenho a  visualização das opções de relatŕorios$/) { ->
    to GerarRelatorio
    at GerarRelatorio
}
Then(~/^Eu visualizo uma mensagem de erro do sistema informando que não existem residuos armazenados no momento$/) { ->
    page.showErro

}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Given(~/^residuos "([^"]*)", "([^"]*)", "([^"]*)" foram criados no laboratório "([^"]*)"$/) { String res1, String res2, String res3, String Labx ->
    def data1 = new Date("20/10/2016")
    def data2 = new Date("21/10/2016")
    def data3 = new Date("25/10/2016")

    to CreateLaboratorio
    at CreateLaboratorio
    page.createLaboratorio(Labx)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res1, 5, data1)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res2, 4, data2)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res3, 2, data3)
    at ShowLaboratorio

}

When(~/^Eu seleciono o laboratorio "([^"]*) e eu seleciono a opção de gerar relatorio entre datas "([^"]*) e "([^"]*) e Eu mando listar os (\d+) primeiros residuos/) { String Labx, String date1, String date2, int n ->
    to GerarRelatorio
    at GerarRelatorio
    page.GerarRelatorioDatas(Labx, date1, date2, n)
    at ShowRelatorio

}

Then(~/^Eu posso visualizar na tela os residuos "([^"]*)" e "([^"]*)"$/) { String arg1, String arg2 ->
    at ShowRelatorio
}


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Given(~/^residuos "([^"]*)", "([^"]*)" e "([^"]*)" foram criados em laboratorio "([^"]*)"$/) { String res1, String res2, String res3, String Labx ->
    def data1 = new Date("20/10/2016")
    def data2 = new Date("21/10/2016")
    def data3 = new Date("25/10/2016")

    to CreateLaboratorio
    at CreateLaboratorio
    page.createLaboratorio(Labx)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res1, 5, data1)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res2, 4, data2)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res3, 2, data3)
    at ShowLaboratorio
}
When(~/^Eu seleciono o laboratorio "([^"]*)", eu seleciono a opção gerar relatorio de dias em que residuos estão armazenados eu mando listar os (\d) primeiros valores$/) { String Labx, int n ->
    to GerarRelatorio
    at GerarRelatorio
    page.gerarRelatorioDeNDias(labx, n)
}
Then(~/^Eu posso visualizar na tela os valores "([^"]*)", "([^"]*)", "([^"]*)", respectivamente$/) { String arg1, String arg2, String arg3 ->
    at ShowRelatorio
}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Given(~/^residuos "([^"]*)", "([^"]*)", "([^"]*)" foram criados no sistema no laboratorio "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
    def data1 = new Date("20/10/2016")
    def data2 = new Date("21/10/2016")
    def data3 = new Date("25/10/2016")

    to CreateLaboratorio
    at CreateLaboratorio
    page.createLaboratorio(Labx)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res1, 5, data1)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res2, 4, data2)
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.CreateResiduo(res3, 2, data3)
    at ShowLaboratorio
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String res1, String data ->
    to GerarRelatorio
    at GerarRelatorio
    page.removeResiduo(res1, data)
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String res2, String data ->
    to GerarRelatorio
    at GerarRelatorio
    page.removeResiduo(res2, data)
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String res3, String data ->
    to GerarRelatorio
    at GerarRelatorio
    page.removeResiduo(res3, data)
}
When(~/^Eu seleciono a opção gerar relatorio de ultimos residuos utilizados$/) { ->
    to GerarRelatorio
    at GerarRelatorio
    page.ListaDeUtilizados()
}
Then(~/^Eu posso visualizar na tela os residuos "([^"]*)", "([^"]*)" e "([^"]*)", respectivamente\.$/) { String arg1, String arg2, String arg3 ->
    at ShowRelatorio
}



//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Given(~/^o sistema possui o laboratório "([^"]*)" com departamento "([^"]*)" e centro "([^"]*)" cadastrado$/) { String labx, String departx, String cx ->
    criarLaboratorio(labx, departx, cx)
    assert Laboratorio.findByNomeLaboratorio(Labx) != null
}

def criarLaboratorios(String labName, String depName, String centName) {
    def laboratorio = new Laboratorio([nomeCentro: centName, nomeDepartamento: depName, nomeLaboratorio:labName, solicitante: null, responsavel:null, solicitado:false])
    def controler = new LaboratorioController()
    controler.save(laboratorio)
    controler.response.reset()
}

And(~/^o residuo "([^"]*)" de peso "([^"]*)" está vinculado ao laboratorio "([^"]*)"$/) { String res1, Double peso1, String Labx ->
    criarResiduo(res1, peso1)
    assert !Laboratorio.findByNomeLaboratorio(res1).residuos.empty
}

def criarResiduo(String res1, Double peso1, String Labx){
    def laboratorio = Laboratorio.findByNomeLaboratorio(Labx)
    def residuo = new Residuo([nome: res1, descricao: "None", peso: peso1, laboratorio: laboratorio])
    def controler = new ResiduoController()
    controler.save(residuo)
    controler.response.reset()
}

int n = 0
When(~/^eu tento verificar o número de resíduos vinculados aos departamentos no sistema$/) { ->
    def statusController = new StatusController()
    n = statusController.numeroResiduos()
}
Then(~/^o sistema retorna "([^"]*)"$/) { int num ->
    assert num == n
}