package pages

import geb.Page

/**
 * Created by gvmgs on 07/11/16.
 */
class IndexResiduo extends Page{
    static url = "/ResiduosQuimicos/residuo/index"

    static at = {
        title ==~ /ResiduoList/
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }
}
