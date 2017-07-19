/**
 * 
 */
package com.forum.configuration.constant;

/**
 * @author NamDT8
 *
 */
public class HttpConstant {

    public static final String CODE_BAD_REQUEST = "400";
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_NOT_FOUND = "202";
    public static final String CODE_FORBIDDEN = "403";
    public static final String CODE_NOT_ACCEPTABLE = "409";
    public static final String CODE_SERVER_ERROR = "500";

    public static final String MESSAGE_BAD_REQUEST = "bad_request";
    public static final String MESSAGE_SUCCESS = "acknowledged";
    public static final String MESSAGE_NOT_FOUND = "not found";
    public static final String MESSAGE_SERVER_ERROR = "Server got error. Please wait a moment and try it again later.";

    public static class HttpMessage {
        public static final String QUERY_SUCCESS = "found";
        public static final String COMMON_ERROR = "something went wrong";
        public static final String NOT_EXIST = "not found";
        public static final String UPDATE_SUCCESS = "updating successfully";
        public static final String SAVE_SUCCESS = "saving successfully";
        public static final String DELETE_SUCCESS = "deleting successfully";
        public static final String MISSING_USER = "missing user id";
        public static final String BAD_REQUEST = "bad request";
        public static final String OK = "acknowledged";
        public static final String SERVER_ERROR = "server error";
        public static final String FOUND = "found";
    }

    public static class HttpCode {
        public static final String OK = "200";
        public static final String SERVER_ERROR = "500";
        public static final String NOT_FOUND = "404";
        public static final String BAD_REQUEST = "403";
        public static final String MISSING_USER = "601";
    }
}
