package com.customermanagement.service;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import com.customermanagement.model.Payment;
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


    public void sendEmail(){
        String to = "amiraut8873@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "amitangel1991@gmail.com";

        final String username = "manishaspatil";//change accordingly
        final String password = "******";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "localhost";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "/home/manisha/file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }




}
