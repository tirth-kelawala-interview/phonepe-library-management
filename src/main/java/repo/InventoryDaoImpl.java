package repo;

import exception.GroupByNotFound;
import model.Inventory;
import model.InventorySearchFilter;
import model.InventorySearchReq;
import model.InventorySearchResp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InventoryDaoImpl implements InventoryDao {

    public static final String SUB_CATAGORY = "subCatagory";
    private List<Inventory> inventoryList;

    private final Map<String, Function<List<Inventory>,Map<String, Long>>> groupbyMapper;

    public InventoryDaoImpl(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
        groupbyMapper = new HashMap<>();
        groupbyMapper.put(SUB_CATAGORY,(this::groupBySubCatagory));
    }

    public InventorySearchResp filterAndGroupBy(InventorySearchReq inventorySearchReq) throws GroupByNotFound {
        List<Inventory> filteredProducts = filterProducts(inventorySearchReq.getFilter());
        Map<String, Long> groupedResult;
        if (inventorySearchReq.getGroupBy() == null || inventorySearchReq.getGroupBy().equals("")) {
            return InventorySearchResp.
                    Builder
                    .newInstance()
                    .setTotalCount(filteredProducts.size())
                    .build();
        }

        if (groupbyMapper.containsKey(inventorySearchReq.getGroupBy())) {
            groupedResult = groupbyMapper.get(inventorySearchReq.getGroupBy()).apply(filteredProducts);
            return InventorySearchResp.
                    Builder
                    .newInstance()
                    .setTotalCount(filteredProducts.size())
                    .setsubCatagories(groupedResult)
                    .build();
        } else {
            throw new GroupByNotFound("group by param not found");
        }

    }

    public InventorySearchResp filterOrAndGroupBy(InventorySearchReq inventorySearchReq) throws GroupByNotFound {
        List<Inventory> filteredProducts = filterProductsWithOr(inventorySearchReq.getFilter());
        Map<String, Long> groupedResult;
        if (inventorySearchReq.getGroupBy() == null || inventorySearchReq.getGroupBy().equals("")) {
            return InventorySearchResp.
                    Builder
                    .newInstance()
                    .setTotalCount(filteredProducts.size())
                    .build();
        }

        if (groupbyMapper.containsKey(inventorySearchReq.getGroupBy())) {
            groupedResult = groupbyMapper.get(inventorySearchReq.getGroupBy()).apply(filteredProducts);
            return InventorySearchResp.
                    Builder
                    .newInstance()
                    .setTotalCount(filteredProducts.size())
                    .setsubCatagories(groupedResult)
                    .build();
        } else {
            throw new GroupByNotFound("group by param not found");
        }

    }

    public List<Inventory> filterProductsWithOr(InventorySearchFilter inventorySearchFilter) {
        if (inventorySearchFilter==null) {
            return inventoryList;
        }
        return inventoryList.stream()
                .filter(inventory -> {
                    if (inventorySearchFilter.getCatagory()!=null && inventorySearchFilter.getPrice()!=null) {
                        return Objects.equals(inventory.getCatagory(),inventorySearchFilter.getCatagory()) || inventory.getPrice() == inventorySearchFilter.getPrice();
                    }
                    else if (inventorySearchFilter.getCatagory()!=null) {
                        return Objects.equals(inventory.getCatagory(),inventorySearchFilter.getCatagory());
                    }
                    else if (inventorySearchFilter.getPrice()!=null) {
                        return inventory.getPrice() == inventorySearchFilter.getPrice();
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    public List<Inventory> filterProducts(InventorySearchFilter inventorySearchFilter) {
        if (inventorySearchFilter==null) {
            return inventoryList;
        }
        return inventoryList.stream()
                .filter(inventory -> {
                    if (inventorySearchFilter.getCatagory()!=null) {
                        return Objects.equals(inventory.getCatagory(),inventorySearchFilter.getCatagory());
                    }
                    return true;
                })
                .filter(inventory -> {
                    if (inventorySearchFilter.getPrice()!=null) {
                        return inventory.getPrice() == inventorySearchFilter.getPrice();
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }


    public Map<String, Long> groupBySubCatagory(List<Inventory> inventories) {
        return inventories.stream()
                .collect(Collectors
                        .groupingBy(Inventory::getSubCatagory,Collectors.counting()));
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
