package com.len.util;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeUtil {
    /**级数*/
    private int layer;
    private String id;
    private String name;
    private String pId;
    /**是否开启 默认开启*/
    private boolean open=true;
    /**是否选择 checkbox状态可用 默认未选中*/
    private boolean checked=false;
    private List<TreeUtil> children=new ArrayList<>();


}
