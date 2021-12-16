package by.epam.onlineShop.controller.command.impl.transition;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.CategoryService;
import by.epam.onlineShop.service.ProductService;
import by.epam.onlineShop.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GoToCatalogCommand implements Command {
    private static final String PAGE = "WEB-INF/view/catalog.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CATEGORY_ID = "categoryId";
    private static final String CATEGORIES = "categories";
    private static final String PRODUCTS = "products";
    private static final String COLOR = "colorName";
    private static final String SIZE = "productSize";
    private static final String COLORS = "colors";
    private static final String SIZES = "sizes";
    private static final String PRODUCTS_BY_COLOR = "colorProducts";
    private static final String PRODUCTS_BY_SIZE = "sizeProducts";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            CategoryService categoryService = ServiceFactory.getInstance().getCategoryService();

            List<Category> categories = categoryService.retrieveCategories();
            requestContext.addRequestAttribute(CATEGORIES, categories);

            long categoryId = Long.parseLong(requestContext.getRequestParameter(CATEGORY_ID));

            //String colorName = requestContext.getRequestParameter(COLOR);
            //String productSize = requestContext.getRequestParameter(SIZE);


            ProductService productService = ServiceFactory.getInstance().getProductService();

            List<Product> products = productService.retrieveProductsByCategory(categoryId);

            List<String> colors = categoryService.retrieveProductsColorsInCategory(products);
            //List<String> sizes = categoryService.retrieveProductsSizesInCategory(products);

            requestContext.addRequestAttribute(COLORS, colors);
            /*
            requestContext.addRequestAttribute(SIZES, sizes);

            List<Product> colorProducts = productService.retrieveProductsByColor(colorName);
            List<Product> sizeProducts = productService.retrieveProductsBySize(productSize);

            requestContext.addRequestAttribute(PRODUCTS_BY_COLOR, colorProducts);
            requestContext.addRequestAttribute(PRODUCTS_BY_SIZE, sizeProducts);

             */
            requestContext.addRequestAttribute(PRODUCTS, products);


        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
