package pl.akoz.zadanie22;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private JavaMailSender javaMailSender;

    public MessageService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(String receiver, String title, String content) {
        logger.debug("Wysyłam wiadomość do {}", receiver);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiver);
        message.setSubject(title);
        message.setText(content);

        javaMailSender.send(message);

        logger.debug("Wiadomość do {} wysłana poprawnie", receiver);
    }

    public SimpleMailMessage createMessage(Message message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("slomkitest@fake-box.com");
        mail.setSubject("Nadawca" + message.getName());
        mail.setText(message.getContent());
        mail.setReplyTo(message.getEmail());
        mail.setFrom(message.getName());
        return mail;

    }

    public SimpleMailMessage createReply(Message message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(message.getEmail());
        mail.setSubject("Potwierdzenie otrzymania wiadomości");
        mail.setText("Dziękujemy za wiadomość. Odezwiemy się jak najszybciej");
        mail.setFrom("slomkitest@byom.de");
        return mail;

    }
}

