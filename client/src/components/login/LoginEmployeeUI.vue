<template>
  <div class="my-bg">
    <mdb-container id="login">
      <!-- Default form login -->
      <div class="card-login center">
        <form>
          <p class="text-center mb-4">เข้าสู่ระบบพนักงาน</p>
          <label for="defaultFormLoginEmailEx"  class="grey-text">ชื่อผู้ใช้</label>
          <input type="text" id="defaultFormLoginEmailEx" v-model="username" class="form-control"/>
          <br/>
          <label for="defaultFormLoginPasswordEx" class="grey-text">รหัสผ่าน</label>
          <input type="password" id="defaultFormLoginPasswordEx" v-model="password" class="form-control"/>
          <div class="text-center mt-4">
            <button class="btn btn-indigo" @click="sendLogin($event)">เข้าสู่ระบบ</button>
          </div>
        </form>
      </div>
      <!-- Default form login -->
    </mdb-container>
  </div>
</template>

<script>
import http from "../../http-common";

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
  mdbTblBody, mdbModal, mdbModalHeader, mdbModalBody, mdbModalFooter
} from "mdbvue";

export default {
  name: "LoginEmployeeUI",
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
    mdbTblBody, mdbModal, mdbModalHeader, mdbModalBody, mdbModalFooter
  },
  data() {
    return {
      username : "",
      password : "",
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    sendLogin(event) {
      event.preventDefault();
      let currentObj = this;
      http.post('/loginEmployee/'+this.username+"/"+this.password)
      .then(function (response) {
        console.log(response.data);
        if(response.data){
          currentObj.$router.push({ name: 'EmployeeMenu' })
        }else{
          alert("username or password invalid,please try again...");
        }
      })
      .catch(function (error) {
        alert("เกิดข้อผิดพลาด "+error);
        currentObj.output = error;
      });
    }

    /* eslint-disable no-console */
  },
  updated(){
  },
  created() {
  }
  
};
</script>

<style scoped>
  .card-login {
    margin: auto;
    width:30%;
  }
  #login{
    font-size: 30px;
  }
  .center {
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
  }
</style>