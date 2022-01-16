package com.hmf.server.utils.filter;

import com.hmf.server.service.IPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RelationFilterService {
    @Autowired
    private IPartsService iPartsService;


}
