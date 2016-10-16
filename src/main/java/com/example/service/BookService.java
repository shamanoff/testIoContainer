package com.example.service;

import com.example.Entity;
import com.example.EntityDAO;
import com.example.IService;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.view.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IService {

 /*   @Autowired
    @Qualifier("bookDAO")*/
    private EntityDAO bookDAO;
/*    @Autowired
    @Qualifier("authorDAO")*/
    private EntityDAO authorDAO;

    @Autowired
    public BookService(@Qualifier("bookDAO") EntityDAO bookDAO,@Qualifier("authorDAO") EntityDAO authorDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }

    @Override
    public void print(int id) {
        Author author = (Author) authorDAO.findOne(id);
        Book book = (Book) bookDAO.findOne(author.getBookId());

        BookView bookView = new BookView(book.getId(), book.getTitle(), author.getName());
        System.out.println(bookView.toString());
    }

    @Override
    public void save(List<Entity> listEntities) {
        for (Entity entity : listEntities) {
            if(entity instanceof Book){
                bookDAO.save( entity);
                continue;
            }
            if ( entity instanceof  Author){
                authorDAO.save( entity);
            }
        }
    }
}
