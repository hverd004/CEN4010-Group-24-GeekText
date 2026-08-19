package edu.fiu.group24.group_24_project.CreditCards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit_cards")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    //credit card for a user
    @PostMapping("/{username}")
    public ResponseEntity<Void> createCreditCard(@PathVariable("username") String username, @RequestBody CreditCard card) {
        card.setUsername(username);
        creditCardRepository.save(card);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable("username") String username, @PathVariable("id") Integer id) {
        return creditCardRepository.findById(id)
                .map(card -> {
                    if (card.getUsername().equals(username)) {
                        creditCardRepository.delete(card);
                        return ResponseEntity.noContent().<Void>build();
                    } else {
                        return ResponseEntity.status(403).<Void>build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<CreditCard>> getCardsByUser(@PathVariable("username") String username) {
        List<CreditCard> cards = creditCardRepository.findByUsername(username);
        return ResponseEntity.ok(cards);
    }

    @PutMapping("/{username}/{id}")
    public ResponseEntity<CreditCard> updateCard(@PathVariable("username") String username, @PathVariable("id") Integer id, @RequestBody CreditCard updatedInfo) {
        return creditCardRepository.findById(id)
                .map(card -> {
                    if (card.getUsername().equals(username)) {
                        card.setCardBrand(updatedInfo.getCardBrand());
                        card.setLast4(updatedInfo.getLast4());
                        card.setExpMonth(updatedInfo.getExpMonth());
                        card.setExpYear(updatedInfo.getExpYear());
                        return ResponseEntity.ok(creditCardRepository.save(card));
                    }
                    return ResponseEntity.status(403).<CreditCard>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
