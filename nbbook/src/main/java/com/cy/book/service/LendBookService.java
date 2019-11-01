package com.cy.book.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.cy.book.entity.LendReturnList;

/**
 * @Description:
 */
public interface LendBookService {

    /**
     * @description: 借书
     */
    int lendBook(LendReturnList lendReturnList) throws ParseException;


    /**
     * @description: 根据用户ID查询借还记录
     */
    List<LendReturnList> selectLendReturnRecordByUserId(Map<String, Object> map) throws ParseException;

    /**
     * @description: 根据用户ID查询借还记录总数
     */
    int getTotalRecord(Map<String, Object> map);
}