package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.FormsDAO;

import javax.servlet.http.HttpSession;

@Controller
public class AddFormController {
    @Autowired
    private FormsDAO formsDAO;

    @Autowired
    private AddFormBean bean;

    @GetMapping(path = "/add-form")
    public String addFormPage(HttpSession session, ModelMap model) {
        model.addAttribute("addFormBean", bean);

        return "addForm";
    }

    @RequestMapping(path = "/add-form", method = RequestMethod.POST)
    public String postAddForm(@RequestParam String name,
                               @RequestParam Float coeff,
                               @RequestParam Float price,
                               ModelMap model) {
        try {
           formsDAO.createForm(name, coeff, price);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
        model.addAttribute("addFormBean", bean);

        return "addForm";
    }
}
