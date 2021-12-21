package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.connection.ConnectionPool;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.CategoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    CategoryService categoryService = new CategoryServiceImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testRetrieveCategoryBtId_ShouldReturnCategory_WhenDataIsCorrect() throws ServiceException {
        Optional<Category> actual = categoryService.retrieveCategoryById(2L);
        assertTrue(actual.isPresent());
    }

    @Test
    public void testRetrieveCategoryBtId_ShouldReturnNull_WhenDataIsNotCorrect() throws ServiceException {
        Optional<Category> actual = categoryService.retrieveCategoryById(5L);
        assertFalse(actual.isPresent());
    }

    @Test
    public void testRetrieveCategories_ShouldReturnCategories_WhenDataIsNotNull() throws ServiceException {
        List<Category> actual = categoryService.retrieveCategories();

        Category categoryFirst = new Category();
        categoryFirst.setId(1);
        categoryFirst.setCategoryName("Телефоны");

        Category categorySecond = new Category();
        categorySecond.setId(2);
        categorySecond.setCategoryName("Ноутбуки");

        Category categoryThree = new Category();
        categoryThree.setId(3);
        categoryThree.setCategoryName("Инструменты");

        List<Category> expected = new LinkedList<>();
        expected.add(categoryThree);
        expected.add(categorySecond);
        expected.add(categoryFirst);

        assertEquals(expected, actual);
    }
}