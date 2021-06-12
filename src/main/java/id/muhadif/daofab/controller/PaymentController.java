package id.muhadif.daofab.controller;

import id.muhadif.daofab.dao.PaymentServiceDao;
import id.muhadif.daofab.entity.DetailPayment;
import id.muhadif.daofab.entity.Pagination;
import id.muhadif.daofab.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController{

    @Autowired
    private PaymentServiceDao paymentServiceDao;

    @RequestMapping("/")
    public String index(HttpServletResponse httpResponse) throws Exception {
        httpResponse.sendRedirect("/payment");
        return null;

    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String paymentPage(@RequestParam(required = false) Integer page, Model model) throws IOException {
        Pagination<Payment> payments;

        try {
            if (page != null){
                payments = paymentServiceDao.getPayments(page);
            } else {
                payments = paymentServiceDao.getPayments(1);
            }
        } catch (Exception e){
            throw new IOException(e);
        }

        model.addAttribute("payments", payments);
        return "payment";
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public String paymentDetailPage(@PathVariable int id , Model model) throws IOException {
        List<DetailPayment> detailPayments = new ArrayList<>();
        try {
            detailPayments = paymentServiceDao.getDetailPayment(id);
        } catch (Exception e){
            throw new IOException(e);
        }

        model.addAttribute("detailPayments", detailPayments);
        return "paymentDetail";
    }
}