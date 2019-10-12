package com.cpe.backend;

import com.cpe.backend.order.entity.*;
import com.cpe.backend.order.repository.*;

import com.cpe.backend.login.entity.*;
import com.cpe.backend.login.repository.*;

import com.cpe.backend.menu.entity.*;
import com.cpe.backend.menu.repository.*;

import com.cpe.backend.menudesign.entity.*;
import com.cpe.backend.menudesign.repository.*;

import com.cpe.backend.tables.entity.*;
import com.cpe.backend.tables.repository.*;

import com.cpe.backend.payment.entity.*;
import com.cpe.backend.payment.repository.*;

import com.cpe.backend.employee.entity.*;
import com.cpe.backend.employee.repository.*;

import com.cpe.backend.review.entity.*;
import com.cpe.backend.review.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(
			FoodImageRepository foodImageRepository, 
			FoodTechinqueRepository foodTechinqueRepository,
			TableZoneRepository tableZoneRepository, 
			TableStatusRepository tableStatusRepository,
			PaymentWayRepository paymentWayRepository,
			ImprovementTypeRepository improvementTypeRepository ,
			SatisfactionLevelRepository satisfactionLevelRepository,
			ResponsibilityRepository responsibilityRepository,
			WorkTypeRepository workTypeRepository,
			ExperienceRepository experienceRepository,
			MenuRepository menuRepository,
			AppropriateRepository appropriateRepository,
			MenuTypeRepository menuTypeRepository,
			NationRepository nationRepository,
			OrderStatusRepository orderStatusRepository, 
			MenuOrderRepository menuOrderRepository, 
			OrderRepository orderRepository, 
			TablesRepository tablesRepository, 
			TableTypeRepository tableTypeRepository ,
			EmployeeRepository employeeRepository,
			UserPriorityRepository userPriorityRepository,
			AccountRepository accountRepository
		){
		return args -> {
			Object[][] data;
			//Menu Design
			data = new Object[][] {
				{ "ต้มยำกุ้ง", "http://www.thaifoodheritage.com/uploads/recipe_list/gallery/e3de5-jpg.jpeg" },
				{ "ข้าวผัด", "https://food.mthai.com/app/uploads/2019/02/Fried-Rice-with-Shrimp-Fat.jpg" },
				{ "ข้าวราดกระเพราหมู","https://image.makewebeasy.net/makeweb/0/zs7gnRKvE/TH/%E0%B8%9C%E0%B8%B1%E0%B8%94%E0%B8%81%E0%B8%A3%E0%B8%B0%E0%B9%80%E0%B8%9E%E0%B8%A3%E0%B8%B2%E0%B9%84%E0%B8%81%E0%B9%88.jpg" },
				{ "ปลานึ่งมะนาว", "https://food.mthai.com/app/uploads/2017/02/Spicy-fish-2.jpg" },
				{ "ผัดไทย", "https://img.kapook.com/u/2015/surauch/cook2/PT1.jpg" }, 
			};
			for (int i = 0; i < data.length; i++) {
				FoodImage image = new FoodImage();
				image.setNameImage((String) data[i][0]);
				image.setUrlImage((String) data[i][1]);
				foodImageRepository.save(image);
			}
			//Menu foodTechinque
			data = new Object[][] { 
				{ "ทอด" }, { "ต้ม" }, { "นิ่ง" }, { "ผัด" }, { "ตุ๋น" }, 
			};
			for (int i = 0; i < data.length; i++) {
				FoodTechinque foodTechinque = new FoodTechinque();
				foodTechinque.setNameTechinques((String) data[i][0]);
				foodTechinqueRepository.save(foodTechinque);
			}
			
			//Menu appropriate
			data = new Object[][] { 
				{"ทัวไป"},{ "มังสวิรัส" }, { "กินเผ็ดน้อย" }, { "กินเผ็ดมาก" }, { "กินหวานน้อย" }, { "กินหวานมาก" },{ "ผู้ที่กำลังควบคุมน้ำหนัก" } 
			};
			for (int i = 0; i < data.length; i++) {
				Appropriate appropriate = new Appropriate();
				appropriate.setAppropriationName((String) data[i][0]);
				appropriateRepository.save(appropriate);
			}
			//menu Type
			data = new Object[][] { 
				{ "เครื่องดื่ม" }, { "อาหารจานด่วย" }, { "ของหวาน" }, { "ขนม" },{"อาหารทั่วไป"} ,{"อาหารตามสั่ง"},{ "เครื่องดื่มมีแอลกอฮอล์" }
			};
			for (int i = 0; i < data.length; i++) {
				MenuType menuType = new MenuType();
				menuType.setTypeName((String) data[i][0]);
				menuTypeRepository.save(menuType);
			}
			//Menu nation
			data = new Object[][] { 
				{ "ไทย" }, { "จีน" }, { "อินเดีย" }, { "ตุรกี" }, { "ตะวันตก" }, 
			};
			for (int i = 0; i < data.length; i++) {
				Nation nation = new Nation();
				nation.setNationName((String) data[i][0]);
				nationRepository.save(nation);
			}
			//Menu
			data = new Object[][] { 
				{ "โค็ก", 25, 40 ,1,1,1}, 
				{ "kitket", 20, 70 ,4,1,1}, 
				{ "เบียร์ช้าง", 35, 30,7,1,1 },
			};
			for (int i = 0; i < data.length; i++) {
				Menu menu = new Menu();
				menu.setMenuName((String) data[i][0]);
				menu.setMenuPrice((Integer) data[i][1]);
				menu.setMenuUnits((Integer) data[i][2]);
				menu.setMenuTypeID(menuTypeRepository.findById((int)data[i][3]));
				menu.setNationID(nationRepository.findById((int)data[i][4]));
				menu.setAppropriateID(appropriateRepository.findById((int)data[i][5]));
				menuRepository.save(menu);
			}
			//Order Status
			Stream.of(
				"รอคิว",
				"กำลังจัดเตรียม",
				"เสิร์ฟแล้ว"
			).forEach(name -> {
				OrderStatus orderStatus = new OrderStatus(); 
				orderStatus.setName(name); 
				orderStatusRepository.save(orderStatus); 
			});
			tablesRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมด
			tableTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมด
			menuRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมด
			//Order
			// data = new Object[][]{
			// 	//tableId , menuId, orderStatusId,Desc
			// 	{1,"1,1,1",1,""},
			// 	{2,"1,2,3",1,""},
			// 	{3,"3,3",1,""},
			// };
			// for(int i = 0;i<data.length;i++){
			// 	Collection<MenuOrder> menuOrders = new ArrayList<MenuOrder>();
			// 	String menu = (String) data[i][1];
      //   for(String menuId : menu.split(",")){
			// 		System.out.println("=/=/=/=/=/=/=/= "+menuId);
			// 		Long id = Long.parseLong(menuId);
			// 		MenuOrder menuOrder = new MenuOrder(); 
			// 		Menu m = menuRepository.findById(id).get();
			// 		menuOrder.setMenu(m);
			// 		menuOrders.add(menuOrderRepository.save(menuOrder));
      //   }

			// 	Order newOrders = new Order();
			// 	Tables table = tablesRepository.findById((int)data[i][0]);
			// 	OrderStatus orderStatus = orderStatusRepository.findById((int)data[i][2]);
			// 	newOrders.setTables(table);
			// 	newOrders.setOrderStatus(orderStatus);
      //   for(MenuOrder menuOrder : menuOrders){
      //       newOrders.addMenuOrder(menuOrder);
      //   }
      //   newOrders.setDesc((String)data[i][3]);
			// 	newOrders.setDate(new Date());
			// 	orderRepository.save(newOrders);
			// }
			//===================
			//review level
			Stream.of(
				"มากที่สุด", "มาก", "ปานกลาง", "น้อย","น้อยที่สุด"
			).forEach(satisName -> {
				SatisfactionLevel satisfactionLevel = new SatisfactionLevel(); // สร้าง Object SatisfactionLevel
				satisfactionLevel.setSatisName(satisName); // set ชื่อ (name) ให้ Object ชื่อ SatisfactionLevel
				satisfactionLevelRepository.save(satisfactionLevel); // บันทึก Objcet ชื่อ SatisfactionLevel
			});
			//review improvement
			Stream.of(
				"---ไม่มี---",
				"พฤติกรรมพนักงาน",
				"ราคาอาหาร", 
				"ความสะอาดภายในร้าน", 
				"บรรยากาศภายในร้าน", 
				"รสชาติอาหาร",
				"พื้นที่ไม่เพียงพอ",
				"เมนูอาหาร"
			).forEach(improveName -> {
				ImprovementType improvementType = new ImprovementType(); // สร้าง Object ImprovementType
				improvementType.setImproveName(improveName); // set ชื่อ (name) ให้ Object ชื่อ ImprovementType
				improvementTypeRepository.save(improvementType); // บันทึก Objcet ชื่อ ImprovementType
			});
			//review responsibility
			Stream.of(
				"พ่อครัว","ผู้ช่วยพ่อครัว", "พนักงานบริการ", "พนักงานต้อนรับ","พนักงานทำความสะอาด"
			).forEach(Respon -> {
				Responsibility responsibility = new Responsibility(); 
				responsibility.setResponsibility(Respon); 
				responsibilityRepository.save(responsibility); 
			});
			//review experience
			Stream.of(
				"น้อยกว่า 1 ปี","1 ถึง 2 ปี","2 ถึง 3 ปี","3 ถึง 4 ปี","มากกว่า 5 ปี"
			).forEach(exp-> {
				Experience experience = new Experience(); 
				experience.setExperience(exp); 
				experienceRepository.save(experience); 
			});
			//review workType
			Stream.of(
				"งานเต็มเวลา","งานพิเศษ"
			).forEach(Wtype -> {
				WorkType workType = new WorkType(); 
				workType.setWorktype(Wtype); 
				workTypeRepository.save(workType); 
			});
			//===================
			//employee
			Object[][] employee = new Object[][] { 
				{ "--ไม่มี--", "--ไม่มี--", "--ไม่มี--" ,1,1,1 }, 
				{ "Frong Khanisorn", "Thai", "frong1234" ,4,3,1 },
				{ "KK film", "Thai", "qwerty" ,3,4,2 }
			};
			for (int i = 0; i < employee.length; i++) {
				Employee newEmployee = new Employee();
				newEmployee.setName((String) employee[i][0]);		
				newEmployee.setAddress((String) employee[i][1]);
				newEmployee.setNickname((String) employee[i][2]);
				Experience ws = experienceRepository.findById((int)employee[i][3]);
				newEmployee.setAddexperience(ws);
				Responsibility res = responsibilityRepository.findById((int) employee[i][4]);
				newEmployee.setAddresponsibility(res);
				WorkType wt = workTypeRepository.findById((int) employee[i][5]);
				newEmployee.setAddworktype(wt);	
				employeeRepository.save(newEmployee);
			}
			//====================
			//Account Piriority
			Stream.of(
				"Owner",
				"Employee"
			).forEach(name -> {
				UserPriority userPriority = new UserPriority(); 
				userPriority.setName(name); 
				userPriorityRepository.save(userPriority); 
			});
			userPriorityRepository.findAll().forEach(System.out::println); // แสดง ข้อมูล
			//Account
			Object[][] obj = new Object[][]{
				{"emp1","emp1p",2,2},
				{"emp2","emp2p",2,1},
				{"admin","adminp",1,3},
			};
			for(int i = 0;i<obj.length;i++){
				Account ac = new Account(); 
				ac.setUsername((String) obj[i][0]); 
				ac.setPassword((String) obj[i][1]); 
				UserPriority up = userPriorityRepository.findById((int) obj[i][2]);
				ac.setUserPriority(up); 
				Employee emp = employeeRepository.findById((int) obj[i][3]);
				ac.setEmployee(emp); 
				System.out.println("==========1=========");
				System.out.println(emp);
				accountRepository.save(ac); 
			}
			//================
			//Tables
			Stream.of("REGULAR", "SPECIAL", "VIP").forEach(typeName -> {
				TableType tableType = new TableType(); 
				tableType.setTypeName(typeName); 
				tableTypeRepository.save(tableType); 
			});

			Stream.of("มุมสำหรับครอบครัว", "มุมสำหรับทำงาน", "มุมติดหน้าต่างดูวิว", "มุมสำหรับคนพิเศษ").forEach(zone -> {
				TableZone tableZone = new TableZone(); 
				tableZone.setZone(zone); 
				tableZoneRepository.save(tableZone); 
			});

			Stream.of("ใช้งานได้ตามปกติ", "อยู่ระหว่างการซ่อมบำรุง", "ไม่สามารถใช้งานได้").forEach(state -> {
				TableStatus tableStatus = new TableStatus(); 
				tableStatus.setState(state); 
				tableStatusRepository.save(tableStatus); 
			});

			data = new Object[][]{
				{1,1,1,"โต๊ะริมหาด 1",4},
				{2,3,2,"โต๊ะริมหาด 2",4},
				{3,2,3,"โต๊ะริมหาด 3",10},
			};
			for(int i = 0;i<data.length;i++){
				Tables newTable = new Tables();
				TableType tableType = tableTypeRepository.findById((int) data[i][0]);
				TableZone tableZone = tableZoneRepository.findById((int) data[i][1]);
				TableStatus tableStatus = tableStatusRepository.findById((int) data[i][2]);

				newTable.setTableType(tableType);
				newTable.setTableZone(tableZone);
				newTable.setTablesName((String) data[i][3]);
				newTable.setSeat((int) data[i][4]);
				newTable.setTableStatus(tableStatus);
				
				tablesRepository.save(newTable); 
			}
			tableTypeRepository.findAll().forEach(System.out::println); 
			tablesRepository.findAll().forEach(System.out::println); 
			tableZoneRepository.findAll().forEach(System.out::println); 
			tableStatusRepository.findAll().forEach(System.out::println); 
			//================
			
			//Payment
			Stream.of("Cash", "Online", "Card").forEach(name -> {
				PaymentWay paymentWay = new PaymentWay(); // สร้าง Object PaymentWay
				paymentWay.setName(name); // set ชื่อ (name) ให้ Object ชื่อ PaymentWay
				paymentWayRepository.save(paymentWay); // บันทึก Objcet ชื่อ PaymentWay
			});

			orderRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Order บน Terminal
			paymentWayRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity PaymentWay บน Terminal
			employeeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			accountRepository.findAll().forEach(System.out::println); 
			experienceRepository.findAll().forEach(System.out::println);
			responsibilityRepository.findAll().forEach(System.out::println);
			workTypeRepository.findAll().forEach(System.out::println);	
			satisfactionLevelRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity SatisfactionLevel บน Terminal
			improvementTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity ImprovementType บน Terminal
		};
	}	

	// Fix the CORS errors
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {  
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
			CorsConfiguration config = new CorsConfiguration();  
			config.setAllowCredentials(true); 
			// *** URL below needs to match the Vue client URL and port ***
			config.setAllowedOrigins(Collections.singletonList("http://localhost:8080")); 
			config.setAllowedMethods(Collections.singletonList("*"));  
			config.setAllowedHeaders(Collections.singletonList("*"));  
			source.registerCorsConfiguration("/**", config);  
			FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
			return bean;  
	}   
}
