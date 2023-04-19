package repo;

import exception.GroupByNotFound;
import model.Inventory;
import model.InventorySearchFilter;
import model.InventorySearchReq;
import model.InventorySearchResp;

import java.util.List;
import java.util.Map;

public interface InventoryDao {

    InventorySearchResp filterAndGroupBy(InventorySearchReq inventorySearchReq) throws GroupByNotFound;

    InventorySearchResp filterOrAndGroupBy(InventorySearchReq inventorySearchReq) throws GroupByNotFound;

    // Two filters in one method could have been broken into two separate methods and then aggregate them based on or/and conditions
    // Due to time restrictions could not implement
    List<Inventory> filterProducts(InventorySearchFilter inventorySearchFilter);

    Map<String, Long> groupBySubCatagory(List<Inventory> inventories);

}
