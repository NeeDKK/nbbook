package com.cy.book.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.book.entity.BookType;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer bookTypeId);


    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer bookTypeId);

    int updateByPrimaryKeySelective(BookType record);


    List<BookType> queryAllBookType();

    List<BookType> selectBookTypeListByBookTypeId(Integer bookTypeId);

    int countByBookTypeName(@Param("bookTypeName") String bookTypeName, @Param("bookTypeId") Integer bookTypeId);
}