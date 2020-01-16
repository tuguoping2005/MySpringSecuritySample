package com.funtl.oauth2.resource.controller;


import com.funtl.oauth2.resource.domain.TbContent;
import com.funtl.oauth2.resource.dto.ResponseResult;
import com.funtl.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TBContentController {

    @Autowired
    TbContentService tbContentService;

    @GetMapping("/")
    public ResponseResult<List<TbContent>> getAll(){
        return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),tbContentService.selectAll());
    }


}
