package com.ivan.springwebapp.bootstrap;

import com.ivan.springwebapp.domain.Author;
import com.ivan.springwebapp.domain.Book;
import com.ivan.springwebapp.repositories.AuthorRepository;
import com.ivan.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author bruce = new Author("Bruce", "Eckel");
        Book java = new Book("Thinking in Java (4th Edition)", "978-0131872486");
        bruce.getBooks().add(java);
        java.getAuthors().add(bruce);

        authorRepository.save(bruce);
        bookRepository.save(java);

        Author martin = new Author("Martin", "Odersky");
        Book scala = new Book("Programming in Scala Fourth Edition", "777-77777777");
        martin.getBooks().add(scala);
        scala.getAuthors().add(martin);

        authorRepository.save(martin);
        bookRepository.save(scala);

        System.out.println("Start in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
