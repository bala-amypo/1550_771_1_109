@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with UserProfile
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id") // references UserProfile.id
    @NotNull
    private UserProfile userProfile;

    @Column(name = "user_id", insertable = false, updatable = false)
    @NotNull
    private Long userId;

    private String cardName;
    private String issuer;
    private String cardType;

    @Min(0)
    private Double annualFee;

    @NotNull
    @Column(columnDefinition = "varchar(20) default 'ACTIVE'")
    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<RewardRule> rewardRules;

    public CreditCardRecord() { }

    // ----- Setters -----
    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setAnnualFee(Double annualFee) { this.annualFee = annualFee; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // ----- Getters -----
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getCardName() { return cardName; }
    public String getIssuer() { return issuer; }
    public String getCardType() { return cardType; }
    public Double getAnnualFee() { return annualFee; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
