package jakarta.tutorial.trading.rar.api;

/* Represents the response to a trade from the EIS */
public class TradeResponse {

    private Status status;

    ;
    private int orderNumber;
    private double total;
    private double fee;
    public TradeResponse() {
    }

    public TradeResponse(String resp) {
        String[] words = resp.split(" ");
        if (words[0].compareTo("EXECUTED") == 0)
            status = Status.EXECUTED;
        else
            status = Status.FAILED;
        orderNumber = Integer.parseInt(words[1].substring(1));
        total = Double.parseDouble(words[3]);
        fee = Double.parseDouble(words[5]);
    }

    @Override public String toString() {
        return String.format("EXECUTED #%d TOTAL %.2f FEE %.2f", orderNumber, total, fee);
    }

    /* Getters and setters */
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public enum Status {EXECUTED, FAILED}
}
