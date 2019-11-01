package com.cy.book.service;

import java.util.List;
import java.util.Map;

import com.cy.book.entity.BookInfo;

/**
 * @Description: BookInfoService
 */
public interface BookInfoService {


    /**
     * @description: 新增图书
     */
    int saveBookInfo(BookInfo bookInfo);

    /**
     * @description: 编辑图书
     */
    int updateBookInfo(BookInfo bookInfo);


    /**
     * @description: 删除图书
     */
    int deleteBookInfo(Integer bookId);


    /**
     * @description: 查询图书列表
     */
    List<BookInfo> selectBookInfoList(Map<String, Object> map);

    /**
     * @description: 查询图书列表总数
     */
    int getTotalBook(Map<String, Object> map);

    /**
     * @description: 根据id查询图书
     */
    List<BookInfo> selectBookById(Integer bookId);


    /**
     * @description: 根据id查询图书
     */
    BookInfo selectBookInfoById(Integer bookId);

}
