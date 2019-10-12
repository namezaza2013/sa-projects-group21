<template>

<div class="image1">
    <navBar/>
    <br />
    <br />
    <br />
    <table class="center container">
        <mdb-card style="padding:20px">
            <br />
            <h1 class="text-center">โต๊ะอาหารภายในร้าน G21 Restaurant</h1>
            <mdb-btn color="success" style="width:50%;" class="center btn  float-right" icon="plus-circle" @click.native="modal = true" />
            <br />
            <!-- MODAL -->
            <div>
                <!-- เพิ่มรายการโต๊ะ -->
                <mdb-modal :show="modal" @close="modal = false">
                    <mdb-modal-header>
                        <mdb-modal-title>เพิ่มโต๊ะอาหาร</mdb-modal-title>
                    </mdb-modal-header>
                    <mdb-modal-body>
                        <div>
                            <label for="example2">ประเภทโต๊ะอาหาร</label>
                            <select class="browser-default custom-select" v-model="tables.tableType_id">
                                <option value disabled selected>เลือกประเภทโต๊ะอาหาร</option>
                                <option v-for="tt in tableTypes" :key="tt.id" :value="tt.id">{{tt.typeName}}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="example2">โซนโต๊ะอาหาร</label>
                            <select class="browser-default custom-select" v-model="tables.tableZone_id">
                                <option value selected disabled>เลือกโซนโต๊ะอาหาร</option>
                                <option v-for="tz in tableZones" :key="tz.id" :value="tz.id">{{tz.zone}}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="example1">เลขโต๊ะอาหาร</label>
                            <input placeholder="ป้อนตัวเลขโต๊ะอาหาร" type="text" v-model="tables.tablesName" id="example1" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label for="example1">จำนวนคนที่รองรับ</label>
                            <input placeholder="ป้อนเลขจำนวนคน" type="text" v-model="tables.seat" id="example1" class="form-control" />
                        </div>
                        <div>
                            <label for="example2">สถานะ</label>
                            <select class="browser-default custom-select" v-model="tables.tableStatus_id">
                                <option value disabled selected>เลือกสถานะ</option>
                                <option v-for="ts in tableStatuses" :key="ts.id" :value="ts.id">{{ts.state}}</option>
                            </select>
                        </div>
                    </mdb-modal-body>
                    <mdb-modal-footer>
                        <mdb-btn color="secondary" @click.native="modal = false">ปิด</mdb-btn>
                        <mdb-btn color="primary" @click="saveTables">ยืนยันการเพิ่ม</mdb-btn>
                    </mdb-modal-footer>
                </mdb-modal>
            </div>
            <br>
            <mdb-tbl>
                <mdb-tbl-head color="indigo darken-4" textWhite>
                    <tr>
                        <th>เลขโต๊ะอาหาร</th>
                        <th>ประเภทโต๊ะอาหาร</th>
                        <th>โซนโต๊ะอาหาร</th>
                        <th>จำนวนคนที่รองรับ</th>
                        <th>หมายเหตุ</th>
                    </tr>
                </mdb-tbl-head>
                <mdb-tbl-body>
                    <tr v-for="(tablle,index) in tablle" :key="index">
                        <th>{{tablle.tablesName}}</th>
                        <td>{{tablle.tableType.typeName}}</td>
                        <td>{{tablle.tableZone.zone}}</td>
                        <td>{{tablle.seat}}</td>
                        <td>{{tablle.tableStatus.state}}</td>
                    </tr>
                </mdb-tbl-body>
            </mdb-tbl>
            <!-- <div>
                <mdb-datatable :data="data" striped bordered/>
            </div> -->
        </mdb-card>
    </table>
</div>
</template>

<script>
import navBar from '../EmployeeNavbar'
import {
    mdbInput,
    mdbBtn,
    mdbCard,
    mdbCardBody,
    mdbIcon,
    mdbTbl,
    mdbTblHead,
    mdbTblBody,
    mdbContainer,
    mdbBtnGroup,
    mdbBtnToolbar,
    mdbModal,
    mdbModalHeader,
    mdbModalTitle,
    mdbModalBody,
    mdbModalFooter,
    mdbDatatable
} from 'mdbvue'
import axios from 'axios'
const https = axios.create({
    baseURL: 'http://localhost:9000/',
    heaers: {
        'Access-Control-Allow-Origin': '*',
        'Content-type': 'application/json'
    }
})
export default {
    name: 'TablesUI',
    components: {
        navBar,
        mdbInput,
        mdbBtn,
        mdbCard,
        mdbCardBody,
        mdbIcon,
        mdbTbl,
        mdbTblHead,
        mdbTblBody,
        mdbContainer,
        mdbBtnGroup,
        mdbBtnToolbar,
        mdbModal,
        mdbModalHeader,
        mdbModalTitle,
        mdbModalBody,
        mdbModalFooter,
        mdbDatatable
    },
    data() {
        return {
            searchTerm: '',
            data: {
                columns: [{
                        label: 'เลขโต๊ะอาหาร',
                        field: 'tablesName',
                        sort: 'asc'
                    },
                    {
                        label: 'ประเภทโต๊ะอาหาร',
                        field: 'tableTypes',
                        sort: 'asc'
                    },
                    {
                        label: 'โซนโต๊ะอาหาร',
                        field: 'tableZones',
                        sort: 'asc'
                    },
                    {
                        label: 'จำนวนคนที่รองรับ',
                        field: 'seat',
                        sort: 'asc'
                    },
                    {
                        label: 'หมายเหตุ',
                        field: 'tableStatuses',
                        sort: 'asc'
                    }
                ],
                rows: [{
                        
                        tablesName: 'System Architect',
                        tableTypes: 'Edinburgh',
                        tableZones: '61',
                        seat: '2011/04/25',
                        tableStatuses: 'R1',
                    },
                    {
                        
                        tablesName: 'Accountant',
                        tableTypes: 'Tokyo',
                        tableZones: '63',
                        seat: '2011/07/25',
                        tableStatuses: 'R5',
                    }
                ]
            },
            modal: false,
            smodal: false,
            tableTypes: [],
            tableZones: [],
            tableStatuses: [],
            tablle: [],
            tables: {
                tableType_id: '',
                tableZone_id: '',
                tablesName: '',
                seat: '',
                tableStatus_id: '',
            }
        }
    },
    methods: {
        getTablle() {
            axios
                .get('http://localhost:9000/tables')
                .then(response => {
                    this.tablle = response.data
                })
                .catch(e => {
                    console.log(e)
                })
        },
        getTableTypes() {
            axios
                .get('http://localhost:9000/tableType')
                .then(response => {
                    this.tableTypes = response.data
                })
                .catch(e => {
                    console.log(e)
                })
        },
        // ดึงข้อมูล TableZone ใส่ combobox
        getTableZones() {
            axios
                .get('http://localhost:9000/tableZone')
                .then(response => {
                    this.tableZones = response.data
                    console.log(response.data)
                })
                .catch(e => {
                    console.log(e)
                })
        },
        // ดึงข้อมูล TableStatus ใส่ combobox
        getTableStatuses() {
            axios
                .get('http://localhost:9000/tableStatus')
                .then(response => {
                    this.tableStatuses = response.data
                    console.log(response.data)
                })
                .catch(e => {
                    console.log(e)
                })
        },
        //function เมื่อกดปุ่ม ยืนยัน
        saveTables() {
            axios
                .post(
                    "http://localhost:9000/tables/" +
                    this.tables.tableType_id +
                    "/" +
                    this.tables.tableZone_id +
                    "/" +
                    this.tables.tablesName +
                    "/" +
                    this.tables.seat +
                    "/" +
                    this.tables.tableStatus_id +
                    "/"
                )
                .then(response => {
                    console.log(response);
                    alert("บันทึกเสร็จสิ้น");
                    window.location.reload()
                })
                .catch(e => {
                    console.log(e);
                    alert("โปรดเลือกหรือกรอกให้ครบถ้วน");
                });
            this.submitted = true;
        },
        deleteType() {
            axios.delete().then(response => {
                console.log(response);
            });
        },
    },

    mounted() {
        this.getTablle()
        this.getTableTypes()
        this.getTableZones()
        this.getTableStatuses()
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>
.image1 {
    background: url('https://amarinacademy.com/app/uploads/2017/09/drew-coffman-94401.jpg') no-repeat;
    -webkit-background-size: cover;
    background-size: cover;
    width: 100vw;
    height: 100vh;
}
.center{
    margin-left: auto;
    margin-right: auto;
}
</style>
