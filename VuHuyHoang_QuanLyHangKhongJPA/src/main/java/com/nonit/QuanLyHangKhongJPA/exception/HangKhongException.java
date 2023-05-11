package com.nonit.QuanLyHangKhongJPA.exception;

import org.springframework.http.HttpStatus;

public class HangKhongException {
    private static final String CHUYENBAY_NOT_FOUND_MSG_KEY = "ChuyenBayNotExisted";
    private static final String CHUYENBAY_NOT_FOUND_MSG = "Chuyen Bay Not Found";

    private static final String MAYBAY_NOT_FOUND_MSG_KEY = "MayBayNotExisted";
    private static final String MAYBAY_NOT_FOUND_MSG = "May bay Not Found";

    private static final String NHANVIEN_NOT_FOUND_MSG_KEY = "NhanVienNotExisted";
    private static final String NHANVIEN_NOT_FOUND_MSG = "Nhan Vien Not Found";

    private static final String CHUNGNHAN_NOT_FOUND_MSG_KEY = "ChungNhanNotExisted";
    private static final String CHUNGNHAN_NOT_FOUND_MSG = "Chun gNhanNot Found";

    public static ResponseException notFound(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String msgKey, String msg) {
        return new ResponseException(msgKey, msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException ChuyenBayNotFound() {
        return notFound(CHUYENBAY_NOT_FOUND_MSG_KEY, CHUYENBAY_NOT_FOUND_MSG);
    }

    public static ResponseException MayBayNotFound() {
        return notFound(MAYBAY_NOT_FOUND_MSG_KEY, MAYBAY_NOT_FOUND_MSG);
    }

    public static ResponseException NhanVienNotFound() {
        return notFound(NHANVIEN_NOT_FOUND_MSG_KEY, NHANVIEN_NOT_FOUND_MSG);
    }

    public static ResponseException ChungNhanNotFound() {
        return notFound(CHUNGNHAN_NOT_FOUND_MSG_KEY, CHUNGNHAN_NOT_FOUND_MSG);
    }
}
