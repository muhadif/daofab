package id.muhadif.daofab.entity;

/**
 * @Author muhadif
 * @create 12/06/21 23.18
 */
public class DetailPayment {
    private int id;
    private String sender;
    private String receiver;
    private int totalAmount;
    private int paidAmount;

    public DetailPayment(int id, String sender, String receiver, int totalAmount, int paidAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
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

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
}
