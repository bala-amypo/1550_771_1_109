
UserProfileService
createUser(UserProfile profile)
getUserById(Long id);
findByUserId(String userId);
getAllUsers();
updateUserStatus(Long id,boolean active);

CreditCardService
addCard(CreditCarRecord card);
UpdateCard(Lonf id,CreditCardRecord updated);
getCardsByUser(Long userId)
getCardById(Long id)
getAllCards()

RewardRuleService
createRule(RewardRule rule)
updateRule(Long id,RewardRule updated)
getRulesByCard(Long )
