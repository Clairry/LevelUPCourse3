package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class RecipeTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setup(){
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
    }

    @After
    public void end() {
        em.close();
        emf.close();
    }

    @Test
    public void testCreateRecipe() throws Throwable {
        Cake cake = new Cake("MangoCoconut");
        CakePart cakePart = new CakePart("Buscuit");
        Ingridient ingridient = new Ingridient("Flour");
        Recipe recipe = new Recipe(cake, cakePart, ingridient, 100);

        em.getTransaction().begin();

        try {
            em.persist(recipe);
        } catch(Throwable t){
            em.getTransaction().rollback();
            throw t;
        } finally{
            em.getTransaction().commit();
        }

        Recipe found = em.find(Recipe.class, recipe.getId());
        assertNotNull(found);
        assertNotNull(found.getCakePart());
        assertNotNull(found.getCake());
        assertNotNull(found.getIngridient());
    }
}
