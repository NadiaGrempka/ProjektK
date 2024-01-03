import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {

    Cat findByName(String name);
    Cat getCatByAge(int age);
//    Cat addNewCat(Cat kitty);
//    Cat updateCat(Cat upCat);
//    Cat deleteCat(Cat delCat);
    Cat getCatById(Long id);
//    List<Cat> filterByName(String search);
//    List<Cat> filterByAge();
}
