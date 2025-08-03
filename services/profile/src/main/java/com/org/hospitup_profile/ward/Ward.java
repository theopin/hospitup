package com.org.hospitup_profile.ward;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import com.org.hospitup_profile.bed.Bed;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "ward")
@Data
@Builder
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long wardId;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String location;

    @Builder.Default // override normal init
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL) // <-- omit orphanRemoval - bed can exist without ward
    private List<Bed> beds = new ArrayList<>();


    @Transient // Not persisted to DB; used only for temporary or computed values at runtime
    public long getTotalBeds() {
        return beds.size();
    }

    @Transient
    public long getOccupiedBeds() {
        return beds.stream().filter(b -> b.getPatient() != null).count();
    }

    @Transient
    public long getAvailableBeds() {
        return getTotalBeds() - getOccupiedBeds();
    }

}
