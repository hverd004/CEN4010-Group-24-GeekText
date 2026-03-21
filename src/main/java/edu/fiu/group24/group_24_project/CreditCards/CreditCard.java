package edu.fiu.group24.group_24_project.CreditCards;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer cardId;

    private String username;

    @Column(name = "card_brand")
    private String cardBrand;

    private String last4;

    @Column(name = "exp_month")
    private int expMonth;

    @Column(name = "exp_year")
    private int expYear;

    public CreditCard() {}

    // Getters and Setters
    public Integer getCardId() { return cardId; }
    public void setCardId(Integer cardId) { this.cardId = cardId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getCardBrand() { return cardBrand; }
    public void setCardBrand(String cardBrand) { this.cardBrand = cardBrand; }
    public String getLast4() { return last4; }
    public void setLast4(String last4) { this.last4 = last4; }
    public int getExpMonth() { return expMonth; }
    public void setExpMonth(int expMonth) { this.expMonth = expMonth; }
    public int getExpYear() { return expYear; }
    public void setExpYear(int expYear) { this.expYear = expYear; }
}