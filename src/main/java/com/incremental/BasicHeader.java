package com.incremental;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author docker
 */
@Getter
@Setter
@Builder
public class BasicHeader {

    private String table;
    private String bizId;
}
