package com.kotki.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    Cat findByName(String name);
    Cat getCatByAge(int age);
//    com.kotki.backend.Cat addNewCat(com.kotki.backend.Cat kitty);
//    com.kotki.backend.Cat updateCat(com.kotki.backend.Cat upCat);
//    com.kotki.backend.Cat deleteCat(com.kotki.backend.Cat delCat);
    Cat getCatById(Long id);
//    List<com.kotki.backend.Cat> findAll();
//    List<com.kotki.backend.Cat> filterByName(String search);
//    List<com.kotki.backend.Cat> filterByAge();
}
