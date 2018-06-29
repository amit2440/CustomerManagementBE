package com.customermanagement.service;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import com.customermanagement.model.Payment;
import com.customermanagement.repository.AddressRepo;
import com.customermanagement.repository.ConnectionRepo;
import com.customermanagement.repository.CustManagementRepo;
import com.customermanagement.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * Created by Amit Raut on 5/18/2018.
 */

@Service
public class CustManagementService {

    @Autowired
    CustManagementRepo custManagementRepo;

    @Autowired
    ConnectionRepo connectionRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    AddressRepo addressRepo;

    public List<Customer> getAllCustomers(){
        return custManagementRepo.findAll();
    }

    public List<Connection> getAllConnections(){
        return connectionRepo.findAll();
    }

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public boolean createCustomer(Customer customer) {
        try {
            if (custManagementRepo.findByMobileNo(customer.getMobileNo()).isPresent()) {
                return false;
            }
            custManagementRepo.save(customer);
            return true;
        }catch (Exception e) {
            throw e;
        }
    }

    public void createConnection(Connection conn) {
        connectionRepo.save(conn);
    }


    public void sendEmail(File file){
        final String username = "amitangel1991@gmail.com";
        final String password = "@gmail2310";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("amitangel1991@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("amitraut8873@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            BodyPart messageBodyPart = new MimeBodyPart();

            // Create a multipar message
            Multipart multipart = new MimeMultipart();


            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
           // String filename = "/home/manisha/file.txt";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String findMaxInvoiceNo(){
       return paymentRepo.findMaxInvoiceNo();
    }

    public void addPayment(Payment payment){
        paymentRepo.save(payment);
    }

    public void updatePayment(Payment payment){
        paymentRepo.updatePayment(payment.getInvoiceNo(),payment.getPaymentMethod(),payment.getPaymentAmount(),payment.getPaymentStatus(),payment.getInternetPlan()
        ,payment.getPaymentId(),payment.getDate());
    }



}
