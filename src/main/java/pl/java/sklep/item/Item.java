package pl.java.sklep.item;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tbl_items")
public class Item {
    @Id
    @SequenceGenerator(name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "item_sequence")
    private int id;
    private String name;
    private int price;
    private LocalDate doa;
    private String itemCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDoa() {
        return doa;
    }

    public void setDoa(LocalDate doa) {
        this.doa = doa;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", doa=" + doa +
//                ", itemCode='" + itemCode + '\'' +
//                '}';
//    }

    public Item() {
    }

    public Item(String name, int price, LocalDate doa, String itemCode) {
        this.name = name;
        this.price = price;
        this.doa = doa;
        this.itemCode = itemCode;
    }

//    public Item(int id, String name, int price, LocalDate doa, String itemCode) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.doa = doa;
//        this.itemCode = itemCode;
//    }
}
