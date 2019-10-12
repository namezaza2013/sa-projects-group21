<template>
  <div class="bg" style="padding-bottom: 30ch">
    <EmployeeNavBar/>
    <!-- Modal start -->
    <template>
      <div >
        <mdb-modal :show="openForm" @close="openForm = false">
          <mdb-modal-header>
            <mdb-modal-title>ออกแบบเมนู</mdb-modal-title>
          </mdb-modal-header>
          <mdb-modal-body>
            <label for="defaultFormNameModalEx">รายการอาหาร</label>
            <select 
            class="browser-default custom-select" v-model="design.menu">
              <option value="" disabled selected>เลือกรายการอาหาร</option>
              <option v-for="menuList in menu" :key="menuList.id" :value="menuList.id">{{menuList.menuName}}</option>
            </select>
            <br />
            <label for="defaultFormNameModalEx">รูปภาพ</label>
            <div class="row">
              <!-- Grid column -->
              <div class="col">
                <!-- Default input -->
                <select class="browser-default custom-select" v-model="design.foodImage">
                  <option value="" disabled selected>เลือกชื่อรูปภาพ</option>
                  <option
                    v-for="image in foodImage"
                    :key="image.id"
                    :value="image.id"
                  >{{image.nameImage}}</option>
                </select>
              </div>
              <div class="col">
                <button @click="()=>onShowInsertURL(this)" class="btn btn-primary btn-sm">
                  <i class="fas fa-magic mr-1"></i> with URL
                </button>
              </div>
            </div>
            <div v-if="showInsertURL ==true">
              <mdb-input
                v-model="design.foodImageNameUrl"
                type="textarea"
                outline
                :rows="1"
                label="ชื่อรูปภาพ"
              />
              <mdb-input
                v-model="design.foodImageUrl"
                type="textarea"
                outline
                :rows="1"
                label="URL รูปภาพ"
              />
            </div>
            <!-- Default input techinque -->
            <label for="defaultFormEmailModalEx">เทคนิคการปรุง</label>
            <select class="browser-default custom-select" v-model="design.foodTechinque">
              <option value="" disabled selected>เลือกเทคนิคการปรุง</option>
              <option
                v-for="techinque in foodTechinque"
                :key="techinque.id"
                :value="techinque.id"
              >{{techinque.nameTechinques}}</option>
            </select>
            <br />
            <mdb-input
              type="textarea"
              outline
              :rows="4"
              v-model="design.desciption"
              label="รายละเอียดเพิ่มเติม"
            />
          </mdb-modal-body>
          <mdb-modal-footer>
            <button type="button" class="btn btn-secondary" @click="openForm = false">Close</button>
            <mdb-btn outline="purple" icon="paper-plane" @click="onCreateSubmit">Save</mdb-btn>
          </mdb-modal-footer>
        </mdb-modal>
      </div>
    </template>
    <!-- Modal end -->
    <br />
    <br />
    <br />
    <h3 class="title section-heading mb-5 h1 mt-0">MENU</h3>
    <div class="container" >
      <div class="d-flex flex-wrap align-content-around" @click="()=>onOpenForm(this)">
        <mdb-card class="mycard" type="button" data-toggle="modal" data-target="#basicExampleModal" >
          <mdb-view hover>
            <mdb-card-image
              src="https://img.lovepik.com/element/40089/7450.png_860.png"
              alt="Card image cap"
            ></mdb-card-image>
            <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
          </mdb-view>
          <mdb-card-body>
            <mdb-card-text style="text-align: center;font-size:300% ; color: #00e676">เพิ่มเมนู</mdb-card-text>
          </mdb-card-body>
        </mdb-card>
        <mdb-card class="mycard" v-for="menuList in menuDesign" :key="menuList.id" :value="menuList.id">
          <mdb-view hover>
            
              <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
            
            <div v-if="menuList.foodImage.urlImage != null" class="view overlay zoom">
              <div
                class="image-size"
                :style="{
                  background: 'url(' + menuList.foodImage.urlImage + ') no-repeat center center',
                }"
                alt="Card image cap"
              ></div>
            </div>
            <div v-else class="view overlay zoom">
              <mdb-card-image class="image-size" v-bind:src="url" alt="Card image cap"></mdb-card-image>
            </div>
          </mdb-view>
          <mdb-card-body>
            <mdb-card-text class="card-name">{{menuList.menu.menuName}}</mdb-card-text>
            <mdb-card-text
              class="card-techinque"
            >เทคนิคการปรุง:{{menuList.foodTechinque.nameTechinques}}</mdb-card-text>
            <mdb-card-text class="card-disciption">คำอธิบาย {{menuList.desciption}}</mdb-card-text>
            <mdb-card-text class="card-price">ราคา:{{menuList.menu.menuPrice}} บาท</mdb-card-text>
          </mdb-card-body>
        </mdb-card>
      </div>
    </div>
  </div>
</template>

<script>
import http from "../../http-common";
import EmployeeNavBar from '../EmployeeNavbar';
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
  mdbDropdownItem
} from "mdbvue";
import {
  mdbContainer,
  mdbRow,
  mdbCol,
  mdbCard,
  mdbCardImage,
  mdbCardHeader,
  mdbCardBody,
  mdbCardTitle,
  mdbCardText,
  mdbCardFooter,
  mdbCardUp,
  mdbCardAvatar,
  mdbCardGroup,
  mdbBtn,
  mdbView,
  mdbMask,
  mdbIcon,mdbModal, mdbModalHeader, mdbModalTitle, mdbModalBody, mdbModalFooter,
} from "mdbvue";
export default {
  name: "menuDesign",
  components: {
    EmployeeNavBar,
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
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbCard,
    mdbCardImage,
    mdbCardHeader,
    mdbCardBody,
    mdbCardTitle,
    mdbCardText,
    mdbCardFooter,
    mdbCardUp,
    mdbCardAvatar,
    mdbCardGroup,
    mdbBtn,
    mdbView,
    mdbMask,
    mdbIcon,mdbModal, mdbModalHeader, mdbModalTitle, mdbModalBody, mdbModalFooter,
  },
  data() {
    return {
      showInsertURL: false,
      openForm: false,
      menu: [],
      foodImage: [],
      foodTechinque: [],
      menuDesign: [],
      desciption: "",
      url: "",
      design: {
        menu: "",
        foodImage: "",
        foodImageUrl: "",
        foodImageNameUrl: "",
        foodTechinque: "",
        desciption: "",
        menuDesign: []
      }
    };
  },
  updated() {
    //console.log(this);
  },
  methods: {
    onShowInsertURL(main) {
      //console.log(main);
      main.showInsertURL = !main.showInsertURL;
      main.design.foodImage = "";
    },
    onOpenForm(main) {
      //console.log(main);
      main.openForm = true;
      console.log(main.openForm);
    },
    onCreateSubmit() {
      if (this.design.foodImage != "") {
        this.saveCreateMenu();
      } else if (
        this.design.foodImageUrl != "" &&
        this.design.foodImageNameUrl != ""
      ) {
        this.saveCreateMenuWithUrl();
      }
    },
    getFoodImage() {
      http
        .get("/foodImage")
        .then(response => {
          this.foodImage = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getMenu() {
      http
        .get("/menu")
        .then(response => {
          this.menu = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getFoodTechinque() {
      http
        .get("/foodTechinque")
        .then(response => {
          this.foodTechinque = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getMenuDesign() {
      http
        .get("/menuDesign")
        .then(response => {
          this.menuDesign = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    saveCreateMenuWithUrl() {
      let currentObj = this;
      http({
        method: "post",
        url: "/menuDesignWithURL",
        headers: { "Content-Type": "application/json" },
        data: {
          
          menuId: this.design.menu,
          foodTechinqueId: this.design.foodTechinque,
          desc: this.design.desciption,
          nameImage: this.design.foodImageNameUrl,
          urlImage: this.design.foodImageUrl
        }
      })
        .then(response => {
          alert("ออกแบบเมนูสำเร็จ");
          currentObj.getMenuDesign();
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        })
        .catch(e => {
          alert("เกิดข้อผิดพลาด " + e);
          currentObj.output = e;
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        });
    },
    saveCreateMenu() {
      let currentObj = this;
      http
        .post(
          "/menuDesign/" +
            this.design.menu +
            "/" +
            this.design.foodImage +
            "/" +
            this.design.foodTechinque +
            "/" +
            this.design.desciption
        )
        .then(response => {
          alert("ออกแบบเมนูสำเร็จ");
          currentObj.getMenuDesign();
          currentObj.design={};
          currentObj.openForm= false;
        })
        .catch(e => {
          alert("เกิดข้อผิดพลาด " + e);
          currentObj.output = e;
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        });
    },
  },
  mounted() {
    this.getFoodImage();
    this.getMenu();
    this.getFoodTechinque();
    this.getMenuDesign();
  }
};
</script>
<style scoped>
.title {
  color: #e3f2fd;
  text-align: center;
  font-size: 500% !important;
}
.mycontainer {
  margin-left: 30px !important;
  margin-right: 30px !important;
}
mdb-card-text {
  text-align: center;
}
text {
  text-align: center;
}
body,
html {
  height: 100%;
}
.bg {
  background:  url("https://www.bagri-restaurant.bg/wp-content/uploads/2014/05/header1.jpg") no-repeat center center;
  min-height: 100vh;
  height: 100%;
  margin: 0px;
  background-size: cover;
  background-attachment: fixed;
}
.card-name {
  text-align: center;
  font-size: 250% !important;
  color: #8ab4f8 !important;
}
.card-techinque {
  text-align: center;
  font-size: 120% !important;
}
.card-disciption {
  text-align: center;
  font-size: 50% !important;
}
.card-price {
  position: absolute;
  bottom: 8px;
  right: 16px;
  font-size: 18px;
}
.mycard {
  width: 300px !important;
  margin: 2ch;
}
.image-size {
  height: 300px;
  margin: 0px;
  background-size: cover;
  background-attachment: fixed;
}
</style>