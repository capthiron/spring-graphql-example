package de.leittersdorf.graphqlexample.repository;

import de.leittersdorf.graphqlexample.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository<Repo, Long> {
}
