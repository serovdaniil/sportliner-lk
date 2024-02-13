package by.sportliner.lk.core.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Transaction.
 */
@Entity
@Table(name = "transaction")
public class Transaction extends AbstractDataObject {

    /**
     * Child.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "child_id")
    private Child child;

    /**
     * Date.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Invoice amount.
     */
    @Column(name = "invoice_amount", nullable = false)
    private BigDecimal invoiceAmount;

    /**
     * Number of lessons.
     */
    @Column(name = "number_of_lessons", nullable = false)
    private int numberOfLessons;

    /**
     * Status.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {

        PAID,

        UNPAID

    }

}
