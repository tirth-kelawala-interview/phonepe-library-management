package model;

public class InventorySearchReq {

    private InventorySearchFilter filter;

    private boolean isOrFilter;

    private String groupBy;

    public InventorySearchReq(InventorySearchFilter filter, String groupBy) {
        this.filter = filter;
        this.groupBy = groupBy;
    }

    public InventorySearchReq(InventorySearchFilter filter, boolean isOrFilter, String groupBy) {
        this.filter = filter;
        this.groupBy = groupBy;
        this.isOrFilter = isOrFilter;
    }

    public InventorySearchReq(InventorySearchFilter filter, boolean isOrFilter) {
        this.filter = filter;
        this.isOrFilter = isOrFilter;
    }

    public InventorySearchReq(InventorySearchFilter filter) {
        this.filter = filter;
    }

    public InventorySearchFilter getFilter() {
        return filter;
    }

    public void setFilter(InventorySearchFilter filter) {
        this.filter = filter;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isOrFilter() {
        return isOrFilter;
    }

    public void setOrFilter(boolean orFilter) {
        isOrFilter = orFilter;
    }
}
