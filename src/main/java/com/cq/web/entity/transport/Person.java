package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;

/**
 * @Author Celine Q
 * @Create 29/10/2018 3:00 PM
 **/
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends BaseEntity {

}
