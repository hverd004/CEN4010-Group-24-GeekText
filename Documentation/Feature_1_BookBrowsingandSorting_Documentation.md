# Feature 1: Book Browsing & Sorting Documentation (Implemented by Jennifer Ward)

**Group 24 | Java / Spring Boot / PostgreSQL**

This feature includes 4 endpoints for browsing, sorting, and filtering books in a bookstore.

---

## Files

`BookBrowsingController.java` - Handles incoming requests and maps them to service calls
`BookBrowsingService.java` - The business logic and input validations
`BookBrowsingRepository.java` - Database queries via Spring Data JPA
`Book.java` _(shared)_ - A shared file. It is the JPA entity for the book table and is shared across the project

---

## Endpoints

### 1. Get Books by Genre

**`GET /api/books/genre/{genreName}`**

This returns all books in a given genre, sorted A–Z by title. Parameter needed: genreName

**Example:** `/api/books/genre/Fantasy`

**Validation:**

- Throws `IllegalArgumentException` if genre is null or blank → `400 Bad Request`
- Match is case-insensitive, input is trimmed before querying

**Response:** `200 OK` — JSON array of book objects. Will return an empty array if no books found

```java
// Controller
@GetMapping({"/genre","/genre/{genreName}"})
public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable(value = "genreName", required = false) String genreName) {
    return ResponseEntity.ok(bookBrowsingService.getBooksByGenre(genreName));
}

// Repository
List<Book> findByBookGenre_GenreIgnoreCaseOrderByBookNameAsc(String bookGenre);
```

---

### 2. Get Top 10 Best Sellers

**`GET /api/books/top-sellers`**

This returns the top 10 books by copies sold, highest first. No parameters needed.

**Response:** `200 OK` — JSON array of up to 10 book objects

```java
// Controller
@GetMapping("/top-sellers")
public ResponseEntity<List<Book>> getTopSellers() {
    return ResponseEntity.ok(bookBrowsingService.getTopSellers());
}

// Repository
List<Book> findTop10ByOrderByBookCopiesSoldDesc();
```

---

### 3. Get Books by Minimum Rating

**`GET /api/books/rating/{minRating}`**

This returns all books with an average rating at or above the given value, sorted highest to lowest.

**Example:** `/api/books/rating/4.0`

**Validation:**

- Throws `IllegalArgumentException` if rating is null → `400 Bad Request`
- Throws `IllegalArgumentException` if rating is outside `0.0 – 5.0` → `400 Bad Request`

**Response:** `200 OK` — JSON array of book objects (empty array if none match)

```java
// Controller
@GetMapping("/rating/{minRating}")
public ResponseEntity<List<Book>> getBooksByMinRating(@PathVariable BigDecimal minRating) {
    return ResponseEntity.ok(bookBrowsingService.getBooksByMinRating(minRating));
}

// Repository
List<Book> findByAvgRatingGreaterThanEqualOrderByAvgRatingDesc(BigDecimal minRating);
```

---

### 4. Apply Publisher Discount

**`PATCH /api/books/discount`**

Applies a percentage discount to all books under a given publisher. No response body.

**Example:** `/api/books/discount?publisher=Penguin&discount=10`

**Parameters:**

- `publisher` — publisher name (String)
- `discount` — discount percentage (BigDecimal, e.g. `10` = 10% off)

**How the discount is calculated:**

```
newPrice = bookPrice × (1 - discount / 100)
```

Rounded to 2 decimal places using `HALF_UP`. All updated books are saved with `saveAll()`.

**Response:** `204 No Content`

```java
// Controller
@PatchMapping("/discount")
public ResponseEntity<Void> applyPublisherDiscount(
        @RequestParam("publisher") String publisherName,
        @RequestParam("discount") BigDecimal discountPercent) {
    bookBrowsingService.applyPublisherDiscount(publisherName, discountPercent);
    return ResponseEntity.noContent().build();
}

// Repository
@Query("SELECT b FROM Book b WHERE LOWER(b.bookPublisher.publisher_name) = LOWER(:publisherName)")
List<Book> findByPublisherName(@Param("publisherName") String publisherName);
```

> **Why `@Query` here?** The `Publisher` entity uses `publisher_name` as a field name, which Spring JPA misreads when trying to parse a derived method name because it treats underscores as separators. Writing the JPQL manually with `@Query` avoids this without needing to change Hector's entity.

---

## Notes

**`BigDecimal` for prices and ratings** — used instead of `float`/`double` to avoid floating-point precision issues. All math is done with `RoundingMode.HALF_UP` scaled to 2 decimal places.

**Discount uses fetch → loop → saveAll** — instead of a bulk `@Modifying @Query` update. I kept the discount logic in the service layer instead of doing a bulk update because it was easier to test and debug.

**To reset prices after testing the discount endpoint** — re-run `V2__seed-data.sql` to restore the original values.

---

## Quick Postman Reference

| Request             | URL                                                       | Expected                                          |
| ------------------- | --------------------------------------------------------- | ------------------------------------------------- |
| Books by genre      | `GET /api/books/genre/Fantasy`                            | `200 OK`                                          |
| Top sellers         | `GET /api/books/top-sellers`                              | `200 OK`                                          |
| Filter by rating    | `GET /api/books/rating/4.0`                               | `200 OK`                                          |
| Apply discount      | `PATCH /api/books/discount?publisher=Penguin&discount=10` | `204 No Content`                                  |
| Blank genre         | `GET /api/books/genre/`                                   | `400 Bad Request genre is required`               |
| Rating out of range | `GET /api/books/rating/6.0`                               | `400 Bad Request Rating must be between 0 and 5 ` |
