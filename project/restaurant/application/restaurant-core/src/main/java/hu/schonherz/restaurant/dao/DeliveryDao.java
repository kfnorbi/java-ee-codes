package hu.schonherz.restaurant.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hu.schonherz.restaurant.entities.Delivery;

/**
 * Created by tothd on 2015. 12. 16..
 */
@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Long> {

	Page<Delivery> findByCourierContaining(String filter, Pageable pageable);

	Delivery findByGlobalId(Long globalId);

	Page<Delivery> findByRestaurantIdAndIsDeletedFalse(Long restId, Pageable pageable);

	long countByRestaurantIdAndIsDeletedFalse(Long restId);

	@Modifying
	@Query("update Delivery d set d.isDeleted=true where d.id=?1")
	void setIsDeletedById(Long id);

	@Query("SELECT d from Delivery d WHERE d.synced IS NULL AND (d.globalId IS NOT NULL OR d.isDeleted=0)")
	List<Delivery> findNotSynced();

}
