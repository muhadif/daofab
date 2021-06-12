package id.muhadif.daofab.entity.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import id.muhadif.daofab.entity.Payment;

import java.util.List;

/**
 * @Author muhadif
 * @create 12/06/21 21.40
 */

public class DataPayment {

    List<Payment> data;

    @JsonCreator
    public DataPayment(
            @JsonProperty("data")
            List<Payment> data
    ) {
        this.data = data;
    }

    public List<Payment> getData() {
        return data;
    }

    public void setData(List<Payment> data) {
        this.data = data;
    }
}
