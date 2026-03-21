package edu.fiu.group24.group_24_project.CreditCards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    // POST: Create a new credit card for a specific user
    @PostMapping("/{username}")
    public ResponseEntity<Void> createCreditCard(@PathVariable String username, @RequestBody CreditCard card) {
        card.setUsername(username);
        creditCardRepository.save(card);
        return ResponseEntity.status(201).build();
    }


    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable String username, @PathVariable Long id) {
        return creditCardRepository.findById(id)
                .map(card -> {
                    // Check if the card's username matches the URL username
                    if (card.getUsername().equals(username)) {
                        creditCardRepository.delete(card);
                        return ResponseEntity.noContent().<Void>build(); // 204 Success
                    } else {
                        return ResponseEntity.status(403).<Void>build(); // 403 Forbidden
                    }
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<CreditCard>> getCardsByUser(@PathVariable String username) {
        List<CreditCard> cards = creditCardRepository.findByUsername(username);
        return ResponseEntity.ok(cards);
    }
    // PUT: Update card info for a specific user
    @PutMapping("/{username}/{id}")
    public ResponseEntity<CreditCard> updateCard(@PathVariable String username, @PathVariable Long id, @RequestBody CreditCard updatedInfo) {
        return creditCardRepository.findById(id)
                .map(card -> {
                    // Only update if the username matches (Simple Security)
                    if (card.getUsername().equals(username)) {
                        card.setCardBrand(updatedInfo.getCardBrand());
                        card.setLast4(updatedInfo.getLast4());
                        card.setExpMonth(updatedInfo.getExpMonth());
                        card.setExpYear(updatedInfo.getExpYear());
                        return ResponseEntity.ok(creditCardRepository.save(card));
                    }
                    return ResponseEntity.status(403).<CreditCard>build(); // Wrong user
                })
                .orElse(ResponseEntity.notFound().build()); // Card ID doesn't exist
    }

}
