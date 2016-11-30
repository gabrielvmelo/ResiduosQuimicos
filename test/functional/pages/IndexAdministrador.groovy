package pages

import geb.Page

import java.text.DateFormatSymbols

/**
 * Created by gvmgs on 07/11/16.
 */
class IndexAdministrador extends Page {

    static url = "/ResiduosQuimicos/administrador/resumoSistema"

    static at = {
        title ==~ /Resumo Sistema/
    }

    def gerarRelatorio(data) {
        data = data.split("/")
        def dia = data[0]
        def mes = data[1]
        def ano = data[2]
        $("form").date_day = dia
        // TODO internacionalizar
        String mesString = new DateFormatSymbols(Locale.US).getMonths()[Integer.parseInt(mes)-1]
        $("form").date_month = mesString
        $("form").date_year = ano
        $("input", name: "create").click()
    }



    boolean checkPeso(peso){
        $("p", name: "peso").has(text: peso)
    }

    boolean checkNum(num){
        $("p", name: "num").has(text: num)
    }

}
