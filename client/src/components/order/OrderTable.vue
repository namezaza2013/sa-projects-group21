<template>
  <!-- table -->
  <mdb-card class="purple-text my-table my-card">
    <mdb-card-header class="pt-4 grey lighten-4 my-card-top">
      <mdb-card-title>
        <strong>รายการออเดอร์ทั้งหมด</strong>
      </mdb-card-title>
    </mdb-card-header>
    <mdb-card-body>
      <template v-if="renderComponent">
        <mdb-tbl btn responsive striped>
          <mdb-tbl-head>
            <tr>
              <th style="width: 5%">ไอดี</th>
              <th style="width: 15%">เวลา</th>
              <th style="width: 10%">สถานะ</th>
              <th style="width: 20%">โต๊ะ</th>
              <th style="width: 30%">รายการอาหาร</th>
              <th style="width: 20%">หมายเหตุ</th>
            </tr>
          </mdb-tbl-head>
          <mdb-tbl-body>
            <tr v-for="(order,index) in orderTable" :key="index">
              <td>{{order.id}}</td>
              <td>{{order.date | formatDate }}</td>
              <td>{{order.orderStatus.name}}</td>
              <td>[{{order.tables.tableType.typeName}}]<br>{{order.tables.tablesName}}</td>
              <td>
                <div v-for="(menu,index) in order.menu" :key="index">{{menu.menuName}} x{{menu.units}}</div>
              </td>
              <td>{{order.desc}}</td>
            </tr>
          </mdb-tbl-body>
        </mdb-tbl>
      </template>
      <!-- table -->
    </mdb-card-body>
  </mdb-card>
</template>

<script>
import {
  mdbRow,
  mdbCol,
  mdbInput,
  mdbTextarea,
  mdbBtn,
  mdbCard,
  mdbCardHeader,
  mdbCardTitle,
  mdbCardFooter,
  mdbCardBody,
  mdbIcon,
  mdbContainer,
  mdbTbl,
  mdbTblHead,
  mdbTblBody,
  mdbModal,
  mdbModalHeader,
  mdbModalBody,
  mdbModalFooter
} from "mdbvue";

import moment from 'moment';

export default {
  name: "OrderTable",
  components: {
    mdbRow,
    mdbCol,
    mdbInput,
    mdbTextarea,
    mdbBtn,
    mdbCard,
    mdbCardBody,
    mdbCardHeader,
    mdbCardFooter,
    mdbCardTitle,
    mdbContainer,
    mdbIcon,
    mdbTbl,
    mdbTblHead,
    mdbTblBody,
    mdbModal,
    mdbModalHeader,
    mdbModalBody,
    mdbModalFooter
  },
  props:{
    orderList : Array,
    renderComponent : Boolean
  },
  data(){
    return (
      {
        orderTable: []
      }
    )
  },
  watch: { 
    orderList: function(){ 
      let orderT = [];
      this.orderList.forEach((order) => {
        // console.log("======1=====");
        // console.log(order);
        let menu = [];
        order.menuOrders.forEach((menuOrder)=>{
            let added = false;
            for(let i=0;i<menu.length;i++){
              if(menu[i].id == menuOrder.menu.id){
                menu[i].units += 1;
                added = true;
                break;
              }
            }
            if(!added){
              menu.push({id:menuOrder.menu.id,menuName:menuOrder.menu.menuName,units:1});
            }
        });
        orderT.push({...order,menu:{...menu}});
      });
      this.orderTable = orderT;
      // console.log("=====2======");
      // console.log(orderT);
    }
  },
  filters:{
    formatDate: function(value) {
      if (value) {
        return moment(String(value)).fromNow();
        //return moment(String(value)).format('MM/DD/YYYY hh:mm')
        //return moment(String(value),"from","now")
      }
    }
  }
};
</script>
<style scoped>
  .my-table{
    height: 100%;
  }
  .my-card{
    border-radius: 10px;
  }
  .my-card-top{
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
  }
  .my-card-bottom{
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
  }
</style>
