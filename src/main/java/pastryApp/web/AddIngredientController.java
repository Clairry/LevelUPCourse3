package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.IngredientsDAO;

import javax.servlet.http.HttpSession;

@Controller
public class AddIngredientController {
    @Autowired
    private IngredientsDAO ingredientsDAO;

    @Autowired
    private AddIngredientBean bean;

    @GetMapping(path = "/add-ingredient")
    public String addIngredientPage(HttpSession session, ModelMap model) {
        model.addAttribute("addIngredientBean", bean);

        return "addIngredient";
    }

    @RequestMapping(path = "/add-ingredient", method = RequestMethod.POST)
    public String postAddIngredient(@RequestParam String name,
                                    ModelMap model) {
        try {
            ingredientsDAO.createIngredient(name);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
        model.addAttribute("addIngredientBean", bean);

        return "addIngredient";
    }
}
