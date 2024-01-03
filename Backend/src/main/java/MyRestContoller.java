import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestContoller {

    private final MyRestService myRestService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @Autowired
    public MyRestContoller(MyRestService myRestService) {
        this.myRestService = myRestService;
    }

    @GetMapping("cat/{name}")
    public Cat findName(@PathVariable("name") String name){
        return this.myRestService.getCatByName(name);
    }

    @GetMapping("cat/{age}")
    public Cat findAge(@PathVariable("age") int age){
        return this.myRestService.getCatByAge(age);
    }

    @GetMapping("cat/id/{id}")
    public Cat findId(@PathVariable("id") Long id){
        return this.myRestService.getCatId(id);
    }

    @GetMapping("cat/filterByName")
    public List<Cat> filterByName(@PathVariable("filterByName") String search){
        return this.myRestService.filterByName(search);
    }

    //trzeba miec jeszcze post - tworzy nowe, put - update'uje, get(to juz jest), delete

    @PostMapping("cat/add") //if it does not exist - create, if exist do nothing
    public Cat addNewCat(@RequestBody Cat kitty){
        if (myRestService.getCatByName(kitty.getName())!=null){
            System.out.println("kotek z takim imieniem już istnieje");
        }else {
            myRestService.addNewCat(kitty);
        }
        return kitty;
    }

    @PutMapping("cat/update") //if exist - update, if it does not exist, do nothing
    public Cat updateCat(@RequestBody Cat upCat){
        if (myRestService.getCatId(upCat.getId())!=null){
            myRestService.updateCat(upCat);
        }
        return upCat;
    }

    @DeleteMapping("cat/delete/{name}") // delete if exist
    public Cat deleteCat(@PathVariable("name") Cat cat){
        if (myRestService.getCatByName(cat.getName()).equals(cat)){
            myRestService.deleteCat(cat);
        }
        System.out.println("Kot usunięty");
        return cat;
    }
}
