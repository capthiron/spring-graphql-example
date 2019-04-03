package de.leittersdorf.graphqlexample.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.leittersdorf.graphqlexample.model.User;
import de.leittersdorf.graphqlexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private UserRepository userRepository;

    @Autowired
    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
