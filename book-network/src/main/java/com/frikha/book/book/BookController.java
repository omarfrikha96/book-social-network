package com.frikha.book.book;

import com.frikha.book.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Book")
public class BookController {

    private final BookService service;

    //Save book
    @PostMapping
    public ResponseEntity<Integer> saveBook(@Valid @RequestBody BookRequest request, Authentication connectedUser) {
        return ResponseEntity.ok(service.save(request, connectedUser));
    }

    //Get book by id
    @GetMapping("/{book-id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book-id") Integer bookId) {
        return ResponseEntity.ok(service.findById(bookId));
    }

    //Get all books
    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAllBooks(page, size, connectedUser));
    }

    //Get all books by owner
    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findAllBooksByOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAllBooksByOwner(page, size, connectedUser));
    }

    //Get all borrowed books
    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAllBorrowedBooks(page, size, connectedUser));
    }

    //Get all returned books
    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAllReturnedBooks(page, size, connectedUser));
    }

    //Update  shareable status book
    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Integer> updateShareableStatus(@PathVariable("book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.updateShareableStatus(bookId, connectedUser));
    }
    //Update  archived status book
    @PatchMapping("/archived/{book-id}")
    public ResponseEntity<Integer> updateArchivedStatus(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.updateArchivedStatus(bookId, connectedUser));
    }
    //Borrow book
    @PostMapping("borrow/{book-id}")
    public ResponseEntity<Integer> borrowBook(@PathVariable("book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.borrowBook(bookId, connectedUser));
    }

    @PatchMapping("borrow/return/{book-id}")
    public ResponseEntity<Integer> returnBorrowBook(@PathVariable("book-id") Integer bookId, Authentication connectedUser) {
        return ResponseEntity.ok(service.returnBorrowedBook(bookId, connectedUser));
    }

}
