/**
 * 
 */
package com.forum.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * @author nam
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
}
