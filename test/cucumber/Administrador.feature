Feature: usuário administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  #GUI
  Scenario: gerar relatorio com lista de resíduos armazenados atualmente
    Given resíduos "r1", "r2" e "r3" foram criados
    And resíduos "r1", "r2" e "r3" estão armazenados na data atual
    When Eu seleciono a opção de gerar relatorio de residuos atuais
    And Eu clico no botão de gerar relatorio
    Then Eu posso visualizar na tela os resíduos "r1", "r2" e "r3"


#GUI
  Scenario: mostrar erro na geração de relatório atual
    Given na data atual não existem residuos armazenados no sistema
    When Eu seleciono a opção de gerar relatorio de residuos atuais
    And Eu clico no botão de gerar relatorio
    Then Eu visualizo uma mensagem de erro do sistema informando que não existem residuos armazenados no momento


#GUI
  Scenario: gerar relatorio com lista de residuos existentes em determinado espaço de tempo
    Given residuos "r1", "r2", "r3" foram criados no laboratório "LabX"
    And residuo "r1" foi criado na data "20/10/16"
    And residuo "r2" foi criado na data "21/10/16"
    And residuo "r3" foi criado na data "25/10/16"
    When Eu seleciono o laboratorio "LabX"
    And Eu seleciono a opção de gerar relatorio por data
    And Eu escolho a data "22/10/16" como limitante superior
    And Eu escolho a data "20/10/16" como limitante inferior
    And Eu mando listar os "2" primeiros residuos
    And Eu clico no botão de gerar relatório
    Then Eu posso visualizar na tela os residuos "r1" e "r2"
#GUI
  Scenario: gerar relatorio com dias em que residuos estão armazenados
    Given residuos "r1", "r2" e "r3" foram criados em laboratorio "LabX"
    And residuo "r1" foi criado na data "20/10/16"
    And residuo "r2" foi criado na data "21/10/16"
    And residuo "r3" foi criado na data "25/10/16"
    And dia atual é "04/11/16"
    When Eu seleciono o laboratorio "LabX"
    And eu seleciono a opção gerar relatorio de dias em que residuos estão armazenados
    And eu mando listar os "3" primeiros valores
    And Eu clico no botão de gerar relatorio
    Then Eu posso visualizar na tela os valores "20", "19", "15", respectivamente

#GUI
  Scenario: gerar relatorios de ultimos residuos utilizados, na ordem
    Given residuos "r1", "r2", "r3" foram criados no sistema no laboratorio "LabX"
    And "r1" foi utilizado no dia "12/10/16"
    And "r2" foi utilizado no dia "15/12/15"
    And "r3" foi utilizado no dia "10/08/16"
    When Eu seleciono o laboratorio "LabX"
    And Eu seleciono a opção gerar relatorio de ultimos residuos utilizados
    And Eu mando listar os "3" primeiros residuos
    And Eu clico no botão de gerar relatorio
    Then Eu posso visualizar na tela os residuos "r1", "r3" e "r2", respectivamente.