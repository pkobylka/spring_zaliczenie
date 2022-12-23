package pl.java.sklep.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping("/itemList")
    public String itemList(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "index";
    }

    @RequestMapping("/newitem")
    public String newItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "newItem";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.addNewItem(item);

        return "redirect:/itemList";
    }

    @RequestMapping("/editItem/{id}")
    public ModelAndView showEditItem(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editItem");
        Item item = itemService.findById(id);
        mav.addObject("item", item);

        return mav;
    }

    @RequestMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(name = "id") int id) {
        itemService.deleteItem(id);
        return "redirect:/itemList";
    }

    @RequestMapping("/search")
    public String searchItem(Model model, @RequestParam("searchParam") String param) {
        List<Item> items = itemService.findByName(param);
        model.addAttribute("items", items);
        return "index";
    }
}
