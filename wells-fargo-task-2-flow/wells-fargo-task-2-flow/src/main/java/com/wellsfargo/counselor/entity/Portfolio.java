package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    // One Portfolio belongs to one Client
    @OneToOne
    @JoinColumn(name = "client_id") // Foreign key for the relationship with Client
    private Client client;

    // Many-to-Many relationship with Security
    @ManyToMany
    @JoinTable(
            name = "portfolio_security", // The name of the join table
            joinColumns = @JoinColumn(name = "portfolio_id"), // Foreign key for Portfolio
            inverseJoinColumns = @JoinColumn(name = "security_id") // Foreign key for Security
    )
    private List<Security> securities;

    // No-argument constructor for JPA
    protected Portfolio() {
    }

    // Parameterized constructor for easy instantiation
    public Portfolio(Client client) {
        this.client = client;
    }

    // Getters and Setters
    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
