package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.CakePartsDAO;
import pastryApp.model.CakePart;

import javax.servlet.http.HttpSession;

@Controller
public class AddCakePartController {
    @Autowired
    private CakePartsDAO cakePartsDAO;

    @Autowired
    private AddCakePartBean bean;

    @GetMapping(path = "/add-cake-part")
    public String addCakePartPage(HttpSession session, ModelMap model) {
        model.addAttribute("addCakePartBean", bean);

        return "addCakePart";
    }

    @RequestMapping(path = "/add-cake-part", method = RequestMethod.POST)
    public String postAddCakePart(@RequestParam String name,
                                  ModelMap model) {
        CakePart cakePart;
        try {
            cakePartsDAO.CreateCakePart(name);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
        model.addAttribute("addCakePartBean", bean);

        return "addCakePart";
    }
}
