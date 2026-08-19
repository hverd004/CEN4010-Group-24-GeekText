package edu.fiu.group24.group_24_project.CreditCards;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    List<CreditCard> findByUsername(String username);
}
