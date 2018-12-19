package guru.leco.graphql.services.contracts;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    List<T> get();

    Optional<T> getById(ID id);

    T save(T object);

    void deleteById(ID id);
}
