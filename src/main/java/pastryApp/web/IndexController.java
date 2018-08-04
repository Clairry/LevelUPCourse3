package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class IndexController {
    @Autowired
    private IndexBean bean;

    @GetMapping("/")
    public String index(ModelMap model) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("indexBean", bean);
        if (user instanceof User) {
            String name = ((User) user).getUsername();
            Boolean isAdmin = ((User)user).getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
            model.addAttribute("userName", name);
            model.addAttribute("isAdmin", isAdmin);
        }
        else {
             model.addAttribute("userName", null);
            }
        return "index";
    }
}
