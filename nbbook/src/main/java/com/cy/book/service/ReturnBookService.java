package com.cy.book.service;

import java.text.ParseException;
import java.util.List;

import com.cy.book.entity.LendReturnList;

/**
 * @Description:
 */
public interface ReturnBookService {

    /**
     * @description: 根据图书id查询图书及借阅者信息
     */
    List<LendReturnList> selectBookInfoAndUserByBookId(Integer bookId) throws ParseException;


    /**
     * @description: 还书
     */
    int returnBook(LendReturnList lendReturnList) throws ParseException;
}
