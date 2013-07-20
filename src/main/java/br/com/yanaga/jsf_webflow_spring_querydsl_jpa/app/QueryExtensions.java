package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.support.Expressions;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Ops;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.BeanPath;

public class QueryExtensions{

    private QueryExtensions(){
    }

    @QueryDelegate(Razao.class)
    public static BooleanExpression containsIgnoreCase(BeanPath<Razao> razao,
                                                       String contained){
        Expression<String> constant = Expressions.constant(String.format("%%%s%%", contained));
        return Expressions.predicate(Ops.LIKE, razao, constant);
    }
}
