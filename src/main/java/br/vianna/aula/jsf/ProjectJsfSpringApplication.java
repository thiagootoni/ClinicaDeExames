package br.vianna.aula.jsf;

import br.vianna.aula.jsf.model.dao.impl.UsuarioDao;
import br.vianna.aula.jsf.model.domain.usuario.EFuncao;
import br.vianna.aula.jsf.model.domain.usuario.Usuario;
import br.vianna.aula.jsf.model.domain.usuario.dto.UsuarioSessaoDto;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ProjectJsfSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJsfSpringApplication.class, args);
    }
    
    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
    }

}
