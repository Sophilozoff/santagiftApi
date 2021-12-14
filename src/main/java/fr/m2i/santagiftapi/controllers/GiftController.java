package fr.m2i.santagiftapi.controllers;

import fr.m2i.santagiftapi.models.Gift;
import fr.m2i.santagiftapi.services.serviceImpl.GiftServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gifts")
public class GiftController {

    @Resource(name="giftService")
    private final GiftServiceImpl giftService;

    @GetMapping("")
    public List<Gift> getGifts(){
        return giftService.findAll();
    }

    @GetMapping("/{id}")
    public Gift getGift(@PathVariable Long id){
        return giftService.findById(id);
    }

    @PostMapping("/save")
    public Gift save(@RequestBody Gift gift){
        return giftService.save(gift);
    }

    @PutMapping("/update")
    public Gift update(@RequestBody Gift gift){
        return giftService.update(gift);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        giftService.delete(id);
    }

}
