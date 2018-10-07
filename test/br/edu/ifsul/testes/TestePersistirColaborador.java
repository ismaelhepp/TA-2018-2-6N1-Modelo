package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Colaborador;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirColaborador {
    
    public TestePersistirColaborador() {
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
        Colaborador obj1 = new Colaborador();
        obj1.setCargaHoraria(10);
        obj1.setGestor(Boolean.FALSE);
        
        em.getTransaction().begin();
        obj1.setUsuario(em.find(Usuario.class, "ismael"));
        em.persist(obj1);
        em.getTransaction().commit();
    }
    
}
