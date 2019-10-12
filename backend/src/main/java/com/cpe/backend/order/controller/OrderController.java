package com.cpe.backend.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.cpe.backend.tables.entity.Tables;
import com.cpe.backend.order.model.BodyOrder;
import com.cpe.backend.order.entity.Order;
import com.cpe.backend.menu.entity.Menu;
import com.cpe.backend.order.entity.MenuOrder;
import com.cpe.backend.order.entity.OrderStatus;
import com.cpe.backend.menu.repository.MenuRepository;
import com.cpe.backend.order.repository.MenuOrderRepository;
import com.cpe.backend.order.repository.OrderRepository;
import com.cpe.backend.tables.repository.TablesRepository;
import com.cpe.backend.tables.repository.TableTypeRepository;
import com.cpe.backend.order.repository.OrderStatusRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OrderController {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuOrderRepository menuOrderRepository;
    @Autowired
    private TablesRepository tablesRepository;
    @Autowired
    private TableTypeRepository tableTypeRepository;

    OrderController(OrderRepository orderRepository,MenuRepository menuRepository,MenuOrderRepository menuOrderRepository,TablesRepository tablesRepository,TableTypeRepository tableTypeRepository,OrderStatusRepository orderStatusRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.menuOrderRepository = menuOrderRepository; 
        this.tablesRepository = tablesRepository;
        this.tableTypeRepository = tableTypeRepository;
        this.orderStatusRepository = orderStatusRepository;
    }

    @GetMapping("/order")
    public Collection<Order> OrderList() {
        return orderRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/order")
    public Order index(@RequestBody BodyOrder bodyOrder) {
        //Collection<MenuOrder> menuOrders = null;
        Collection<MenuOrder> menuOrders = new ArrayList<MenuOrder>();
        for(Long menuId : bodyOrder.getMenuId()){
            MenuOrder menuOrder = new MenuOrder(); 
            Menu m = menuRepository.findById(menuId).get();
            //menuOrder.setOrder(newOrders);
            menuOrder.setMenu(m);
            menuOrders.add(menuOrderRepository.save(menuOrder));
        }

        Order newOrders = new Order();
        Tables table = tablesRepository.findById(bodyOrder.getTablesId()).get();
        OrderStatus orderStatus = orderStatusRepository.findById(bodyOrder.getOrderStatusId()).get();
        newOrders.setTables(table);
        newOrders.setOrderStatus(orderStatus);
        for(MenuOrder menuOrder : menuOrders){
            System.out.println("==================");
            System.out.println("addMenuOrder = "+menuOrder.getId());
            newOrders.addMenuOrder(menuOrder);
        }
        newOrders.setDesc(bodyOrder.getDesc());
        newOrders.setDate(new Date());

        return orderRepository.save(newOrders);
    }
    
}