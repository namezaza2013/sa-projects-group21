import Vue from 'vue';
import Router from 'vue-router';
import EmployeeUI from '../components/employee/EmployeeUI.vue';
import GetReviewUI from '../components/review/GetReviewUI.vue';
import LoginEmployeeUI from '../components/login/LoginEmployeeUI.vue';
import LoginOwnerUI from '../components/login/LoginOwnerUI.vue';
import RecieveOrderUI from '../components/order/RecieveOrderUI.vue';
import TablesUI from '../components/tables/TablesUI.vue';
import MainMenuUI from '../components/main/mainMenuUI.vue';
import EmployeeMenuUI from '../components/main/EmployeeMenuUI.vue';
import PaymentUI from '../components/payment/PaymentUI.vue';
import MenuDesignUI from '../components/menuDesign/MenuDesign.vue';
import MenuUI from '../components/menu/MenuUI.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainMenu',
      component: MainMenuUI
    },
    {
      path: '/EmployeeMenu',
      name: 'EmployeeMenu',
      component: EmployeeMenuUI
    },
    {
      path: '/Menu',
      name: 'Menu',
      component: MenuUI
    },
    {
      path: '/MenuDesign',
      name: 'MenuDesign',
      component: MenuDesignUI
    },
    {
      path: '/Employee',
      name: 'Employee',
      component: EmployeeUI
    },
    {
      path: '/Payment',
      name: 'Payment',
      component: PaymentUI
    },
    {
      path: '/Review',
      name: 'Review',
      component: GetReviewUI
    },
    {
      path: '/Tables',
      name: 'Tables',
      component: TablesUI
    },
    {
      path: '/Order',
      name: 'Order',
      component: RecieveOrderUI
    },
    {
      path: '/LoginEmployee',
      name: 'LoginEmployee',
      component: LoginEmployeeUI
    },
    {
      path: '/LoginOwner',
      name: 'LoginOwner',
      component: LoginOwnerUI
    }
  ]
});
