Feature: usuário administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  #GUI
  Scenario: mostrar uma lista de residuos a partir de uma certa data
    Given os residuos "res1" e "res2" estão cadastrados no sistema
    And o residuo "res3" com a data "10/08/2016" também está cadastrado
    When eu clico para gerar um relatorio com "02/08/2016" como data
    Then eu visualizo os residuos "res1", "res2" e "res3" na pagina de relatorio

#GUI
  Scenario: gerar relatorio com lista de resíduos armazenados atualmente
    Given resíduos "r1", "r2" e "r3" foram criados
    When Eu clico no botão de gerar relatorio atual
    Then Eu posso visualizar na tela os resíduos "r1", "r2" e "r3"


#GUI
  Scenario: mostrar erro na geração de relatório atual
    Given na data atual não existem residuos armazenados no sistema
    When Eu clico no botão de gerar relatorio
    Then Eu visualizo uma mensagem de erro do sistema informando que não existem residuos armazenados no momento


#GUI
  Scenario: gerar relatorio com lista de residuos existentes em determinado espaço de tempo
    Given residuos "r1", "r2", "r3" foram criados no laboratório "LAMAI"
    When Eu seleciono o laboratorio "LAMAI" e eu seleciono a opção de gerar relatorio entre datas "22/10/2016" e "20/10/2016" e Eu mando listar os "2" primeiros residuos
    Then Eu posso visualizar na tela os residuos "r1" e "r2"
#GUI
  Scenario: gerar relatorio com dias em que residuos estão armazenados
    Given residuos "r1", "r2" e "r3" foram criados em laboratorio "LAMAI"
    When Eu seleciono a opção gerar relatorio de ultimos residuos utilizados
    Then Eu posso visualizar na tela os valores "20", "19", "15", respectivamente

#GUI
  Scenario: gerar relatorios de ultimos residuos utilizados, na ordem
    Given residuos "r1", "r2", "r3" foram criados no sistema no laboratorio "LAMAI"
    And "r1" foi utilizado no dia "12/10/16"
    And "r2" foi utilizado no dia "15/12/15"
    And "r3" foi utilizado no dia "10/08/16"
    When Eu seleciono o laboratorio "LAMAI" e Eu mando listar os "3" primeiros residuos
    And Eu seleciono a opção gerar relatorio de ultimos residuos utilizados
    And Eu clico no botão de gerar relatorio
    Then Eu posso visualizar na tela os residuos "r1", "r3" e "r2", respectivamente.

#CONTROLER
  Scenario: buscar numero de residuos armazenados
    Given o sistema possui o laboratório "LAMAI" com departamento "DEPARTAMENTO_DE_ANTIBIOTICOS" e centro "CB" cadastrado
    And o residuo "composto" de peso "200" está vinculado ao laboratorio "LAMAI"
    When eu tento verificar o número de resíduos vinculados aos departamentos no sistema
    Then o sistema retorna "1"