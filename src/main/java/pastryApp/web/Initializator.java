package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pastryApp.DAO.CakesDAO;

@Component
public class Initializator {
    @Autowired
    private CakesDAO cakesDAO;

    @EventListener
    public void onAppStart(ContextRefreshedEvent event) {
        cakesDAO.createInitialData();
    }
}
