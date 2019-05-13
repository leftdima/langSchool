package com.baranchik.mail;

import com.baranchik.model.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SimpleMailMessage templateMessage;

    public boolean sendMessage(OrderClient orderClient) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(templateMessage);
        System.out.println(simpleMailMessage);
        System.out.println(orderClient);
        simpleMailMessage.setTo(orderClient.getUser().getEmail());
        simpleMailMessage.setText(createMessage(orderClient));
        try {
            javaMailSender.send(simpleMailMessage);
            System.out.println("Mail sended");
            return true;
        } catch (MailException mailException) {
            System.out.println("Mail send failed.");
            mailException.printStackTrace();
            return false;
        }
    }

    private String createMessage(OrderClient orderClient) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Здравствуйте")
                .append(", ")
                .append(orderClient.getUser().getName()).append(" ")
                .append(orderClient.getUser().getFathername())
                .append("\n")
                .append("Ваш заказ обработан. Ожидайте доставки. Ваш чек: \n");

        orderClient
                .getCheckSet()
                .forEach(check -> stringBuffer.append(check).append("\n"));

        stringBuffer
                .append("\n")
                .append("Общая сумма заказа: ")
                .append(orderClient.getOrderPrice());

        return stringBuffer.toString();
    }

}
