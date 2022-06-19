package ua.vlad.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vlad.models.Ingredients;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients, Integer> {


}
