package com.billennium.vaccinationproject.entity;

import com.billennium.vaccinationproject.utilities.Manufacturer;
import com.billennium.vaccinationproject.utilities.VaccineDose;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vaccine")
public class VaccineEntity {

    @Id
    @SequenceGenerator(
            name = "vaccine_sequence",
            sequenceName = "vaccine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vaccine_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "manufacturer")
    private Manufacturer manufacturer;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "name")
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH,
            mappedBy = "vaccine"
    )
    private List<VisitEntity> visits;

    @Column(name = "vaccine_dose")
    @Enumerated(value = EnumType.ORDINAL)
    private VaccineDose vaccineDose;

    @JsonIgnore
    public List<VisitEntity> getVisits() {
        return visits;
    }

}
