package mate.academy.service.impl;

import mate.academy.dao.impl.OrderDaoImpl;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Order;
import mate.academy.model.ShoppingCart;
import mate.academy.model.Ticket;
import mate.academy.model.User;
import mate.academy.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDaoImpl orderDao;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        User user = shoppingCart.getUser();
        List<Ticket> tickets = shoppingCart.getTickets();
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setUser(user);
        order.setTickets(tickets);
        order.setOrderDate(now);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}
