package org.incremental.shared;

import lombok.Data;

@Data
public class PageBase {

    /**
     * 当前起止页
     */
    private int page = 1;

    /**
     * 每页大小默认30
     */
    private int pageSize = 30;
}
