package by.epam.onlineShop.controller.command.impl;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.ProductService;
import by.epam.onlineShop.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ConfirmProductDeleteCommand implements Command {
    private static final String PAGE = "command=catalog";
    private static final String CATEGORY_PARAMETER = "&categoryId=";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String PRODUCT_ID = "productId";
    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        Optional<String> productId = Optional.ofNullable(requestContext.getRequestParameter(PRODUCT_ID));

        try {
            ProductService productService = ServiceFactory.getInstance().getProductService();
            long categoryId = 0;
            Optional<Product> product = productService.retrieveProductById(Long.parseLong(productId.get()));
            categoryId = product.get().getCategoryId();
            productService.removeProductById(Long.parseLong(productId.get()));

            if (product.isPresent()) {
                helper.updateRequest(requestContext);
                return new CommandResult(PAGE + CATEGORY_PARAMETER + categoryId, CommandResultType.REDIRECT);
            }
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }
    }
}
