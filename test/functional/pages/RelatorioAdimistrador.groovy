package pages

import geb.Page

/**
 * Created by gvmgs on 07/11/16.
 */
class RelatorioAdimistrador extends Page{
    static url = "/ResiduosQuimicos/adm/relatorio"

    static at = {
        title ==~ /RelatorioAdm/
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

}
