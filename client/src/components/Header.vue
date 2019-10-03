<template>
    <mdb-container>
        <mdb-row>
            <mdb-col><h1>ระบบจัดการรายการอาหาร</h1></mdb-col>
        </mdb-row>
    </mdb-container>
</template>

<script>
    import { 
        mdbCol,
        mdbRow,
        mdbContainer,
    } from 'mdbvue';
    export default {
        name: 'Header',
        components: {
            mdbCol,
            mdbRow,
            mdbContainer,
        }
    }
</script>