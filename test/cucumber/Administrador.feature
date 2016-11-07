Feature: usuário administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  #GUI
  Scenario: gerar relatorio com lista de resíduos armazenados atualmente
    Given resíduos "r1", "r2" e "r3" foram criados
    When Eu tenho a  visualização das opções de relatorios
    And Eu clico no botão de gerar relatorio atual
    Then Eu posso visualizar na tela os resíduos "r1", "r2" e "r3"


#GUI
  Scenario: mostrar erro na geração de relatório atual
    Given na data atual não existem residuos armazenados no sistema
    When Eu tenho a  visualização das opções de relatorios visiveis
    And Eu clico no botão de gerar relatorio
    Then Eu visualizo uma mensagem de erro do sistema informando que não existem residuos armazenados no momento


#GUI
  Scenario: gerar relatorio com lista de residuos existentes em determinado espaço de tempo
    Given residuos "r1", "r2", "r3" foram criados no laboratório "LabX"
    When Eu seleciono o laboratorio "LabX" e eu seleciono a opção de gerar relatorio entre datas "22/10/2016" e "20/10/2016" e Eu mando listar os "2" primeiros residuos
    Then Eu posso visualizar na tela os residuos "r1" e "r2"
#GUI
  Scenario: gerar relatorio com dias em que residuos estão armazenados
    Given residuos "r1", "r2" e "r3" foram criados em laboratorio "LabX"
    When Eu seleciono o laboratorio "LabX", eu seleciono a opção gerar relatorio de dias em que residuos estão armazenados eu mando listar os 3 primeiros valores
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

#CONTROLER
    Scenario: buscar numero de residuos armazenados
      Given o sistema possui o laboratório "LabX" com departamento "DepartX" e centro "Cx" cadastrado
      And o residuo "res1" de peso "200" está vinculado ao laboratorio "LabX"
      When eu tento verificar o número de resíduos vinculados aos departamentos no sistema
      Then o sistema retorna "1"