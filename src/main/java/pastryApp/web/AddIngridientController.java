package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.IngridientsDAO;

import javax.servlet.http.HttpSession;

@Controller
public class AddIngridientController {
    @Autowired
    private IngridientsDAO ingridientsDAO;

    @Autowired
    private AddIngridientBean bean;

    @GetMapping(path = "/add-ingridient")
    public String addIngridientPage(HttpSession session, ModelMap model) {
        model.addAttribute("addIngridientBean", bean);

        return "addIngridient";
    }

    @RequestMapping(path = "/add-ingridient", method = RequestMethod.POST)
    public String postAddIngridient(@RequestParam String name,
                                    ModelMap model) {
        try {
            ingridientsDAO.createIngridient(name);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
        model.addAttribute("addIngridientBean", bean);

        return "addIngridient";
    }
}
