package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pastryApp.DAO.CartItemsDAO;
import pastryApp.DAO.OrderDetailsDAO;
import pastryApp.DAO.OrderInfosDAO;
import pastryApp.model.CartItem;
import pastryApp.model.OrderDetail;
import pastryApp.model.OrderInfo;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class AddOrderController {
    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private  OrderInfosDAO orderInfosDAO;

    @Autowired
    private CartItemsDAO cartItemsDAO;

    @Autowired
    private AddOrderBean bean;

    @GetMapping(path = "/add-order")
    public String addOrderPage(HttpSession session, ModelMap model) {
        model.addAttribute("addOrderBean", bean);

        return "addOrder";
    }

    @RequestMapping(path = "/add-order", method = RequestMethod.POST)
    public String postAddCartItem(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date,
                                  @RequestParam String telephone,
                                  HttpSession session,
                                  ModelMap model) {

        String userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        //String userName = (String) session.getAttribute("userName");

        try {
            OrderInfo orderInfo = orderInfosDAO.createOrderInfo(userName, date, telephone);
            List<CartItem> cartItems = cartItemsDAO.findCartItemsForUser(userName);

            for (CartItem cartItem : cartItems) {
               orderDetailsDAO.createOrderDetail(cartItem.getAmount(), orderInfo, cartItem.getCake(), cartItem.getForm(), cartItem.getPrice());
            }
            cartItemsDAO.deleteCartItemForUser(userName);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "error";
        }

        model.addAttribute("addOrderBean", bean);

        return "addOrder";
    }
}
