package pl.java.sklep.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i where i.itemCode = ?1")
    Optional<Item> findItemByItemCode(String itemcode);

    List<Item> findByName(String name);
}
