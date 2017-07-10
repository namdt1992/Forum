package com.forum.util.validation;

public class RepositoryStatus <T extends Object> extends Status {

    private T object;

    public RepositoryStatus() {
	}

	public RepositoryStatus(String code, String message) {
        super(code, message);
    }

    public RepositoryStatus(String code, String message, T object) {
        super(code, message);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
