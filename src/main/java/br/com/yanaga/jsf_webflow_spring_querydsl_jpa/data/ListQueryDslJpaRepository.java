package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import java.util.List;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ListQueryDslJpaRepository<T> extends QueryDslPredicateExecutor<T>{

    @Override
    public List<T> findAll(Predicate prdct);

    @Override
    public List<T> findAll(Predicate prdct,
                           OrderSpecifier<?>[] oss);
}
