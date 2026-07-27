package com.example.mipanini2026.room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class DatabaseExecutor {

    private static final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    private DatabaseExecutor() {
    }

    public static ExecutorService getExecutor() {
        return executor;
    }
}