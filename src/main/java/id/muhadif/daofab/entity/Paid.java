package id.muhadif.daofab.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author muhadif
 * @create 12/06/21 22.40
 */
public class Paid {
    private int id;
    private int parentId;
    private int paidAmount;

    @JsonCreator
    public Paid(
            @JsonProperty("id")
                    int id,
            @JsonProperty("parentId")
                    int parentId,
            @JsonProperty("paidAmount")
                    int paidAmount) {
        this.id = id;
        this.parentId = parentId;
        this.paidAmount = paidAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
}
