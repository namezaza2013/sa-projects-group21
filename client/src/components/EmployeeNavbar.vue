<template>
  <div>
    <mdb-navbar class="nav-bg ">
      <mdb-navbar-brand href="https://mdbootstrap.com/">
        < ระบบจัดการร้านอาหาร >
      </mdb-navbar-brand>
      <mdb-navbar-toggler>
        <mdb-navbar-nav>
          <mdb-nav-item href="#/MenuDesign">ออกแบบเมนู</mdb-nav-item>
          <mdb-nav-item href="#/Menu">เพิ่มเมนู</mdb-nav-item>
          <mdb-nav-item href="#/Order">รับออเดอร์</mdb-nav-item>
          <mdb-nav-item href="#/Tables">เพิ่มโต๊ะ</mdb-nav-item>
          <mdb-nav-item href="#/Payment">ชำระเงิน</mdb-nav-item>
          <mdb-dropdown tag="li" class="nav-item">
            <mdb-dropdown-toggle tag="a" navLink color="secondary-color-dark" slot="toggle" waves-fixed>ผู้ดูแลระบบ</mdb-dropdown-toggle>
            <mdb-dropdown-menu>
              <mdb-dropdown-item href="#/Employee">เพิ่มพนักงาน</mdb-dropdown-item>
              <mdb-dropdown-item href="#/Review">กรอกรีวิว</mdb-dropdown-item>
            </mdb-dropdown-menu>
          </mdb-dropdown>
        </mdb-navbar-nav>
      </mdb-navbar-toggler>
    </mdb-navbar>
  </div>
</template>

<script>
import { mdbNavbar, mdbContainer, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbDropdown, mdbDropdownMenu, mdbDropdownToggle, mdbInput, mdbDropdownItem } from 'mdbvue';

export default {
  name: 'EmployeeNavbar',
  components: {
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
    mdbContainer
  }
}
</script>

<style>
.nav-bg{
  z-index: 5;
  background-color: rgba(252, 248, 248, 0.705);
  position: fixed; /* Set the navbar to fixed position */
  top: 0; /* Position the navbar at the top of the page */
  width: 100%; /* Full width */
}
</style>
