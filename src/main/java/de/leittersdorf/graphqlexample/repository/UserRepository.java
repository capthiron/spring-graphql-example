package de.leittersdorf.graphqlexample.repository;

import de.leittersdorf.graphqlexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
