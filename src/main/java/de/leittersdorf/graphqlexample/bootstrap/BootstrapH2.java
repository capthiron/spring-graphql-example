package de.leittersdorf.graphqlexample.bootstrap;

import de.leittersdorf.graphqlexample.model.Repo;
import de.leittersdorf.graphqlexample.model.User;
import de.leittersdorf.graphqlexample.repository.RepoRepository;
import de.leittersdorf.graphqlexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("dev")
public class BootstrapH2 implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RepoRepository repoRepository;

    @Autowired
    public BootstrapH2(UserRepository userRepository, RepoRepository repoRepository) {
        this.userRepository = userRepository;
        this.repoRepository = repoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User lasse = new User();
        lasse.setName("Lasse");
        lasse.setLogin("Elsterny");

        User dario = new User();
        dario.setName("Dario");
        dario.setLogin("Capthiron");

        lasse = userRepository.save(lasse);
        dario = userRepository.save(dario);

        Repo lasseRepo = new Repo();
        lasseRepo.setName("LasseRepo");
        lasseRepo.setUrl("lasse.url");
        lasseRepo.setUser(lasse);

        Repo darioRepo = new Repo();
        darioRepo.setName("DarioRepo");
        darioRepo.setUrl("dario.url");
        darioRepo.setUser(dario);

        repoRepository.save(lasseRepo);
        repoRepository.save(darioRepo);
    }
}
