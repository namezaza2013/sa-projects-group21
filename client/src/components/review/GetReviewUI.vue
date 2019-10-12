<template>
  <div class="bg">
    <mdb-navbar expand="large" color="green" dark class="nav-bg">
      <mdb-navbar-brand href="#">
        G21 Restaurant &nbsp; &nbsp; <mdb-icon icon="headset" /> <font size="2">Contact : 061-0846226</font>
      </mdb-navbar-brand>
        <mdb-navbar-toggler>
      </mdb-navbar-toggler>
    </mdb-navbar>
    <br><br><br>
    <p class="py-4 text-center">
    
      <center><h1><mdb-badge color="yellow"><font color="black">Review</font></mdb-badge> ร้านอาหาร G21 Restaurant</h1>
        <h4>ทุกความคิดเห็นมีค่า กรุณากรอกความเห็นเพื่อใช้ในการปรับปรุงร้าน</h4>
        <br>
        <div style="display:block;width:700px;height:100%" align = "left">
          <label for="Score">(*จำเป็น)เลือกระดับความพึงพอใจของท่านต่อร้านของเรา (จากมากไปน้อย)</label>
          <select  v-model="review.satisfactionLevel_id" class="browser-default custom-select">
            <option selected  value='' disabled>--กดเลือกระดับความพึงพอใจ--</option>
            <option v-for="satisNum in satisfactionLevels" :key="satisNum.id" :value="satisNum.id"> {{ satisNum.satisName }} </option>
          </select>

          <br><br>

          <label for="Improvement">ร้านอาหารควรปรับปรุงเรื่องใดมากที่สุด</label>
          <select  v-model="review.improvementType_id" class="browser-default custom-select">
            <option selected  value='1'>--ไม่มี--</option>
            <option v-for="improveNum in improvementTypes.slice(1)" :key="improveNum.id" :value="improveNum.id"> {{ improveNum.improveName }} </option>
          </select>

          <br><br>

          <label for="Employee blame">ท่านไม่พอใจพนักงานหรือไม่ หากไม่ โปรดแจ้งชื่อให้เราทราบ</label>

          <select v-model="review.employee_id" class="browser-default custom-select" v-if="review.improvementType_id == 2 ">
            <option selected  value='1' >--ไม่เลือกพนักงาน--</option>
            <option v-for="employeeNum in employees.slice(1)" :key="employeeNum.id" :value="employeeNum.id"> {{ employeeNum.name }} </option>
          </select>
          <select v-model="review.employee_id" class="browser-default custom-select" v-else disabled>
            <option selected  value='1' >--ไม่เลือกพนักงาน--</option>
          </select>

          <br><br>

          <label for="Comment">แสดงความคิดเห็นเพิ่มเติม</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span  class="input-group-text" id="basic-addon">
                <i  class="fas fa-pencil-alt prefix"></i>
              </span>
            </div>
            <textarea v-model="review.comment" class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
          </div>

          <mdb-btn @click="saveReview" color="success">รีวิว</mdb-btn>
        </div>
        <br><br>
        <div style="display:block;width:1000px;" align = "left">
          <h1><mdb-badge color="default">ประวัติการรีวิว</mdb-badge></h1>
          <mdb-scrollbar height="200px">
            <mdb-tbl bordered style="background-color:white;">
              <mdb-tbl-head color="light" >
                <tr>
                  <th>ลำดับที่</th>
                  <th>ระดับความพึงพอใจ</th>
                  <th>สิ่งที่ควรปรับปรุง</th>
                  <th>พนักงานที่โดนรายงาน</th>
                  <th>คอมเมนท์</th>
                  <th>วันที่รีวิว</th>
                </tr>
              </mdb-tbl-head>
              <mdb-tbl-body>
                <tr v-for="(review,index) in reviews" :key="index" >
                  <td>{{review.id}}</td>
                  <td>{{review.reviewSatis.satisName}}</td>
                  <td>{{review.reviewImprovementType.improveName}}</td>
                  <td>{{review.reviewEmployee.name}}</td>
                  <td>{{review.comment}}</td>
                  <td>{{review.reviewDate}}</td>
                </tr>
              </mdb-tbl-body>
            </mdb-tbl>
          </mdb-scrollbar>

    
        </div>

      </center>
    </p>
  </div>
</template>


<script>
import http from "../../http-common";
import {mdbScrollbar, mdbTbl, mdbTblHead, mdbTblBody,mdbBadge,mdbBtn,mdbDropdown, mdbDropdownToggle, mdbDropdownMenu, mdbDropdownItem, mdbContainer, mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem,mdbIcon  } from 'mdbvue';
export default {
    name: 'GetReviewUI',
    components: {
      mdbBadge,
      mdbBtn,
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbContainer,
      mdbDropdown,
      mdbDropdownToggle,
      mdbDropdownMenu,
      mdbDropdownItem,
      mdbIcon,
      mdbTbl,
      mdbTblHead,
      mdbTblBody,
      mdbScrollbar
      
    },
    data() {
      return {
        satisfactionLevels: [],
        improvementTypes:[],
        employees: [],
        reviews:[],
        review: {
          employee_id: '1',
          improvementType_id:'1',
          satisfactionLevel_id:'',
          comment: null
        },
        
      };
    },
    methods: {
      getReviews() {
        http
          .get("/review")
          .then(response => {
            this.reviews = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
      getEmployees() {
        http
          .get("/employee")
          .then(response => {
            this.employees = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
      getImprovementTypes() {
        http
          .get("/improvementType")
          .then(response => {
            this.improvementTypes = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
      getSatisfactionLevels() {
        http
          .get("/satisfactionLevel")
          .then(response => {
            this.satisfactionLevels = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
      saveReview() {
        http
          .post(
            "/review/" +
              this.review.satisfactionLevel_id +
              "/" +
              this.review.improvementType_id +
              "/" +
              this.review.employee_id +
              "/" +
              this.review.comment
            
          )
          .then(response => {
            console.log(response);
            alert("บันทึกสำเร็จ! ขอบคุณสำหรับการรีวิว");
            window.location.reload();
            
          })
          .catch(e => {
            console.log(e);
            alert("กรุณาเลือกระดับความพึงพอใจ");
          });

      },
    }, 
    mounted() {
      this.getEmployees();
      this.getImprovementTypes();
      this.getSatisfactionLevels();
      this.getReviews();
    }

};
</script>


<style scoped>
  .bg {
    /* The image used */
    background: url("ReviewBG.jpeg") no-repeat center center;
    min-height: 100vh;
    height: 100%;
    margin: 0px;
    background-size: cover;
    background-attachment: fixed;
  }
  .nav-bg{
  z-index: 5;
  background-color: rgba(252, 248, 248, 0.705);
  position: fixed; /* Set the navbar to fixed position */
  top: 0; /* Position the navbar at the top of the page */
  width: 100%; /* Full width */
}
</style>