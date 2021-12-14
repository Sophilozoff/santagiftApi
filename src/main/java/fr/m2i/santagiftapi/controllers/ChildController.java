package fr.m2i.santagiftapi.controllers;

import fr.m2i.santagiftapi.models.Child;
import fr.m2i.santagiftapi.services.serviceImpl.ChildServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/children")
public class ChildController {

    @Resource(name="childService")
    private final ChildServiceImpl childService;

    @GetMapping("")
    public List<Child> getChildren(){
       return childService.findAll();
    }

    @GetMapping("/{id}")
    public Child getChild(@PathVariable Long id){
        return childService.findById(id);
    }

    @PostMapping("/save")
    public Child save(@RequestBody Child child){
        return childService.save(child);
    }

    @PutMapping("/update")
    public Child update(@RequestBody Child child){
        return childService.update(child);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        childService.delete(id);
    }

}
