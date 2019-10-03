<template>

  <mdb-container>

    <mdb-col>
      <mdb-datatable
        :data="data"
        striped
        bordered
      />
     </mdb-col>

  </mdb-container>

</template>

<script>
  import { 
    mdbCol,
    mdbContainer,
    mdbDatatable
    } from 'mdbvue';
  
  export default {
    name: 'ShowingData',
    components: {
      mdbCol,
      mdbContainer,
      mdbDatatable
    },
     data() {
      return {
        data: {
          columns: [
            {
              label: 'ชื่อรายการอาหาร',
              field: 'name',
              sort: 'asc'
            },
            {
              label: 'ประเภทรายการอาหาร',
              field: 'type',
              sort: 'asc'
            },
            {
              label: 'ราคา(บาท)',
              field: 'price',
              sort: 'asc'
            },
            {
              label: 'จำนวน(จาน/ชิ้น/ขวด/แก้ว)',
              field: 'unit',
              sort: 'asc'
            },
            {
              label: 'เหมาะสำหรับ',
              field: 'Appropriate',
              sort: 'asc'
            },
            {
              label: 'สัญชาติอาหาร',
              field: 'nation',
              sort: 'asc'
            },
          ],
          rows: [
            {
              name: '-',
              type: '-',
              price: '0',
              unit: '0',
              person: '0',
              nation: '-',
            }
          ]
        }
      }
     }
  }
</script>