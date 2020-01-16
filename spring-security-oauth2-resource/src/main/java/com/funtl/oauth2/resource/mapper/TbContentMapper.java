package com.funtl.oauth2.resource.mapper;

import com.funtl.oauth2.resource.domain.TbContent;
import tk.mybaits.mapper.MyMapper;

import java.util.List;

public interface TbContentMapper extends MyMapper<TbContent> {

    @Override
    List<TbContent> selectAll();
}