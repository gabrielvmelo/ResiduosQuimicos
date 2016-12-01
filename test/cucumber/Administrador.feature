Feature: usuário administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  #CONTROLER
  Scenario: buscar numero de residuos armazenados
    Given o residuo "composto" de peso 200 e data de criaçao "10/08/2015" foi criado no sistema
    When eu tento verificar o número de resíduos vinculados aos departamentos no sistema
    Then o sistema retorna 1

  Scenario: busca a existencia de resíduo
    Given o residuo "composto" de peso 200 e data de criaçao "10/08/2015" foi criado no sistema
    And o residuo "composto2" de peso 300 e data de criaçao "15/08/2015" foi criado no sistema
    When eu verifico a existência do resíduo "composto2" no sistema
    Then o sistema retorna que ele existe

#GUI
  Scenario: gerar relatorio com lista de resíduos armazenados atualmente
    Given o resíduo "composto1" pesando 50 criado na data "20/11/2016" está cadastrado
    And o resíduo "composto2" pesando 50 criado na data "15/11/2016" está cadastrado
    And o resíduo "composto3" pesando 50 criado na data "10/11/2016" está cadastrado
    When Eu clico em gerar relatorio geral
    Then Eu posso visualizar na tela os resíduos "composto1", "composto2" e "composto3"
  #GUI
  Scenario: informar peso total de residuos e numero total de residuos
    Given o resíduo "composto1" pesando 50 criado na data "20/11/2016" está cadastrado
    And o resíduo "composto2" pesando 50 criado na data "15/11/2016" está cadastrado
    And o resíduo "composto3" pesando 50 criado na data "10/11/2016" está cadastrado
    When Eu visito a pagina principal de administrador
    Then o peso total de residuos é igual a 150 pesos
    And eu tenho 3 como total de residuos

  #GUI
  Scenario: mostrar lista de residuo a partir de certa data
    Given o resíduo "composto1" pesando 50 criado na data "20/11/2016" está cadastrado
    And o resíduo "composto2" pesando 50 criado na data "15/11/2016" está cadastrado
    And o resíduo "composto3" pesando 50 criado na data "10/11/2016" está cadastrado
    When Eu coloco a data "17/11/2016" e clico para gerar relatorio a partir desta data
    Then Eu visualizo o residuo "composto1" na tela