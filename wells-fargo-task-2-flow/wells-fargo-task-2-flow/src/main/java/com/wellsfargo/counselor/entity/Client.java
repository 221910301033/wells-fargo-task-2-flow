package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key
    private long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone; // Added phone field

    // Many Clients belong to one Financial Advisor
    @ManyToOne
    @JoinColumn(name = "advisor_id") // Foreign key for the relationship with FinancialAdvisor
    private FinancialAdvisor advisor;

    // One Client has one Portfolio
    @OneToOne(mappedBy = "client") // Portfolio owns the relationship
    private Portfolio portfolio;

    // No-argument constructor for JPA
    protected Client() {
    }

    // Parameterized constructor for easy instantiation
    public Client(String firstName, String lastName, String email, String phone, FinancialAdvisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.advisor = advisor;
    }

    // Getters and Setters
    public long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FinancialAdvisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(FinancialAdvisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
