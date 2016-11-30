package pages

import geb.Page

/**
 * Created by gvmgs on 07/11/16.
 */
class RelatorioAdmistrador extends Page{
    static url = "/ResiduosQuimicos/administrador/relatorioAdministrador"

    static at = {
        title ==~ /Resumo Sistema/
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

}
