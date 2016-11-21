package pages

import geb.Page
import steps.InternationalizationHelper

/**
 * Created by gvmgs on 07/11/16.
 */
class ShowResiduo extends Page{

    static url = "/ResiduosQuimicos/residuos/show/"

    static at = {InternationalizationHelper helper = InternationalizationHelper.instance
        String labelResiduo = "Residuo" //code.label
        String showResiduoTitleList = helper.getMessage("default.show.label", labelResiduo)
        title ==~ showResiduoTitleList
    }

}
