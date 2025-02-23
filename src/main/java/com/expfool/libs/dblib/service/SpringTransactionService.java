package com.expfool.libs.dblib.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

public class SpringTransactionService implements TransactionService {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void execute(Runnable task) {
        task.run();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public <T> T execute(Supplier<T> task) {
        return task.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void required(Runnable task) {
        task.run();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <T> T required(Supplier<T> task) {
        return task.get();
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T readOnly(Supplier<T> task) {
        return task.get();
    }

}
