package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.ProductDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    private static final String FIND_PRODUCTS_BY_CATEGORY_ID_QUERY = "SELECT * FROM " + Table.PRODUCT + " WHERE category_id=?";
    private static final String FIND_PRODUCT_BY_NAME_QUERY = "SELECT * FROM " + Table.PRODUCT + " WHERE name=?";
    private static final String FIND_PRODUCT_BY_COLOR_QUERY = "SELECT * FROM " + Table.PRODUCT + " WHERE color=?";
    private static final String FIND_PRODUCT_BY_SIZE_QUERY = "SELECT * FROM " + Table.PRODUCT + " WHERE productsize=?";
    private static final String SAVE_PRODUCT_QUERY = "INSERT INTO " + Table.PRODUCT +
            " (category_id, name, description, price, status, photo, orders_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE " + Table.PRODUCT + " SET category_id=?, " +
            "name=?, description=?, price=?, status=?, photo=? WHERE id=?";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM " + Table.PRODUCT + " WHERE id=?";

    public ProductDaoImpl() {
        super(RowMapperFactory.getInstance().getProductRowMapper(), Table.PRODUCT);
    }

    @Override
    public List<Product> findByCategory(long categoryId) throws DaoException {
        return executeQuery(FIND_PRODUCTS_BY_CATEGORY_ID_QUERY, categoryId);
    }

    @Override
    public Optional<Product> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_PRODUCT_BY_NAME_QUERY, name);
    }

    @Override
    public List<Product> findByColor(String color) throws DaoException {
        return executeQuery(FIND_PRODUCT_BY_COLOR_QUERY, color);
    }

    @Override
    public List<Product> findBySize(String productSize) throws DaoException {
        return executeQuery(FIND_PRODUCT_BY_SIZE_QUERY, productSize);
    }

    @Override
    public void updateById(long id, Product product) throws DaoException {
        executeUpdateQuery(UPDATE_PRODUCT_QUERY, product.getCategoryId(),
                product.getName(), product.getDescription(), product.getPrice(), product.isStatus(),
                product.getPhoto(), id);
    }

    @Override
    public void deleteById(long id) throws DaoException {
        executeDeleteQuery(DELETE_PRODUCT_QUERY, id);
    }


    @Override
    public long save(Product product) throws DaoException {
        return executeInsertQuery(SAVE_PRODUCT_QUERY, product.getCategoryId(), product.getName(), product.getDescription(),
                product.getPrice(), product.isStatus(), product.getPhoto(),
                product.getOrdersNumber());
    }
}
