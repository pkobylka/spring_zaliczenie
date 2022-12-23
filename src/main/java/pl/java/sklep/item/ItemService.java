package pl.java.sklep.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service Layer
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    public void addNewItem(Item item) {
//        Optional<Item> isAlrdyItem = itemRepository.findItemByItemCode(item.getItemCode());
//        if (isAlrdyItem.isPresent()) {
//            throw new IllegalStateException("Product alrdy in db");
//        }
//        itemRepository.save(item);
//    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(int itemId) {
        boolean doExist = itemRepository.existsById(itemId);
        if (!doExist) {
            throw new IllegalStateException("Item with that ID isnt in DB");
        }
        itemRepository.deleteById(itemId);
    }

    public void addNewItem(Item item) {
        itemRepository.save(item);
    }

    public Item findById(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }

//    @Transactional
//    public void updateItemPrice(int itemId, int price)
//    {
//        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item with that ID do not exist"));
//
//        if(!Objects.equals(item.getPrice(), price))
//        {
//            item.setPrice(price);
//        }
//    }

    // OD TEGO MIEJSCA TRZEBA BĘDZIE SPRAWDZIĆ
    public List<Item> listAll()
    {return itemRepository.findAll();}
}
