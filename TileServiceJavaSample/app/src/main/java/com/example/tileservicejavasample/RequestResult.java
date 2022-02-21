package com.example.tileservicejavasample;

import android.app.StatusBarManager;

import java.util.Arrays;
import java.util.Optional;

public enum RequestResult {
    TILE_ADD_REQUEST_ERROR_APP_NOT_IN_FOREGROUND(StatusBarManager.TILE_ADD_REQUEST_ERROR_APP_NOT_IN_FOREGROUND),
    TILE_ADD_REQUEST_ERROR_BAD_COMPONENT(StatusBarManager.TILE_ADD_REQUEST_ERROR_BAD_COMPONENT),
    TILE_ADD_REQUEST_ERROR_MISMATCHED_PACKAGE(StatusBarManager.TILE_ADD_REQUEST_ERROR_MISMATCHED_PACKAGE),
    TILE_ADD_REQUEST_ERROR_NOT_CURRENT_USER(StatusBarManager.TILE_ADD_REQUEST_ERROR_NOT_CURRENT_USER),
    TILE_ADD_REQUEST_ERROR_NO_STATUS_BAR_SERVICE(StatusBarManager.TILE_ADD_REQUEST_ERROR_NO_STATUS_BAR_SERVICE),
    TILE_ADD_REQUEST_ERROR_REQUEST_IN_PROGRESS(StatusBarManager.TILE_ADD_REQUEST_ERROR_REQUEST_IN_PROGRESS),
    TILE_ADD_REQUEST_RESULT_TILE_ADDED(StatusBarManager.TILE_ADD_REQUEST_RESULT_TILE_ADDED),
    TILE_ADD_REQUEST_RESULT_TILE_ALREADY_ADDED(StatusBarManager.TILE_ADD_REQUEST_RESULT_TILE_ALREADY_ADDED),
    TILE_ADD_REQUEST_RESULT_TILE_NOT_ADDED(StatusBarManager.TILE_ADD_REQUEST_RESULT_TILE_NOT_ADDED);
    private final int code;

    RequestResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    static Optional<RequestResult> findByCode(int code) {
        return Arrays.stream(values()).filter(value -> value.code == code).findFirst();
    }
}
