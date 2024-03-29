package com.kotki.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MyRestService {

    private final CatRepository catRepository;
    private Logger logger = Logger.getLogger("My Rest Service");
    @Autowired
    public MyRestService(CatRepository catRepository) {
        logger.info("Cat Repository");
        this.catRepository = catRepository;
        this.catRepository.save(new Cat("Kaja", 12));
        this.catRepository.save(new Cat("Bubu", 9));
        this.catRepository.save(new Cat("Todd", 4));
        this.catRepository.save(new Cat("Pan Wąsek", 2));
        this.catRepository.save(new Cat("Puszka", 5));
        this.catRepository.save(new Cat("Kot", 3));
        this.catRepository.save(new Cat("Dafodil", 3));
        this.catRepository.save(new Cat("Róża", 10));
    }

    public Cat getCatByName(String name) {
        return this.catRepository.findByName(name);
    }

    public Cat getCatByAge(int age){
        return this.catRepository.getCatByAge(age);
    }
    public Cat getCatId(Long id){
        return this.catRepository.getCatById(id);
    }
    public Cat addNewCat(Cat kitty) {
        System.out.println("Kot został zapisany");
        return this.catRepository.save(kitty);
    }
    public Cat updateCat(Cat upCat){
        return this.catRepository.save(upCat);
    }
    public void deleteCat(Cat delCat){ this.catRepository.delete(delCat);}
    public List<Cat> getAllCats(){
        logger.info("getAllCats");
        return (List<Cat>) this.catRepository.findAll();
    }
    public List<Cat> filterByName(String search){
        return getAllCats().stream().filter(cat -> cat.getName().contains(search)).toList();
    }

    public void deleteById(Long delById) {
        this.catRepository.deleteById(delById);
    }
}
