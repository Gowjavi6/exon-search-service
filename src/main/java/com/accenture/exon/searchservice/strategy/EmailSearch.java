package com.accenture.exon.searchservice.strategy;

import com.accenture.exon.searchservice.dto.EmployeeSearchDto;
import com.accenture.exon.searchservice.annotation.ExonHandlerStrategy;
import com.accenture.exon.searchservice.constants.Action;
import com.accenture.exon.searchservice.constants.ScopeType;
import com.accenture.exon.searchservice.handler.EmailSearchHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ExonHandlerStrategy(action = Action.EMAIL, order = 3,  scope = ScopeType.Handlers)
public class EmailSearch extends AbstractBaseStrategy<EmployeeSearchDto> {

    @Autowired
    EmailSearchHandler emailSearchHandler;

    @Override
    protected List<EmployeeSearchDto> getHandler(String value) {
        return emailSearchHandler.doSearch(value);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
