<template>
  <div class="bg">
    <EmployeeNavBar />
    <div class="pl-5 pr-5 container">
      <p class="py-4 text-center">
        <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
      </p>
      <h1>
        <mdb-badge color="default">PAY</mdb-badge> ชำระเงิน G21 Restaurent
      </h1>
      <br />
      <br />

      <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

      <!-- Button trigger modal -->
      <button type="button" class="btn btn-default" @click="showModelToggle()">PAY ORDER</button>

      <!-- Modal -->
      <mdb-modal :show="showModel" @close="resetPage()" class size="lg">
        <mdb-modal-header>
          <h4 class="modal-title" id="myModalLabel">PAY ORDER</h4>
        </mdb-modal-header>
        <mdb-modal-body>
          <div>
            <label for="order">Order</label>
          </div>
          <select
            v-model="payment.orderId"
            class="browser-default customer-select"
            style="width:450px;height:30px"
          >
            <option selected value="-1" disabled>--- กรุณาเลือก Order ---</option>
            <option v-for="order in orders" :key="order.id" :value="order.id">{{ order.name }}</option>
          </select>
          <br />
          <br />
          <div>
            <label for="pay">ช่องทางการชำระเงิน</label>
          </div>
          <select  v-model="payment.paymentWayId" class="browser-default customer-select" style="width:450px;height:30px">
            <option selected value="-1" disabled>--- กรุณาเลือกช่องทางการชำระเงิน ---</option>
            <option
              v-for="paymentWay in paymentWays" :key="paymentWay.id" :value="paymentWay.id">{{ paymentWay.name }}</option>
          </select>
          <br />
          <br />
          <div>
            <label for="employee">พนักงาน</label>
          </div>
          <select  v-model="payment.employeeId" class="browser-default customer-select" style="width:450px;height:30px">
            <option selected value="-1" disabled>--- กรุณาเลือกพนักงาน ---</option>
            <option
              v-for="employee in employees" :disabled="employee.id != employeeId" :key="employee.id"  :value="employee.id">{{ employee.name }}</option>
          </select>
          <br />
          <br />
        </mdb-modal-body>
        <mdb-modal-footer>
          <div class="center">
            <button type="button" class="btn btn-danger" @click="resetPage()">Close</button>
            <button type="button" class="btn btn-default" @click="savePayment">Submit</button>
          </div>
        </mdb-modal-footer>
      </mdb-modal>

      <br />
      <br />
      <br />

      <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

      <div>
        <mdb-tbl>
          <mdb-tbl-head>
            <tr>
              <th>#</th>
              <th>Order</th>
              <th>ชำระผ่านช่องทาง</th>
              <th>รับชำระโดย</th>
              <th>Date</th>
            </tr>
          </mdb-tbl-head>
          <mdb-tbl-body>
            <tr v-for="(payment,index) in payments" :key="index">
              <td>{{payment.id}}</td>
              <td>{{payment.order.name}}</td>
              <td>{{payment.paymentWay.name}}</td>
              <td>{{payment.createdBy.name}}</td>
              <td>{{payment.payDate}}</td>
            </tr> 
          </mdb-tbl-body>
        </mdb-tbl>
      </div>
      <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
    </div>

    <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
  </div>
</template>

<script>
import http from "../../http-common";
import EmployeeNavBar from "../EmployeeNavbar";

import {
  
  mdbNavbar,
  mdbNavbarBrand,
  mdbNavbarToggler,
  mdbNavbarNav,
  mdbNavItem,
  mdbDropdown,
  mdbDropdownMenu,
  mdbDropdownToggle,
  mdbInput,
  mdbDropdownItem,
  mdbFooter,
  mdbContainer,
  mdbRow,
  mdbCol,
  mdbCard,
  mdbCardTitle,
  mdbCardText,
  mdbBtn,
  mdbTbl,
  mdbTblHead,
  mdbTblBody,
  mdbAlert,
  mdbBadge,
  mdbModal,
  mdbModalBody,
  mdbModalHeader,
  mdbModalFooter
} from "mdbvue";
export default {
  name: "Payment",
  components: {
    EmployeeNavBar,
    mdbModal,
    mdbModalBody,
    mdbModalHeader,
    mdbModalFooter,

    mdbNavbar,
    mdbNavbarBrand,
    mdbNavbarToggler,
    mdbNavbarNav,
    mdbNavItem,
    mdbDropdown,
    mdbDropdownMenu,
    mdbDropdownToggle,
    mdbDropdownItem,
    mdbInput,
    mdbFooter,
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbCard,
    mdbCardTitle,
    mdbCardText,
    mdbBtn,
    mdbTbl,
    mdbTblHead,
    mdbTblBody,
    mdbAlert,
    mdbBadge
  },
  data() {
    return {
      payment: {
        orderId: "-1",
        employeeId: "-1",
        paymentWayId: "-1"
      },
      // update หลังจากได้ระบบ login แล้ว
      employeeId: 2,
      showModel: false,
      orders: {},
      paymentWays: {},
      employees: {},
      payments: {}
    };
  },
  updated() {
    console.log(this.payment);
    
  },
  created() {
    this.getOrders();
    this.getPaymentWays();
    this.getEmployees();
    this.getPayments();
  },
  methods: {
    showModelToggle: function() {
      console.log("btn click");
      this.showModel = !this.showModel;
    },
    // ดึงข้อมูล Order ใส่ combobox
    getOrders() {
      http
        .get("/order")
        .then(response => {
          this.orders = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล PaymentWay ใส่ combobox
    getPaymentWays() {
      http
        .get("/paymentWay")
        .then(response => {
          this.paymentWays = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Payments ใส่ table
    getPayments() {
      http
        .get("/payment")
        .then(response => {
          console.log(response.data);
          this.payments = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Employee ใส่ combobox
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employees = response.data;
          this.$nextTick();
        })
        .catch(e => {
          console.log(e);
        });
    },
    // save ข้อมูลลงในตาราง Payment
    savePayment() {
      //ทำต่อ
      let currentObj = this;
      if(this.payment.orderId == "-1" | this.payment.employeeId == "-1" | this.payment.paymentWayId == "-1"){
        alert("กรุณากรอกข้อมูลให้ครบ");
      }else{
        http
        .post(
          // แปลงจากพี่
          "/payment/" +
            this.payment.orderId +
            "/" +
            this.payment.paymentWayId +
            "/" +
            this.payment.employeeId
        )
        .then(function(response) {
          // <div v-if >
          // </div>
          console.log(response);
          alert("บันทึกสำเร็จ ขอบคุณครับ/ค่ะ");
          currentObj.resetPage();
          // currentObj.resetForm();
        })
        .catch(function(error) {
          alert("เกิดข้อผิดพลาด "+error);
          console.log(error);
        });
      }
      
    },
    // รีโหลดหน้าใหม่
    resetPage(){
      this.payment= {
        orderId: "-1",
        employeeId: "-1",
        paymentWayId: "-1"
      };
      this.showModel= false;
      this.getPayments();
    }
  }
};
</script>


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  text-align: center;
}
</style>

<style>
body,
html {
  height: 100%;
}
.bg {
  /* The image used */
  background-image: url("https://img.freepik.com/free-vector/blue-abstract-acrylic-brush-stroke-textured-background_53876-86373.jpg?size=626&ext=jpg");
  -webkit-background-size: cover;
  background-size: cover;
  width: 100vw;
  height: 100vh;
}
.center {
  margin: auto;
}
</style>
