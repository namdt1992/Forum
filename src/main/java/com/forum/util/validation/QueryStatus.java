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
public class QueryStatus <T extends AbstractEntity> extends Status {

    private Integer index;
    private Integer count;
    private List<T> data;
    private Object object;

    public QueryStatus() {
    }

    public QueryStatus(String code, String message) {
        super(code, message);
    }

    public QueryStatus(String code, String message, Integer index) {
        super(code, message);
        this.index = index;
    }

    public QueryStatus(String code, String message, Integer count, List<T> data) {
        super(code, message);
        this.count = count;
        this.data = data;
    }

    public QueryStatus(String code, String message, List<T> data) {
        super(code, message);
        this.data = data;
    }

    public QueryStatus(String code, String message, Integer count, Object object) {
        super(code, message);
        this.count = count;
        this.object = object;
    }

    public QueryStatus(String code, String message, Object object) {
        super(code, message);
        this.object = object;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
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