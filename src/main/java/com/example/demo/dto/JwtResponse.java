package com.example.demo.dto;

public class JwtResponse {
    
}

UserProfileService
createUser(UserProfile profile)
getUserById(Long id);
findByUserId(String userId);
getAllUsers();
updateUserStatus(Long id,boolean active);

CreditCardService
addCard(CreditCarRecord card);
UpdateCard(Long id,CreditCardRecord updated);
getCardsByUser(Long userId)
getCardById(Long id)
getAllCards()

RewardRuleService
createRule(RewardRule rule)
updateRule(Long id,RewardRule updated)
getRulesByCard(Long cardId)
getActiveRules()
getAllRules()

PurchaseIntentService
createIntent(PurchaseIntentRecord intent)
hetIntentbyUser(Long userId)
getAllIntents()

RecommendationEngineService
generateRecommendation(Long intentId)
getRecommendationById(Long id)
getRecommendationByUser(Long userId)
getAllRecommendations()
