package pages

import geb.Page

/**
 * Created by gvmgs on 07/11/16.
 */
class ShowResiduo extends Page{

    static url = "/ResiduosQuimicos/residuos/show/"

    static at = {
        title ==~ /ShowResiduo/
    }

}
