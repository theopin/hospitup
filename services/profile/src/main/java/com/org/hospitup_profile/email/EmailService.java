package com.org.hospitup_profile.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;

import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRequestRepository emailRequestRepository;

    @Value("${spring.mail.from}")
    private String from;

    public void sendEmail(EmailRequest emailRequest)
            throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // true = multipart

        setupMimeMessageHelper(helper, emailRequest);

        try {
            mailSender.send(message);
            emailRequestRepository.save(emailRequest);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    private void setupMimeMessageHelper(MimeMessageHelper helper, EmailRequest emailRequest) throws MessagingException {
        helper.setFrom(from);
        helper.setTo(emailRequest.getToRecipients());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getText());

        for (EmailAttachment emailAttachment : emailRequest.getAttachments()) {
            DataSource fileDataSource = new ByteArrayDataSource(
                    emailAttachment.getFileData(),
                    emailAttachment.getContentType()// or other MIME type
            );

            helper.addAttachment(emailAttachment.getFileName(), fileDataSource);
        }

        if (!StringUtils.isBlank(emailRequest.getCcRecipients())) {
            helper.setCc(emailRequest.getCcRecipients());
        }

        if (!StringUtils.isBlank(emailRequest.getBccRecipients())) {
            helper.setBcc(emailRequest.getBccRecipients());
        }
    }



}
