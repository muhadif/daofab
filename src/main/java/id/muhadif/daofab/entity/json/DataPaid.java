package id.muhadif.daofab.entity.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import id.muhadif.daofab.entity.Paid;

import java.util.List;

/**
 * @Author muhadif
 * @create 12/06/21 21.40
 */

public class DataPaid {

    List<Paid> data;

    @JsonCreator
    public DataPaid(
            @JsonProperty("data")
            List<Paid> data
    ) {
        this.data = data;
    }

    public List<Paid> getData() {
        return data;
    }

    public void setData(List<Paid> data) {
        this.data = data;
    }
}
