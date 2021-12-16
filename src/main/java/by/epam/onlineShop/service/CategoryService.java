package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     * Method to retrieve categories
     *
     * @return List of categories
     * @throws ServiceException
     */
    List<Category> retrieveCategories() throws ServiceException;

    /**
     * Method to retrieve category by ID
     *
     * @param categoryId ID of category to retrieve
     * @return optional of Category
     * @throws ServiceException
     */
    Optional<Category> retrieveCategoryById(long categoryId) throws ServiceException;

    /**
     * Method to retrieve products by color
     *
     * @param products of products to retrieve
     * @return List of Product
     * @throws ServiceException
     */
    List<String> retrieveProductsColorsInCategory(List<Product> products) throws ServiceException;

    /**
     * Method to retrieve products by color
     *
     * @param products of products to retrieve
     * @return List of Product
     * @throws ServiceException
     */
    List<String> retrieveProductsSizesInCategory(List<Product> products) throws ServiceException;
}
