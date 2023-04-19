package service;

import model.InventorySearchReq;
import model.InventorySearchResp;

public interface LibraryService {

    InventorySearchResp filterProductsByQuery(InventorySearchReq inventorySearchReq);

}
