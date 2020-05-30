package com.ivan.springwebapp.bootstrap;

import com.ivan.springwebapp.domain.Author;
import com.ivan.springwebapp.domain.Book;
import com.ivan.springwebapp.domain.Publisher;
import com.ivan.springwebapp.repositories.AuthorRepository;
import com.ivan.springwebapp.repositories.BookRepository;
import com.ivan.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start in bootstrap");


        Publisher publisher = new Publisher();
        publisher.setName("Prentice Hall");
        publisher.setCity("Upper Saddle River");
        publisher.setState("NJ");

        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Artima");
        publisher1.setCity("Walnut Creek");
        publisher1.setState("CA");
        publisherRepository.save(publisher1);

        Author bruce = new Author("Bruce", "Eckel");
        Book java = new Book("Thinking in Java (4th Edition)", "978-0131872486");
        bruce.getBooks().add(java);
        java.getAuthors().add(bruce);

        java.setPublisher(publisher);
        publisher.getBooks().add(java);

        authorRepository.save(bruce);
        bookRepository.save(java);
        publisherRepository.save(publisher);

        Author martin = new Author("Martin", "Odersky");
        Book scala = new Book("Programming in Scala Fourth Edition", "777-77777777");
        martin.getBooks().add(scala);
        scala.getAuthors().add(martin);

        scala.setPublisher(publisher1);
        publisher1.getBooks().add(scala);

        authorRepository.save(martin);
        bookRepository.save(scala);
        publisherRepository.save(publisher1);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
