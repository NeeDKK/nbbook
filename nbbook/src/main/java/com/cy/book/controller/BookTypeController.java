package com.cy.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cy.book.annotation.LoginRequired;
import com.cy.book.common.DataGridDataSource;
import com.cy.book.common.JsonData;
import com.cy.book.entity.BookType;
import com.cy.book.service.BookTypeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booktype")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * @description: 加载所有分类数据 展示树
     */
    @PostMapping("/loadAllBookTypeData")
    @LoginRequired
    public Object loadAllBookTypeData() {
        List<BookType> bookTypes = new ArrayList<>();
        List<BookType> bookTypeList = bookTypeService.queryAllBookType();
        Map<Integer, BookType> bookTypeMap = new HashMap<>();
        for (BookType bookType : bookTypeList) {
            bookTypeMap.put(bookType.getBookTypeId(), bookType);
        }
        for (BookType bookType : bookTypeList) {
            BookType child = bookType;
            if (child.getBookTypeParentId() == null) {
                bookTypes.add(bookType);
            } else {
                BookType parent = bookTypeMap.get(child.getBookTypeParentId());
                parent.getChildren().add(child);
            }
        }
        return bookTypes;
    }


    /**
     * @description: 根据id查询分类列表
     */
    @PostMapping("/listByBookTypeId")
    @LoginRequired
    public DataGridDataSource<BookType> selectBookTypeListByBookTypeId(@RequestParam(defaultValue = "0") Integer bookTypeId) {

        List<BookType> bookTypeList = bookTypeService.selectBookTypeListByBookTypeId(bookTypeId);
        DataGridDataSource<BookType> dataGridDataSource = new DataGridDataSource<>();
        dataGridDataSource.setRows(bookTypeList);
        dataGridDataSource.setTotal(bookTypeList.size());
        return dataGridDataSource;
    }


    /**
     * @description: 根据id删除分类
     */
    @DeleteMapping("/delete")
    @LoginRequired
    public JsonData deleteBookType(@RequestParam(value = "bookTypeId") Integer bookTypeId) {

        int count = bookTypeService.deleteBookType(bookTypeId);
        if (count > 0) {
            return JsonData.success(count, "删除成功");
        } else {
            return JsonData.fail("删除失败");
        }
    }


    /**
     * @description: 新增分类
     */
    @PostMapping("/save")
    @LoginRequired
    public JsonData saveBookType(BookType bookType) {
        int count = bookTypeService.saveBookType(bookType);
        if (count > 0) {
            return JsonData.success(count, "新增成功");
        } else {
            return JsonData.fail("新增失败");
        }
    }

    /**
     * @description: 修改分类
     */
    @PutMapping("/update")
    @LoginRequired
    public JsonData update(BookType bookType) {
        int count = bookTypeService.updateBookType(bookType);
        if (count > 0) {
            return JsonData.success(count, "修改成功");
        } else {
            return JsonData.fail("修改失败");
        }
    }
}
