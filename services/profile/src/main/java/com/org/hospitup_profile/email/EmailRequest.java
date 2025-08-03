package com.org.hospitup_profile.email;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "email_request")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long emailRequestId;

    @NotBlank
    private String toRecipients; 

    private String ccRecipients; 

    private String bccRecipients;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "email_request_id") // This makes Email the owning side
    private List<EmailAttachment> attachments = new ArrayList<>();
}
