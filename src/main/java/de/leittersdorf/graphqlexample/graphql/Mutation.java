package de.leittersdorf.graphqlexample.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.leittersdorf.graphqlexample.dto.NewUser;
import de.leittersdorf.graphqlexample.model.User;
import de.leittersdorf.graphqlexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private UserRepository userRepository;

    @Autowired
    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(NewUser newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setLogin(newUser.getLogin());
        return userRepository.save(user);
    }
}
