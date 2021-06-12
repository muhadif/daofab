package id.muhadif.daofab.dao;

import id.muhadif.daofab.entity.*;
import id.muhadif.daofab.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author muhadif
 * @create 12/06/21 20.54
 */
@Service
public class PaymentServiceDao {

    public final int SIZE = 2;

    @Autowired
    private PaymentRepository paymentRepository;

    public Pagination<Payment> getPayments(Integer page) throws IOException {

        List<Payment> payments = paymentRepository.getParents();
        payments.sort(Comparator.comparing(Payment::getId));
        Pagination<Payment> pagination = new Pagination(page, 2,payments.size());

        if (!(pagination.getStartFrom() > payments.size())) {
            for (Payment payment : payments) {
                List<Paid> paids = paymentRepository.getChild();
                int totalPaid = 0;
                for (Paid paid : paids){
                    if (paid.getParentId() == payment.getId()){
                        totalPaid += paid.getPaidAmount();
                    }
                }
                payment.setTotalPaidAmount(totalPaid);
            }
            payments = payments.subList(pagination.getStartFrom(), pagination.getEndOn());
            pagination.setProduct(payments);
        } else {
            payments = new ArrayList<>();
            pagination.setProduct(payments);
        }
        return pagination;
    }

    public List<DetailPayment> getDetailPayment(int id) throws IOException {
        List<DetailPayment> detailPayments = new ArrayList<DetailPayment>();

        List<Payment> payments = paymentRepository.getParents().stream()
                .filter(payment -> payment.getId() == id).collect(Collectors.toList());
        List<Paid> paids = paymentRepository.getChild().stream()
                .filter(paid -> paid.getParentId() == id).collect(Collectors.toList());

        if(payments.size() > 0){
            Payment selectedPayment = payments.get(0);
            for(Paid paid : paids){
                detailPayments.add(
                        new DetailPayment(
                                paid.getId(),
                                selectedPayment.getSender(),
                                selectedPayment.getReceiver(),
                                selectedPayment.getTotalAmount(),
                                paid.getPaidAmount()
                                )
                );
            }
        }

        return detailPayments;
    }
}
