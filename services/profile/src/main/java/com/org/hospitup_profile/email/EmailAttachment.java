package com.org.hospitup_profile.email;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "email_attachment")
@Data
@Builder
public class EmailAttachment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long attachmentId;

    @NotBlank
    private String fileName;

    @Lob
    private byte[] fileData;

    @NotBlank
    private String contentType;
}
