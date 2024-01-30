package cc.william.bigevent.service;

import cc.william.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {

    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询分类信息
    Category findById(Integer id);

    //更新分类
    void update(Category category);

    //删除分类
    void deleteById(Integer id);



}
