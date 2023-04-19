package service;

import exception.GroupByNotFound;
import model.InventorySearchReq;
import model.InventorySearchResp;
import repo.InventoryDao;
import repo.InventoryDaoImpl;

public class LibraryServiceImpl implements LibraryService {

    private InventoryDao inventoryDaoImpl;

    public LibraryServiceImpl(InventoryDao inventoryDaoImpl) {
        this.inventoryDaoImpl = inventoryDaoImpl;
    }

    public InventorySearchResp filterProductsByQuery(InventorySearchReq inventorySearchReq) throws GroupByNotFound {

        if (inventorySearchReq.isOrFilter()) {
            return inventoryDaoImpl.filterOrAndGroupBy(inventorySearchReq);
        }
        return inventoryDaoImpl.filterAndGroupBy(inventorySearchReq);
    }

}
