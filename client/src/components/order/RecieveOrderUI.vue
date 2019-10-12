<template>
  <div>
    <EmployeeNavbar/>
    <div id="orderUI" class="my-bg">
      <h1 class="header-text header-bg">RECIEVE ORDER</h1>
      <div class="pt-3 pb-4 justify-content-center container mx-auto">
        <mdb-row >
          <mdb-col>
            <mdb-card class="purple-text my-card">
              <mdb-card-header class="pt-4 grey lighten-4 my-card-top">
                <mdb-card-title>
                  <strong>กรอกรายการออร์เดอร์</strong>
                </mdb-card-title>
              </mdb-card-header>
              <mdb-card-body>
                <mdb-row class="mb-4 pb-3">
                  <mdb-col>
                    <div class="d-flex flex-row form-group">
                      <mdb-icon class="fas fa-table mt-2 mr-3 mb-2" size="lg"></mdb-icon>
                      <select
                        v-model="orders.tableTypeId"
                        @change="filterTables($event)"
                        class="browser-default custom-select"
                      >
                        <option selected disabled value="0">เลือกประเภทโต๊ะ</option>
                        <option
                          v-for="tableType in tableTypes"
                          :key="tableType.id"
                          :value="tableType.id"
                        >{{ tableType.typeName }}</option>
                      </select>
                    </div>
                    <div class="d-flex flex-row form-group">
                      <mdb-icon icon="user" class="mt-2 mr-3 mb-2" size="lg"></mdb-icon>
                      <template>
                        <select
                          v-model="orders.tableId"
                          @change="onTableIdChanged($event)"
                          :disabled="orders.tableTypeId == '0'"
                          class="browser-default custom-select"
                        >
                          <option selected value="0" disabled>หมายเลขโต๊ะ</option>
                          <option
                            v-for="table in tables"
                            :key="table.id"
                            :value="table.id"
                          >{{ table.tablesName }}</option>
                        </select>
                      </template>
                    </div>
                    <div class="d-flex flex-row form-group">
                      <mdb-icon icon="spinner" class="mt-2 mr-3 mb-2" size="lg"></mdb-icon>
                      <template>
                        <select v-model="orders.orderStatusId" class="browser-default custom-select">
                          <option selected value="0" disabled>สถานะ</option>
                          <option
                            v-for="status in orderStatus"
                            :key="status.id"
                            :value="status.id"
                          >{{status.name}}</option>
                        </select>
                      </template>
                    </div>
                    <mdb-input
                      type="textarea"
                      outline
                      :rows="4"
                      v-model="orders.desc"
                      label="รายละเอียดเพิ่มเติม"
                      icon="comment"
                    />
                  </mdb-col>
                </mdb-row>
              </mdb-card-body>
              <mdb-card-footer class="d-flex grey lighten-4 justify-content-end my-card-bottom">
                <mdb-btn color="default" class @click="cart = true">เพิ่มรายการอาหาร</mdb-btn>
                <mdb-btn
                  v-if="orders.menuOrders.length != 0"
                  @click="orderSubmit($event)"
                  outline="purple"
                  icon="paper-plane"
                >ยืนยันออร์เดอร์</mdb-btn>
              </mdb-card-footer>
            </mdb-card>
          </mdb-col>
          <mdb-col class="col-6">
            <MenuTable
              :menuSelected="menuSelected"
              :renderComponent="renderComponent"
              :deleteMenuOrders="deleteMenuOrders"
            />
          </mdb-col>
        </mdb-row>
        <div class="hr"/>
        <OrderTable
          :orderList="orderList"
          :renderComponent="renderComponent"
        />
      </div>
    </div>
    
    <!-- modal -->
      <mdb-modal :show="cart" @close="cart = false" class size="lg">
        <mdb-modal-header>
          <h4 class="modal-title" id="myModalLabel">กรุณาเลือกเมนู</h4>
        </mdb-modal-header>
        <mdb-modal-body>
          <mdb-row>
            <mdb-col col="4">
              <div v-for="menuList in menuLists" :key="menuList.id">
                <mdb-btn
                  @click="onMenuListClick(menuList)"
                  class="btn-menu"
                  color="primary"
                >{{menuList.menuName}} ราคา {{menuList.menuPrice}} บาท</mdb-btn>
              </div>
            </mdb-col>
            <mdb-col>
              <MenuTable
                :menuSelected="menuSelected"
                :renderComponent="renderComponent"
                :deleteMenuOrders="deleteMenuOrders"
              />
            </mdb-col>
          </mdb-row>
        </mdb-modal-body>
        <mdb-modal-footer>
          <mdb-btn color="primary" @click="cart = false">ยืนยัน</mdb-btn>
        </mdb-modal-footer>
      </mdb-modal>
      <!-- modal ended -->
  </div>
</template>

<script>
import http from "../../http-common";
import EmployeeNavbar from "../EmployeeNavbar";
import MenuTable from "./MenuTable";
import OrderTable from "./OrderTable";
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
  name: "RecieveOrderUI",
  components: {
    OrderTable,
    MenuTable,
    EmployeeNavbar,
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
  data() {
    return {
      orders: {
        tableTypeId: "0",
        tableId: "0",
        orderStatusId: "0",
        desc: "",
        menuOrders: []
      },
      orderList:[],
      menuSelected: [],
      tableTypes: [],
      orderStatus: [],
      tablesAll: [],
      tables: [],
      menuLists: {},
      cart: false,
      renderComponent: true,
      canDeleteMenuOrder: true
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    getTableTypes() {
      http
        .get("/tableType")
        .then(response => {
          this.tableTypes = response.data;
          this.$nextTick();
          //console.log(this.tableTypes);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getOrderStatus() {
      http
        .get("/orderStatus")
        .then(response => {
          this.orderStatus = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    getMenuLists() {
      http
        .get("/menu")
        .then(response => {
          this.menuLists = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    getTables() {
      http
        .get("/tables")
        .then(response => {
          this.tables = response.data;
          this.tablesAll = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    getOrders() {
      http
        .get("/order")
        .then(response => {
          this.orderList = response.data;
          console.log("orders loaded");
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    filterTables(event) {
      this.orders.tableTypeId = event.target.value;
      this.tables = {
        ...this.tablesAll.filter(({ tableType }) => {
          return tableType.id == event.target.value;
        })
      };
    },
    onTableIdChanged(event) {
      this.orders.tableId = event.target.value;
      console.log("Updated Orders");
      console.log(this.orders);
    },
    //on click to add menu
    onMenuListClick(order) {
      if (this.orders.menuOrders == undefined) {
        this.orders.menuOrders = [order];
      } else {
        this.orders.menuOrders = [...this.orders.menuOrders, order];
        this.addMenuTable(order);
      }
      this.forceRerender();
      console.log("Add menu orders " + order.id + " " + order.name);
    },
    //Menu That show on table
    addMenuTable(order){
      let added = false;
      let temp = this.menuSelected;
      for(let i= 0;i<temp.length;i++){
        if(temp[i].id == order.id){
          temp[i].units += 1;
          added = true;
        }
      }
      if(!added){
        this.menuSelected = [...this.menuSelected,{...order,units:1}];
      }else{
        this.menuSelected = temp;
      }
    },
    //Menu That show on table
    deleteMenuTable(index){
      let temp = this.menuSelected;
      for(let i= 0;i<temp.length;i++){
        if(temp[i].id == index){
          temp[i].units -= 1;
          if(temp[i].units < 1){
            temp = temp.filter((temp)=>temp.units < 1 ? false : true);
          }
          break;
        }
      }
      this.menuSelected = temp;
    },
    forceRerender() {
      // Remove my-component from the DOM
      this.renderComponent = false;
      this.$nextTick(() => {
        // Add the component back in
        this.renderComponent = true;
      });
    },
    deleteMenuOrders(index) {
      this.deleteMenuTable(index);
      this.orders.menuOrders = [
        ...this.orders.menuOrders.filter(menuOrder => {
          if (this.canDeleteMenuOrder) {
            let isSame = menuOrder.id == index;
            if (isSame) {
              this.canDeleteMenuOrder = false;
              return false;
            }
            return true;
          } else {
            return true;
          }
        })
      ];
      this.canDeleteMenuOrder = true;
      this.forceRerender();
    },
    orderSubmit(e) {
      let currentObj = this;
      let i = 0;
      let menuArr = [];
      this.orders.menuOrders.forEach(menu => {
        menuArr.push(menu.id);
        console.log("push " + menu.id);
      });
      http
        .post("/order", {
          tablesId: this.orders.tableId,
          desc: this.orders.desc,
          menuId: menuArr,
          orderStatusId: this.orders.orderStatusId
        })
        .then(function(response) {
          alert("เพิ่มออร์เดอร์ สำเร็จ");
          currentObj.output = response.data;
          console.log(currentObj);
          currentObj.resetForm();
          currentObj.getOrders();
        })
        .catch(function(error) {
          alert("เกิดข้อผิดพลาด " + error);
          currentObj.output = error;
        });
    },
    resetForm() {
      this.orders = {
        tableTypeId: "0",
        tableId: "0",
        orderStatusId: "0",
        desc: "",
        menuOrders: []
      };
      this.menuSelected = [];
    }

    /* eslint-disable no-console */
  },
  updated() {
    console.log("Updated");
    //console.log(this.orders);
  },
  mounted() {
    this.getTableTypes();
    this.getMenuLists();
    this.getTables();
    this.getOrders();
    this.getOrderStatus();
  }
};
</script>

<style scoped>
  #orderUI {
    padding-top: 63px;
    background: url("https://www.athenaspahotel.com/media/cache/jadro_resize/rc/uJmoXtmd1563349268/jadroRoot/medias/_a1a8429.jpg") no-repeat center center;
    min-height: 100vh;
    height: 100%;
    margin: 0px;
    background-size: cover;
    background-attachment: fixed;
  }
  .btn-menu {
    width: 100%;
  }
  .header-text{
    text-align: center;
    color: white;
  }
  .header-bg{
      color:black;
      background-color: rgba(255, 255, 255, 0.8);
      width: 100%;
    }
  .hr{
    width: 100%;
    margin-top: 10px;
    margin-bottom: 5px;
    border-radius: 10px;
    background-color: white;
    height: 10px;
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