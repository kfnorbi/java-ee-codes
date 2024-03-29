package hu.schonherz.restaurant.service.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.schonherz.restaurant.dao.ProductDao;
import hu.schonherz.restaurant.service.ProductConverter;
import hu.schonherz.restaurant.service.ProductServiceLocal;
import hu.schonherz.restaurant.service.ProductServiceRemote;
import hu.schonherz.restaurant.service.vo.ProductVo;

/**
 * Created by tothd on 2015. 12. 21..
 */
@Stateless(mappedName = "ProductService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Local(ProductServiceLocal.class)
@Remote(ProductServiceRemote.class)
public class ProductServiceImpl implements ProductServiceLocal, ProductServiceRemote {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductVo> getProducts() {
		return ProductConverter.toVo(productDao.findAll());
	}

	@Override
	public ProductVo getProductById(Long id) {
		Validate.notNull(id);
		return ProductConverter.toVo(productDao.findOne(id));
	}

	@Override
	public ProductVo saveProduct(ProductVo productVo) {
		Validate.notNull(productVo);
		return ProductConverter.toVo(productDao.save(ProductConverter.toEntity(productVo)));
	}

	@Override
	public List<ProductVo> getProductsByRestaurantId(Long id) {
		Validate.notNull(id);
		return ProductConverter.toVo(productDao.findByRestaurantId(id));
	}

	@Override
	public ProductVo getProductByNameAndRestaurantId(String name, Long id) {
		Validate.notNull(name);
		Validate.notNull(id);
		return ProductConverter.toVo(productDao.findByNameAndRestaurantId(name, id));
	}

	@Override
	public List<ProductVo> getProductsByNameStartingWithAndRestaurantId(String query, Long id) {
		Validate.notNull(query);
		Validate.notNull(id);
		return ProductConverter.toVo(productDao.findByNameStartingWithAndRestaurantId(query, id));
	}

}
