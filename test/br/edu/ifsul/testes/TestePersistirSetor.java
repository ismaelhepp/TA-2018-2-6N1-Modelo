package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Setor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirSetor {
    
    public TestePersistirSetor() {
    }
    
    EntityManagerFactory emf;
    EntityManager em;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2018-2-6N1-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste() {
        Setor obj1 = new Setor();
        obj1.setNome("Docentes");
        
        Setor obj2 = new Setor();
        obj2.setNome("Administrativo");
        
        em.getTransaction().begin();
        em.persist(obj1);
        em.persist(obj2);
        em.getTransaction().commit();
        
    }
    
}
