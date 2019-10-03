<template>
    <mdb-container>

        <!-- input with combobox -->
        <mdb-row>
            <mdb-col>
                <mdb-btn color="secondary" class="m-0">ประเภทรายการอาหาร</mdb-btn>
                <mdb-dropdown btn-group split dropright>
                <mdb-dropdown-toggle slot="toggle" color="secondary" class="px-3"></mdb-dropdown-toggle>
                <mdb-dropdown-menu dropright>
                    <mdb-dropdown-item>-</mdb-dropdown-item>
                </mdb-dropdown-menu>
                </mdb-dropdown>
            </mdb-col>
            <mdb-col>
                <mdb-btn color="secondary" class="m-0">เหมาะสำหรับ</mdb-btn>
                <mdb-dropdown btn-group split dropright>
                <mdb-dropdown-toggle slot="toggle" color="secondary" class="px-3"></mdb-dropdown-toggle>
                <mdb-dropdown-menu dropright>
                    <mdb-dropdown-item>-</mdb-dropdown-item>
                </mdb-dropdown-menu>
                </mdb-dropdown>
            </mdb-col>
            <mdb-col>
                <mdb-btn color="secondary" class="m-0">สัญชาติอาหาร</mdb-btn>
                <mdb-dropdown btn-group split dropright>
                <mdb-dropdown-toggle slot="toggle" color="secondary" class="px-3"></mdb-dropdown-toggle>
                <mdb-dropdown-menu dropright>
                    <mdb-dropdown-item>-</mdb-dropdown-item>
                </mdb-dropdown-menu>
                </mdb-dropdown> 
            </mdb-col>
        </mdb-row>
        <!-- input with combobox -->

        <!-- input with textbox -->
        <mdb-input type="text" size="lg" label="ชื่อรายการอาหาร" outline />
        <mdb-input type="text" size="lg" label="ราคา(บาท)" outline />
        <mdb-input type="text" size="lg" label="จำนวน(จาน/ชิ้น/ขวด/แก้ว)" outline />
        <!-- input with textbox -->

    </mdb-container>
</template>

<script>
    import { 
        mdbCol,
        mdbRow,
        mdbContainer,
        mdbDropdown, 
        mdbDropdownItem,
        mdbDropdownMenu, 
        mdbDropdownToggle,
        mdbInput,
        mdbBtn
    } from 'mdbvue';
    export default {
        name: 'Input',
        components: {
            mdbCol,
            mdbRow,
            mdbContainer,
            mdbDropdown, 
            mdbDropdownItem,
            mdbDropdownMenu, 
            mdbDropdownToggle,
            mdbInput,
            mdbBtn
        }
    }
</script>