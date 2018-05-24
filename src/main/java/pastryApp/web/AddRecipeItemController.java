package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.RecipeItemsDAO;
import pastryApp.model.RecipeItem;

import javax.servlet.http.HttpSession;

@Controller
public class AddRecipeItemController {
    @Autowired
    private RecipeItemsDAO recipeItemsDAO;

    @Autowired
    private AddRecipeItemBean bean;

    @GetMapping(path = "/add-recipe-item")
    public String addRecipeItemPage(HttpSession session, ModelMap model) {
        model.addAttribute("addRecipeItemBean", bean);

        return "addRecipeItem";
    }

    @RequestMapping (path = "/add-recipe-item", method = RequestMethod.POST)
    public String postAddRecipeItem(@RequestParam("cake") int cakeId,
                                    @RequestParam("cakePart") int cakePartId,
                                    @RequestParam("ingridient") int ingridientId,
                                    @RequestParam float amount,
                                    ModelMap model) {
        try {
            recipeItemsDAO.createRecipeItem(cakeId, cakePartId, ingridientId, amount);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }
        model.addAttribute("addRecipeItemBean", bean);

        return "addRecipeItem";
    }
}
