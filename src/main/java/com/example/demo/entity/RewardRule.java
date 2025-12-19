@Entity
@Table(name = "reward_rules")
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rewardType;

    private Double rewardValue;

    @ManyToOne
    @JoinColumn(name = "card_id") // this maps the foreign key
    private CreditCardRecord creditCardRecord;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRewardType() { return rewardType; }
    public void setRewardType(String rewardType) { this.rewardType = rewardType; }

    public Double getRewardValue() { return rewardValue; }
    public void setRewardValue(Double rewardValue) { this.rewardValue = rewardValue; }

    public CreditCardRecord getCreditCardRecord() { return creditCardRecord; }
    public void setCreditCardRecord(CreditCardRecord creditCardRecord) { this.creditCardRecord = creditCardRecord; }
}
