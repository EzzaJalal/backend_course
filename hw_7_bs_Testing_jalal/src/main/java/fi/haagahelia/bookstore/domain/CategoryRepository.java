package fi.haagahelia.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
}

/*
 * import org.springframework.stereotype.Service;
 * import java.util.List;
 * 
 * @Service
 * public class CategoryRepository {
 * 
 * private final CategoryRepository categoryRepository;
 * 
 * public CategoryRepository(CategoryRepository categoryRepository) {
 * this.categoryRepository = categoryRepository;
 * }
 * 
 * public List<Category> findAll() {
 * return categoryRepository.findAll();
 * }
 * 
 * public void save(Category fiction) {
 * // TODO Auto-generated method stub
 * throw new UnsupportedOperationException("Unimplemented method 'save'");
 * }
 * }
 */