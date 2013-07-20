package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class NonTransactionalQuerydslJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new NonTransactionalQuerydslJpaRepositoryFactory<T, I>(entityManager);
	}

	private static class NonTransactionalQuerydslJpaRepositoryFactory<T, I extends Serializable> extends
			JpaRepositoryFactory {

		private EntityManager entityManager;

		public NonTransactionalQuerydslJpaRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
			return new NonTransactionalQuerydslJpaRepository<T, I>((JpaEntityInformation<T, I>) entityInformation,
					entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return NonTransactionalQuerydslJpaRepository.class;
		}
	}
}
