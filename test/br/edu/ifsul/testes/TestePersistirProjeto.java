package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Colaborador;
import br.edu.ifsul.modelo.Projeto;
import br.edu.ifsul.modelo.Setor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirProjeto {
    
    public TestePersistirProjeto() {
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
        Projeto obj1 = new Projeto();
        obj1.setNome("Projeto 01");
        obj1.setAtivo(Boolean.TRUE);
        obj1.setDescricao("Projeto 01");
        obj1.setInicio(Calendar.getInstance());
        
        em.getTransaction().begin();
        obj1.setSetor(em.find(Setor.class, 1));
        obj1.getColaboradores().add(em.find(Colaborador.class, 1));
        em.persist(obj1);
        em.getTransaction().commit();
    }
    
}
