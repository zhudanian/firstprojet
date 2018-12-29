package com.syw.action;

import org.springframework.stereotype.Repository;

@Repository
public class DataManagerImpl implements DataManager {
    @Override
    public void save() {
        System.out.println("数据的保存");
    }

    @Override
    public void update() {
        System.out.println("数据的更新");
    }

    @Override
    public void delete() {
        System.out.println("数据的删除");
    }
}
