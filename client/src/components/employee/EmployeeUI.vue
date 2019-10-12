<template>
  <div class="my-bg">
    <br />
    <br />
    <div class="text-center">
      <h1>ระบบจัดการพนักงาน</h1>
    </div>
    <hr />
    <div class="container">
      <div class="row">
        <div class="col">
          <label>ชื่อพนักงาน</label>
          <input
            type="text"
            v-model="employee.name"
            id="defaultContactFormName"
            class="form-control mb-4"
            placeholder="Name"
          />
        </div>
      </div>
      <br />
      <div class="row">
        <div class="col">
          <label>Nickname</label>
          <input
            type="text"
            v-model="employee.nickname"
            id="defaultContactFormName"
            class="form-control mb-4"
            placeholder="Nickname"
          />
        </div>
        <div class="col">
          
        </div>
        <div class="col">
          <label>ที่พักอาศัย</label>
          <div class="form-group">
            <textarea
              class="form-control rounded-0"
              v-model="employee.address"
              id="exampleFormControlTextarea2"
              rows="3"
              placeholder="Address"
            ></textarea>
          </div>
        </div>
      </div>
      <br />
      <div class="row">
        <div class="col">
          <label>ประเภทของการรับงาน</label>
          <select class="browser-default custom-select" v-model="employee.worktype">
            <option disabled value>ประเภทของการรับงาน</option>
            <option
              v-for="type in worktype"
              :key="type.id"
              :value="type.id"
            >{{type.worktype}}</option>
            
          </select>
        </div>
        <div class="col">
          <label>หน้าที่</label>
          <select class="browser-default custom-select" v-model="employee.responsibility">
            <option disabled value>หน้าที่</option>
            <option
              v-for="res in responsibility"
              :key="res.id"
              :value="res.id"
            >{{res.responsibility}}</option>
          </select>
        </div>
        <div class="col">
          <label>ประสบการณ์ในการทำงาน</label>
          <select class="browser-default custom-select" v-model="employee.experience">
            <option disabled value>ประสบการณ์ในการทำงาน</option>
            <option
              v-for="sta in experience"
              :key="sta.id"
              :value="sta.id"
            >{{sta.experience}}</option>
          </select>
        </div>
      </div>
    </div>
    <br />
    <br />
    <div class="container">
      <div class="row">
        <div class="col-sm"></div>
        <div class="col-sm"></div>
        <div class="col-sm">
          <mdb-btn color="secondary" v-on:click="saveEmployee" >บันทึก</mdb-btn>

          <mdb-btn color="info" v-on:click="refresh">ยกเลิก</mdb-btn>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>
import https from "../../http-common";

import { mdbBtn } from "mdbvue";
export default {
  name: "EmployeeUI",
  components: {
    mdbBtn
  },
  data() {
    return {
      responsibility: [],
      experience: [],
      worktype: [],
      employee: {
        name: "",
        nickname: "",
        address: null,
        responsibility: "",
        experience: "",
        worktype: "",
        
      }
    };
  },
  methods: {
    getResponsibility() {
      axios
        .get("http://localhost:9000/responsibility")
        .then(respon => {
          this.responsibility = respon.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getExperience() {
      axios
        .get("http://localhost:9000/experience")
        .then(exp => {
          this.experience = exp.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getWorktype() {
      axios
        .get("http://localhost:9000/worktype")
        .then(type => {
          this.worktype = type.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    saveEmployee() {
      axios
        .post(
           "http://localhost:9000/employee/" +
            this.employee.name +
            "/" +
            this.employee.address +
            "/" +
            this.employee.nickname+
            "/" +
            this.employee.experience +
            "/" +
            this.employee.responsibility +
            "/" +
            this.employee.worktype
        )
        .then(response => {
          console.log(response);
           alert("บันทึกข้อมูลเสร็จสิ้น");
           refresh()
        })
        .catch(e => {
          console.log(e);
          
        });
      this.submitted = true;
    },
    refresh(){
      window.location.reload();
    }
  },
  
  mounted() {
    this.getResponsibility();
    this.getExperience();
    this.getWorktype();
  }
};
</script>

