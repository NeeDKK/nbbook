package com.cy.book.service;

import java.util.List;

import com.cy.book.entity.BookType;

/**
 * @Description: BookTypeService
 */
public interface BookTypeService {

    /**
     * @description: 查询所有图书分类信息
     */
    List<BookType> queryAllBookType();

    /**
     * @description: 通过id查询图书分类信息
     */
    List<BookType> selectBookTypeListByBookTypeId(Integer bookTypeId);


    /**
     * @description: 新增分类
     */
    int saveBookType(BookType bookType);


    /**
     * @description: 修改分类
     */
    int updateBookType(BookType bookType);

    /**
     * @description: 删除分类
     */
    int deleteBookType(Integer bookTypeId);


}