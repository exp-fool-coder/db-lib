package com.expfool.libs.dblib.service;

import java.util.function.Supplier;

public interface TransactionService {
    void execute(Runnable task);

    <T> T execute(Supplier<T> task);

    void required(Runnable task);

    <T> T required(Supplier<T> task);

    <T> T readOnly(Supplier<T> task);

}
