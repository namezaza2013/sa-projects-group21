<template>
  <!-- table -->
  <mdb-card class="purple-text my-table my-card">
    <mdb-card-header class="pt-4 grey lighten-4 my-card-top">
      <mdb-card-title>
        <strong>รายการอาหารที่เลือก</strong>
      </mdb-card-title>
    </mdb-card-header>
    <mdb-card-body>
      <template v-if="renderComponent">
        <mdb-tbl btn responsive striped>
          <mdb-tbl-head>
            <tr>
              <th style="width: 10%">ไอดี</th>
              <th style="width: 40%">รายการอาหาร</th>
              <th style="width: 30%">ราคา</th>
              <th style="width: 10%">จำนวน</th>
              <th style="width: 10%">ลบ</th>
            </tr>
          </mdb-tbl-head>
          <mdb-tbl-body>
            <tr v-for="(menu,index) in menuSelected" :key="index">
              <td>{{menu.id}}</td>
              <td>{{menu.menuName}}</td>
              <td>{{menu.menuPrice}}</td>
              <td>{{menu.units}}</td>
              <td>
                <mdb-btn
                  @click="deleteMenuOrders(menu.id)"
                  color="danger"
                  class="btn-sm m-0"
                >ลบ</mdb-btn>
              </td>
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

export default {
  name: "MenuTable",
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
    menuSelected : Array,
    renderComponent : Boolean,
    deleteMenuOrders:  {type: Function}
  },
  data(){
    return (
      {
        
      }
    )
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
