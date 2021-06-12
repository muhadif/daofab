package id.muhadif.daofab.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author muhadif
 * @create 12/06/21 20.44
 */
public class Payment {
    private int id;
    private String sender;
    private String receiver;
    private int totalAmount;
    private int totalPaidAmount;

    @JsonCreator
    public Payment(
            @JsonProperty("id")
            int id,
            @JsonProperty("sender")
            String sender,
            @JsonProperty("receiver")
            String receiver,
            @JsonProperty("totalAmount")
            int totalAmount
    ) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(int totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }
}
