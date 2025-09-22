package com.incremental.bootstrap.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.incremental.shared.PageBase;

@Data
@EqualsAndHashCode(callSuper = true)
public class PayingActivityList extends PageBase {

    private String keyword;
}
