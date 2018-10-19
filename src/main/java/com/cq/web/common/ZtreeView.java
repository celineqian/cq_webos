package com.cq.web.common;

import java.io.Serializable;

/**
 * Created by Celine on 02/07/2017.
 */
public class ZtreeView implements Serializable {

    private static final long serialVersionUID = -8966447255248629258L;


    /**
     * ID
     */
    private Long id;

    /**
     * 编号
     */
    private Long pId;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否展开 true:展开; false:合并
     */
    private boolean open;

    /**
     * 是否勾选 true:勾选; false:不勾选
     */
    private boolean checked = false;

    public ZtreeView() {
    }


    public ZtreeView(Long id, Long pId, String name, boolean open) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
