package br.com.fiap.linguagens.repository;

import br.com.fiap.linguagens.domain.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
}
