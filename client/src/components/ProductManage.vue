<template>

  <mdb-container>

    <Header />

    <Input />

    <ShowingData />

    <AddButton />

  </mdb-container>

</template>

<script>
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
    mdbDatatable
    } from 'mdbvue';
  
  import Header from './Header'
  import Input from './Input'
  import ShowingData from './ShowingData'
  import AddButton from './AddButton'

  export default {
    name: 'ProductManage',
    components: {
      AddButton,
      ShowingData,
      Input,
      Header,
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
              name: 'โค้ก',
              type: 'เครื่องดื่ม',
              price: '15',
              unit: '2',
              person: '1',
              nation: '-',
            },
            {
              name: 'กระเพรา',
              type: 'อาหาร',
              price: '35',
              unit: '-',
              person: '1',
              nation: 'ไทย',
            },
            {
              name: 'ขยมปังทาเนย',
              type: 'ของหวาน',
              price: '20',
              unit: '20',
              person: '3',
              nation: 'ตะวันตก',
            },
             {
              name: 'โค้ก',
              type: 'เครื่องดื่ม',
              price: '15',
              unit: '2',
              person: '1',
              nation: '-',
            }
          ]
        }
      }
     }
  }
</script>