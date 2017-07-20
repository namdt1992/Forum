/**
 * 
 */
package com.forum.util.validation;

import java.util.List;

import com.forum.domain.AbstractEntity;

/**
 * @author NamDT8
 *
 */
public class ResponseStatus <T extends AbstractEntity> extends RepositoryStatus<Object> {

   private Long index;
    private Integer count;
    private List<T> data;
    private Object object;

    public ResponseStatus() {
    }

    public ResponseStatus(String code, String message) {
        super(code, message);
    }

    public <S extends Status> ResponseStatus(S s) {
        super(s.getCode(), s.getMessage());
    }

    public ResponseStatus(String code, String message, Long index) {
        super(code, message);
        this.index = index;
    }
    
    public <S extends Status> ResponseStatus(S s, Long index) {
    	super(s.getCode(), s.getMessage());
    	this.index = index;
    }
    
    public ResponseStatus(String code, String message, Integer count, List<T> data) {
        super(code, message);
        this.count = count;
        this.data = data;
    }

    public <S extends Status> ResponseStatus(S s, Integer count, List<T> data) {
    	super(s.getCode(), s.getMessage());
        this.count = count;
        this.data = data;
    }
    
    public <S extends Status> ResponseStatus(S s, List<T> data) {
        super(s.getCode(), s.getMessage());
        this.data = data;
    }

    public ResponseStatus(String code, String message, Integer count, Object object) {
        super(code, message);
        this.count = count;
        this.object = object;
    }

    public <S extends Status> ResponseStatus(S s, Integer count, Object object) {
        super(s.getCode(), s.getMessage());
        this.count = count;
        this.object = object;
    }

    public ResponseStatus(String code, String message, Object object) {
        super(code, message);
        this.object = object;
    }

    public <S extends Status> ResponseStatus(S s, Object object) {
        super(s.getCode(), s.getMessage());
        this.object = object;
    }

   public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}