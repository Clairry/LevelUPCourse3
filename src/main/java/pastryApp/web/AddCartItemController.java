package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.CartItemsDAO;
import pastryApp.model.CartItem;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddCartItemController {
    @Autowired
    private CartItemsDAO cartItemsDAO;

    @Autowired
    private AddCartItemBean bean;

    @GetMapping(path = "/add-items-to-cart")
    public String addCartItemPage(HttpSession session, ModelMap model) {
        model.addAttribute("addCartItemBean", bean);

        return "addCartItem";
    }

    @RequestMapping(path = "/add-items-to-cart", method = RequestMethod.POST)
    public String postAddCartItem(@RequestParam("cake") int cakeId,
                                  @RequestParam("form") int formId,
                                  @RequestParam int amount,
                                  HttpSession session,
                                  ModelMap model) {

        String userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        //String userName = (String) session.getAttribute("userName");

        try {
            if (cartItemsDAO.findCartItemsForUserCakeForm(userName, cakeId, formId).isEmpty()) {
                cartItemsDAO.createCartItem(userName, cakeId, formId, amount);
            }
            else {
                CartItem cartItem = cartItemsDAO.findCartItemsForUserCakeForm(userName, cakeId, formId).get(0);
                cartItem.setAmount(cartItem.getAmount() + amount);
                cartItem.setPrice(cartItem.getPrice() + cartItem.getForm().getPrice()*cartItem.getAmount());
                cartItemsDAO.updateCartItem(cartItem);
            }
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }

        model.addAttribute("addCartItemBean", bean);

        return "addCartItem";
    }

    private static boolean ensureLoggedIn(HttpSession session) {
        if (session.getAttribute("userName") == null) {
            return true;
        }
        return false;
    }

}
