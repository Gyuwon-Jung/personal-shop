package com.gyuwon.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final BoardRepository boardRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("items", result);
        model.addAttribute("boards", boards);
        return "list.html";
    }

    @GetMapping("/write")
    String write(Model model) {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, @RequestParam Integer price) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable int id, Model model) {
        Optional<Item> result = itemRepository.findById(Long.valueOf(id));
        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }

    }

    @PostMapping("/edit/{id}")
    String modifyPost(@PathVariable int id, @RequestParam String title, @RequestParam Integer price) {
        Optional<Item> result = itemRepository.findById(Long.valueOf(id));
        if (result.isPresent()) {
            Item item = result.get();
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }
        return "redirect:/list";
    }
}

//    @GetMapping("/detail/{id}")
//    ResponseEntity<String> detail(@PathVariable int id, Model model){
//        Optional<Item> result = itemRepository.findById(Long.valueOf(id));
//        if( result.isPresent()) {
//            model.addAttribute("item", result.get());
//            return ResponseEntity.status(200).body("detail.html");
//        }
//        else{
//            return "redirect:/list";
//        }
//
//    }
