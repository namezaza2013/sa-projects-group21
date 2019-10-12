<template>
<div >
<div class="bg"></div>
	<EmployeeNavBar/>
	<mdb-container class="pt-5 content">
    <h1 class="text-center p-4 header">เลือกเมนูสำหรับพนักงาน</h1>
		<mdb-row >
			<mdb-col class="my-card">
				<h1 class="text-center">ออกแบบเมนู</h1>
				<mdb-btn block color="success btn" @click="()=>$router.push({ name: 'MenuDesign' })"><h3>เข้าสู่หน้าเว็ป</h3></mdb-btn>
			</mdb-col>
			<mdb-col class="my-card">
				<h1 class="text-center">เพิ่มเมนู</h1>
				<mdb-btn block color="primary btn" @click="()=>$router.push({ name: 'Menu' })"><h3>เข้าสู่หน้าเว็ป</h3></mdb-btn>
			</mdb-col>
			<mdb-col class="my-card">
				<h1 class="text-center">รับออเดอร์</h1>
				<mdb-btn block color="warning btn" @click="()=>$router.push({ name: 'Order' })"><h3>เข้าสู่หน้าเว็ป</h3></mdb-btn>
			</mdb-col>
			
		</mdb-row>
			<mdb-row >
			<mdb-col class="my-card">
				<h1 class="text-center">ชำระเงิน</h1>
				<mdb-btn block color="danger btn" @click="()=>$router.push({ name: 'Payment' })"><h3>เข้าสู่หน้าเว็ป</h3></mdb-btn>
			</mdb-col>
			<mdb-col class="my-card">
				<h1 class="text-center">เพิ่มโต๊ะ</h1>
				<mdb-btn block color="secondary btn" @click="()=>$router.push({ name: 'Tables' })"><h3>เข้าสู่หน้าเว็ป</h3></mdb-btn>
			</mdb-col>
		</mdb-row>
	</mdb-container>
	</div>
</template>

<script>
	import { mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardImage, mdbCardHeader, mdbCardBody, mdbCardTitle, mdbCardText, mdbCardFooter, mdbCardUp, mdbCardAvatar, mdbCardGroup, mdbBtn, mdbView, mdbMask, mdbIcon } from 'mdbvue';
	import EmployeeNavBar from '../EmployeeNavbar';
	export default {
		name: 'MainMenuUI',
		components: {
			EmployeeNavBar,
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
			mdbIcon
		}
	}
</script>

<style scoped>
	.header{
		color:black;
		background-color: rgba(175, 175, 175, 0.8);
		width: 100%;
	}
	.my-card{
		border-radius: 10px;
		background-color: rgba(255, 255, 255, 0.8);
		padding-left: 40px;
		padding-right: 40px;
		padding-top: 40px;
		padding-bottom: 40px;
		margin: 5px;
	}
	.btn{
		height: 60px;
	}
	img{
		min-height: 100%;
		max-height: 100%;
		width: 100%;
		object-fit: cover;
		border-top-right-radius: 10px;
		border-top-left-radius: 10px;
	}
	.content{
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		z-index: 2;
	}
	.bg {
		background:  url("https://powellmeadows.com/wp-content/uploads/bg-restaurant.jpg") no-repeat center center;
		min-height: 100vh;
		height: 100%;
		margin: 0px;
		background-size: cover;
		background-attachment: fixed;
		/* Add the blur effect */
		filter: blur(4px);
		background-size:cover;
		display: block;
		z-index: -1;
	}
</style>