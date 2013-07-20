package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NonTransactionalQuerydslJpaRepository<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID> {

	public NonTransactionalQuerydslJpaRepository(JpaEntityInformation<T, ID> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(ID id) {
		super.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(T entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Iterable<? extends T> entities) {
		super.delete(entities);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteInBatch(Iterable<T> entities) {
		super.deleteInBatch(entities);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteAll() {
		super.deleteAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteAllInBatch() {
		super.deleteAllInBatch();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public <S extends T> S save(S entity) {
		return super.save(entity);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public T saveAndFlush(T entity) {
		return super.saveAndFlush(entity);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public <S extends T> List<S> save(Iterable<S> entities) {
		return super.save(entities);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void flush() {
		super.flush();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T findOne(Predicate predicate) {
		return super.findOne(predicate);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Predicate predicate) {
		return super.findAll(predicate);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
		return super.findAll(predicate, orders);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<T> findAll(Predicate predicate, Pageable pageable) {
		return super.findAll(predicate, pageable);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long count(Predicate predicate) {
		return super.count(predicate);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T findOne(ID id) {
		return super.findOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean exists(ID id) {
		return super.exists(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Iterable<ID> ids) {
		return super.findAll(ids);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Sort sort) {
		return super.findAll(sort);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<T> findAll(Pageable pageable) {
		return super.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T findOne(Specification<T> spec) {
		return super.findOne(spec);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Specification<T> spec) {
		return super.findAll(spec);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return super.findAll(spec, pageable);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> findAll(Specification<T> spec, Sort sort) {
		return super.findAll(spec, sort);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long count() {
		return super.count();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long count(Specification<T> spec) {
		return super.count(spec);
	}

}
