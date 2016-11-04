import cucumber.api.PendingException
import residuosquimicos.ResiduoController

import javax.xml.crypto.Data

import static cucumber.api.groovy.EN.When

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

Given(~/^residuos "([^"]*)", "([^"]*)" e "([^"]*)" foram criados em laboratorio "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^dia atual é "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^eu seleciono a opção gerar relatorio de dias em que residuos estão armazenados$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^eu mando listar os "([^"]*)" primeiros valores$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^Eu posso visualizar na tela os valores "([^"]*)", "([^"]*)", "([^"]*)", respectivamente$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Given(~/^residuos "([^"]*)", "([^"]*)", "([^"]*)" foram criados no sistema no laboratorio "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^"([^"]*)" foi utilizado no dia "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu seleciono a opção gerar relatorio de ultimos residuos utilizados$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^Eu posso visualizar na tela os residuos "([^"]*)", "([^"]*)" e "([^"]*)", respectivamente\.$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}