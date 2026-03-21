package edu.fiu.group24.group_24_project.CreditCards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    // This naming convention tells Spring to filter by the 'username' column
    List<CreditCard> findByUsername(String username);
}