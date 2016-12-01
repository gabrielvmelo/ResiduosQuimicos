package pages

import geb.Page
import residuosquimicos.Laboratorio
import steps.InternationalizationHelper

import java.text.DateFormatSymbols

class CreateResiduoPage extends Page{
    static url = "/ResiduosQuimicos/residuo/create/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String residuoLab = "Residuo" //code.label
        String createResiduoTitleList = helper.getMessage("default.create.label", residuoLab)
        title ==~ createResiduoTitleList
    }

    def createResiduo(residuo, peso, data) {
        data = data.split("/")
        def dia = data[0]
        def mes = data[1]
        def ano = data[2]
        $("form").nome = residuo
        $("form").descricao = residuo
        $("form").peso = peso
        $("form").dataCadastro_day = dia
        // TODO internacionalizar
        String mesString = new DateFormatSymbols(Locale.US).getMonths()[Integer.parseInt(mes)-1]
        $("form").dataCadastro_month = mesString
        $("form").dataCadastro_year = ano
        $("input", name: "create").click()
    }
}

