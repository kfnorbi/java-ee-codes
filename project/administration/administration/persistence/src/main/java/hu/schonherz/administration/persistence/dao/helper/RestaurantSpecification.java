package hu.schonherz.administration.persistence.dao.helper;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import hu.schonherz.administration.persistence.entities.Restaurant;
import hu.schonherz.administration.persistence.entities.Restaurant_;
import hu.schonherz.administration.persistence.entities.User;

public class RestaurantSpecification {

	public static Specification<Restaurant> isDeleted() {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isTrue(root.get(Restaurant_.isDeleted));
			}

		};

	}

	public static Specification<Restaurant> notDeleted() {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isFalse(root.get(Restaurant_.isDeleted));
			}

		};

	}

	public static Specification<Restaurant> addressLike(String name) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(Restaurant_.address), "%" + name + "%");
			}

		};

	}

	public static Specification<Restaurant> nameLike(String name) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(Restaurant_.name), "%" + name + "%");
			}

		};

	}

	public static Specification<Restaurant> phoneNumberLike(String number) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(Restaurant_.phoneNumber), "%" + number + "%");
			}

		};

	}

	public static Specification<Restaurant> nameEquals(String name) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(Restaurant_.name), name);
			}

		};
	}
	
	public static Specification<Restaurant> priceBetween(Integer price) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.get(Restaurant_.price), 0,price);
			}

		};
	}
	
	public static Specification<Restaurant> hasUser(User user) {
		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<List<User>> employees = root.get(Restaurant_.employees); 
				return cb.isMember(user, employees);
			}

		};
	}
}
