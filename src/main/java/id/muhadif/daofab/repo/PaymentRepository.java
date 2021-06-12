package id.muhadif.daofab.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.muhadif.daofab.entity.json.DataPaid;
import id.muhadif.daofab.entity.json.DataPayment;
import id.muhadif.daofab.entity.Paid;
import id.muhadif.daofab.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author muhadif
 * @create 12/06/21 22.47
 */

@Service
public class PaymentRepository {
    @Autowired
    private ResourceLoader resourceLoader;

    public List<Payment> getParents() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Resource resource = resourceLoader.getResource("classpath:parent.json");
        InputStream parentFile = resource.getInputStream();

        DataPayment dataPayment = objectMapper.readValue(parentFile, DataPayment.class);

        return dataPayment.getData();
    }

    public List<Paid> getChild() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Resource resource = resourceLoader.getResource("classpath:child.json");
        InputStream parentFile = resource.getInputStream();

        DataPaid dataPaid = objectMapper.readValue(parentFile, DataPaid.class);

        return dataPaid.getData();
    }
}
