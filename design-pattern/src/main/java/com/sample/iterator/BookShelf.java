package com.sample.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2020/9/16 14:32
 */
public class BookShelf implements Aggregate {

    private List<Book> books;


    public BookShelf() {
        this.books = new ArrayList<Book>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}