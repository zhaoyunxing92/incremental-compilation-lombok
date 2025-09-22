package com.incremental.bootstrap.controller;

import com.incremental.bootstrap.annotations.ResponseBodyWrapperController;
import com.incremental.bootstrap.models.PayingActivityList;
import com.incremental.bootstrap.models.TableHeader;
import org.incremental.shared.BasicHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author docker
 */
@RestController
@RequestMapping("/table")
@ResponseBodyWrapperController
public class TableHeaderController {


    @RequestMapping("/header")
    public TableHeader getTableHeader(@RequestBody BasicHeader request) {
        TableHeader header = new TableHeader();
        header.setFields(List.of("id", "name", "age"));
        return header;
    }

    @RequestMapping("/activity")
    public String getPayingActivity(@RequestBody PayingActivityList request) {
        return "success";
    }
}
