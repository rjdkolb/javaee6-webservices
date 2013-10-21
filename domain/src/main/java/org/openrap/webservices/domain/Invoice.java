package org.openrap.webservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@XmlRootElement
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Customer customer;
    private int invoiceAmountCents;

    public Invoice(Customer customer, int invoiceAmountCents) {
        this.customer = customer;
        this.invoiceAmountCents = invoiceAmountCents;
    }
}