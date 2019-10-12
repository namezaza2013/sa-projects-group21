<template>
  <div class="my-bg">
    <EmployeeNavBar />
    <div style="padding-top:80px;padding-bottom:50px;"  >
      <mdb-container class="my-content2 my-border">

        <br />
        <br />

        <!-- header -->
        <mdb-row class="my-content">
          <mdb-col></mdb-col>
          <mdb-col>
            <h2>ระบบจัดการรายการอาหาร</h2>
          </mdb-col>
          <mdb-col></mdb-col>
        </mdb-row>
        <!-- header -->

        <br />
        <br />

        <!-- input with combobox -->
        <mdb-row>
          <mdb-col>
            <div>
              <select 
                v-model="menu.menuType"
                class="browser-default custom-select custom-select-lg mb-3"  
              >
                <option value="-1" disabled selected>เลือกประเภทรายการอาหาร</option>
                <option 
                  v-for="mt in menuType" 
                  :key="mt.id" 
                  :value="mt.id"
                >{{mt.typeName}}</option>
              </select>
            </div>
          </mdb-col>

          <mdb-col>
            <div>
              <select
                v-model="menu.appropriateId"
                class="browser-default custom-select custom-select-lg mb-3"
              >
                <option value="-1" disabled selected>เหมาะสำหรับ</option>
                <option
                  v-for="(value,index) in appropriate"
                  :key="index"
                  :value="value.id"
                >{{value.appropriationName}}</option>
              </select>
            </div>
          </mdb-col>

          <mdb-col>
            <div>
              <select
                v-model="menu.nationId"
                class="browser-default custom-select custom-select-lg mb-3"
              >
                <option value="-1" disabled selected>สัญชาติอาหาร</option>
                <option
                  v-for="(value,index) in nation"
                  :key="index"
                  :value="value.id"
                >{{value.nationName}}</option>
              </select>
            </div>
          </mdb-col>
        </mdb-row>
        <!-- input with combobox -->

        <!-- input with textbox -->
        <mdb-input
          type="text" 
          v-model="menu.menuName" 
          size="lg" 
          label="ชื่อรายการอาหาร" 
          outline 
        />
        <mdb-input 
          type="text" 
          v-model="menu.menuPrice" 
          size="lg" 
          label="ราคา(บาท)" 
          outline 
          />
        <mdb-input
          type="text"
          v-model="menu.menuUnits"
          size="lg"
          label="จำนวน(เมนู/ชิ้น/ขวด)"
          outline
        />
        <!-- input with textbox -->

        <!-- add bt -->
        <mdb-row>
          <mdb-col>
            <br/>
            <mdb-btn block color="secondary" @click="saveMenu">เพิ่มรายการอาหาร</mdb-btn>
            <br/>
          </mdb-col>
        </mdb-row>
        <!-- add bt -->

        <hr />

        <!-- showing data -->
        <mdb-row>
          <mdb-col>
            <br/>
            <mdb-tbl>
              <mdb-tbl-head class="my-tableheader" color="secondary" textBlack>
                <tr>
                  <th>ชื่อรายการอาหาร</th>
                  <th>ประเภทรายการอาหาร</th>
                  <th>ราคา(บาท)</th>
                  <th>จำนวน(เมนู/ชิ้น/ขวด)</th>
                  <th>เหมาะสำหรับ</th>
                  <th>สัญชาติอาหาร</th>
                </tr>
              </mdb-tbl-head>
              <mdb-tbl-body class="my-table">
                <tr v-for="(m,index) in menus" :key="index">
                  <th>{{m.menuName}}</th>
                  <td>{{m.menuTypeID.typeName}}</td>
                  <td>{{m.menuPrice}}</td>
                  <td>{{m.menuUnits}}</td>
                  <td>{{m.appropriateID.appropriationName}}</td>
                  <td>{{m.nationID.nationName}}</td>
                </tr>
              </mdb-tbl-body>
            </mdb-tbl>
          </mdb-col>
        </mdb-row>
        <!-- showing data -->

        <br/>
        <br/>

      </mdb-container>
    </div>
  </div>
</template>

<script>
import http from "../../http-common";
import EmployeeNavBar from "../EmployeeNavbar";

import {
  mdbCol,
  mdbListGroup,
  mdbListGroupItem,
  mdbBtnGroup,
  mdbRow,
  mdbContainer,
  mdbDropdown,
  mdbDropdownItem,
  mdbDropdownMenu,
  mdbDropdownToggle,
  mdbBtn,
  mdbInput,
  mdbDatatable,
  mdbTbl,
  mdbTblHead,
  mdbTblBody
} from "mdbvue";

export default {
  name: "MenuUI",
  components: {
    EmployeeNavBar,
    mdbCol,
    mdbListGroup,
    mdbListGroupItem,
    mdbBtnGroup,
    mdbRow,
    mdbContainer,
    mdbDropdown,
    mdbDropdownItem,
    mdbDropdownMenu,
    mdbDropdownToggle,
    mdbBtn,
    mdbInput,
    mdbDatatable,
    mdbTbl,
    mdbTblHead,
    mdbTblBody
  },
  data() {
    return {
      menuType: [],
      appropriate: [],
      nation: [],
      menus: [],
      menu: {
        menuType: "-1",
        appropriateId: "-1",
        nationId: "-1",
        menuName: "",
        menuPrice: "",
        menuUnits: "",
      }
    };
  },

  updated() {
    //console.log(menuType);
  },

  methods: {

    //ดึงข้อทูล menuType ใส่ combobox
    getMenuType() {
      let currentObj = this;
      http
        .get("/menuType")
        .then(res => (this.menuType = res.data))
        .catch(err => console.log(err));
    },

    //ดึงข้อทูล appropriate ใส่ combobox
    getAppropriate() {
      http
        .get("/appropriate")
        .then(res => (this.appropriate = res.data))
        .catch(err => console.log(err));
    },

    //ดึงข้อทูล netion ใส่ combobox
    getNation() {
      http
        .get("/nation")
        .then(res => (this.nation = res.data))
        .catch(err => console.log(err));
    },

    //ดึงข้อทูล menu ใส่ ตาราง
    getMenu() {
      http
        .get("/menu")
        .then(res => (this.menus = res.data))
        .catch(err => console.log(err));
    },

    //บันทึกหลังจากกรอกข้อมูลสำเร็จ
    saveMenu() {
      let currentObj = this;
      http
        .post("/menu", {
          menuName: this.menu.menuName,
          menuPrice: this.menu.menuPrice,
          menuUnits: this.menu.menuUnits,
          menuTypeId: this.menu.menuType,
          nationId: this.menu.nationId,
          appropriateId: this.menu.appropriateId
        })
        .then((response) => {
          alert("บันทึกสำเร็จ");
          this.getMenu();
          this.resetForm();
          console.log(currentObj);
        })
        .catch(function(error) {
          alert("เกิดข้อผิดพลาด " + error);
        });
    },

    resetForm(){
      this.menu = {
        menuType: "-1",
        appropriateId: "-1",
        nationId: "-1",
        menuName: "",
        menuPrice: "",
        menuUnits: "",
      }
    }
    
  },
  created() {
    this.getMenuType();
    this.getAppropriate();
    this.getNation();
    this.getMenu();
  }
};
</script>

<style scoped>
.my-bg {
  background: url("https://www.athenaspahotel.com/media/cache/jadro_resize/rc/uJmoXtmd1563349268/jadroRoot/medias/_a1a8429.jpg") no-repeat center center;
  min-height: 100vh;
  height: 100%;
  margin: 0px;
  background-size: cover;
  background-attachment: fixed;
}
.my-content{
  background-color: rgba(210, 128, 253, 0.9)
}
.my-content2{
  background-color: rgba(255, 255, 255, 0.721)
}
.my-table{
  background-color:rgba(214, 175, 139, 0.699);
}
.my-tableheader{
  background-color:rgb(214, 175, 139);
}
.my-border{
  border-radius: 10px;
}
</style>