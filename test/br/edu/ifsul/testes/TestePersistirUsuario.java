package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Setor;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirUsuario {
    
    public TestePersistirUsuario() {
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
        Usuario obj = new Usuario();
        obj.setEmail("teste@teste.com");
        obj.setNascimento(Calendar.getInstance());
        obj.setNome("Ismael Felipe Hepp");
        obj.setNomeUsuario("ismael");
        obj.setSenha("123456");
        obj.setSetor(em.find(Setor.class, 1));
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
    
}
