import exception.GroupByNotFound;
import model.Inventory;
import model.InventorySearchFilter;
import model.InventorySearchReq;
import repo.InventoryDao;
import repo.InventoryDaoImpl;
import service.LibraryService;
import service.LibraryServiceImpl;

import java.util.List;

public class main {

    public static void main(String[] args) {
        try {
            List<Inventory> inventories = createProducts();

            InventoryDao inventoryDaoImpl = new InventoryDaoImpl(inventories);

            LibraryService libraryService = new LibraryServiceImpl(inventoryDaoImpl);

            InventorySearchReq inventorySearchReq = createSearchRequest();

            System.out.println(libraryService.filterProductsByQuery(inventorySearchReq));
        }
        catch (GroupByNotFound e) {
            System.out.println("group by implementation not found exception");
        }

    }

    public static List<Inventory> createProducts() {
        return List.of(new Inventory("id1", "book", "eduaction", 100, 10),
                new Inventory("id2", "book", "crime", 110, 12),
                new Inventory("id3", "magazine", "crime", 120, 12));
    }

    public static InventorySearchReq createSearchRequest() {
        return new InventorySearchReq(InventorySearchFilter
                .Builder
                .newInstance()
                .setCatagory("book")
                .setPrice(120)
                .build(),
                true,
                "subCatagory");
    }

}
