package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
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

public class TestePersistirPermissao {
    
    public TestePersistirPermissao() {
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
        Permissao obj = new Permissao();
        obj.setNome("ADMINISTRADOR");
        obj.setDescricao("Administradores do sistema");
        
        Permissao obj2 = new Permissao();
        obj2.setNome("USUARIO");
        obj2.setDescricao("Usuários do sistema");
        
        em.getTransaction().begin();
        em.persist(obj);
        em.persist(obj2);
        em.getTransaction().commit();
    }
    
}
