package model;

import java.util.List;
import java.util.Map;

public class InventorySearchResp {

    private long totalCount;
    private Map<String,Long> subCatagories;

    public InventorySearchResp(Builder builder) {
        this.totalCount = builder.totalCount;
        this.subCatagories = builder.subCatagories;
    }

    public static class Builder {
        private long totalCount;
        private Map<String,Long> subCatagories;

        public static Builder newInstance()
        {
            return new Builder();
        }

        public Builder() {}

        public Builder setTotalCount(long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder setsubCatagories(Map<String,Long> subCatagories) {
            this.subCatagories = subCatagories;
            return this;
        }

        public InventorySearchResp build()
        {
            return new InventorySearchResp(this);
        }

    }

    public long getTotalCount() {
        return totalCount;
    }

    public Map<String,Long> getSubCatagories() {
        return subCatagories;
    }

    @Override
    public String toString() {
        return "InventorySearchResp{" +
                "totalCount=" + totalCount +
                ", subCatagories=" + subCatagories +
                '}';
    }
}
