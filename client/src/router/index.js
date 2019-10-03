import Vue from 'vue';
import Router from 'vue-router';
import ProductManage from '@/components/ProductManage';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ProductManage',
      component: ProductManage
    }
  ]
});
