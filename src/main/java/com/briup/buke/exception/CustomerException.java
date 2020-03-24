package com.briup.buke.exception;

/**
 * @program: estore
 * @description: 自定义异常
 * @author: wangzh
 *
 **/

public class CustomerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
     * 状态码
     */
    private Integer code;
    private String message;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
