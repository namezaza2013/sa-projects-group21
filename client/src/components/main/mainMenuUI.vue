<template>
<div >
	<div class="bg"></div>
	<mdb-container class="pt-5 content">
    <h1 class="text-center p-4 header">ระบบจัดการร้านอาหาร</h1>
		<mdb-row >
			<mdb-card-group deck class="mt-4">
				<mdb-card class="my-card">
					<mdb-view hover>
						<a href="#/LoginEmployee">
							<div class="image-card">
								<img src = "https://www.employmentalert.com/blog/wp-content/uploads/2018/05/Restaurant-employee-incentives.jpg" alt="Card image cap"/>
							</div>
							<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
						</a>
					</mdb-view>
					<mdb-card-body>
						<mdb-card-title class="text-center">เข้าสู่ระบบพนักงาน</mdb-card-title>
						<mdb-btn block color="success btn" @click="()=>$router.push({ name: 'LoginEmployee' })">Sign In</mdb-btn>
					</mdb-card-body>
				</mdb-card>
				<mdb-card class="my-card">
					<mdb-view hover>
						<a href="#/LoginOwner">
							<div class="image-card">
								<img src = "https://www.fearlessmotivation.com/wp-content/uploads/2017/04/restaurantowner3.jpg" alt="Card image cap"/>
							</div>
							<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
						</a>
					</mdb-view>
					<mdb-card-body>
						<mdb-card-title class="text-center">เข้าสู่ระบบเจ้าของร้าน</mdb-card-title>
						<mdb-btn block color="primary btn" @click="()=>$router.push({ name: 'LoginOwner' })">Sign In</mdb-btn>
					</mdb-card-body>
				</mdb-card>
				<mdb-card class="my-card">
					<mdb-view hover>
						<a href="#/Review">
							<div class="image-card">
								<img src = "https://amarinacademy.com/app/uploads/2017/07/pexels-photo-30503.jpg" alt="Card image cap"/>
							</div>
							<mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
						</a>
					</mdb-view>
					<mdb-card-body>
						<mdb-card-title class="text-center">หน้ารีวิวสำหรับลูกค้า</mdb-card-title>
						<mdb-btn block color="secondary btn" @click="()=>$router.push({ name: 'Review' })">go to page</mdb-btn>
					</mdb-card-body>
				</mdb-card>
			</mdb-card-group>
		</mdb-row>
	</mdb-container>
	</div>
</template>

<script>
	import { mdbContainer, mdbRow, mdbCol, mdbCard, mdbCardImage, mdbCardHeader, mdbCardBody, mdbCardTitle, mdbCardText, mdbCardFooter, mdbCardUp, mdbCardAvatar, mdbCardGroup, mdbBtn, mdbView, mdbMask, mdbIcon } from 'mdbvue';
	export default {
		name: 'MainMenuUI',
		components: {
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
		background-color: rgba(255, 255, 255, 0.8);
		width: 100%;
	}
	.my-card{
		border-radius: 10px;
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
	.image-card{
		height: 300px;
		width: 100%;
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