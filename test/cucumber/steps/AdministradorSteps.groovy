import cucumber.api.PendingException
import residuosquimicos.ResiduoController

import javax.xml.crypto.Data

/**
 * Created by gvmgs on 04/11/16.
 */

Given(~/^resíduos "([^"]*)", "([^"]*)" e "([^"]*)" foram criados$/) { String res1, String res2, String res3 ->
    to createResiduo
    at createResiduo
    page.createResiduo(res1, 5)
    at showResiduo
    to createResiduo
    at createResiduo
    page.createResiduo(res2, 2)
    at showResiduo
    to createResiduo
    at createResiduo
    page.createResiduo(res3, 5)
    at showResiduo

}

When(~/^Eu tenho a  visualização das opções de relatŕorios$/) { ->
    to gerarRelatorio
    at gerarRelatorio

}
And(~/^Eu clico no botão de gerar relatorio$/) { ->
    page.gerarRelatorioAtual()

}
Then(~/^Eu posso visualizar na tela os resíduos "([^"]*)", "([^"]*)" e "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    at showRelatorio

}


//---------------------------------------------------------------------------------------------------------------------------------------

Given(~/^na data atual não existem residuos armazenados no sistema$/) { ->
    def dataAtual = new Date()

    throw new PendingException()
}
Then(~/^Eu visualizo uma mensagem de erro do sistema informando que não existem residuos armazenados no momento$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Given(~/^residuos "([^"]*)", "([^"]*)", "([^"]*)" foram criados no laboratório "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^residuo "([^"]*)" foi criado na data "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^residuo "([^"]*)" foi criado na data "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^residuo "([^"]*)" foi criado na data "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^Eu seleciono o laboratorio "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu seleciono a opção de gerar relatorio por data$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu escolho a data "([^"]*)" como limitante superior$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu escolho a data "([^"]*)" como limitante inferior$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu mando listar os "([^"]*)" primeiros residuos$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^Eu clico no botão de gerar relatório$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^Eu posso visualizar na tela os residuos "([^"]*)" e "([^"]*)"$/) { String arg1, String arg2 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
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