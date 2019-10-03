package com.cpe.backend;


import com.cpe.backend.entity.MenuType;
import com.cpe.backend.entity.Nation;


import com.cpe.backend.repository.MenuTypeRepository;
import com.cpe.backend.repository.NationRepository;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(MenuTypeRepository menuTypeRepository, NationRepository nationRepository) {
		return args -> {
			// Stream.of("Other", "MainCouse", "Dessert", "Drinks").forEach(typeName -> {
			// 	MenuType menuType = new MenuType(); // สร้าง Object Customer
			// 	menuType.setTypeName(typeName); // set ชื่อ (name) ให้ Object ชื่อ Customer
			// 	menuTypeRepository.save(menuType); // บันทึก Objcet ชื่อ Customer
			// });

			// Stream.of("Thai", "India", "American", "France","Chiness","Turkis").forEach(nationName -> {
			// 	Nation nation = new Nation(); // สร้าง Object Employee
			// 	nation.setNationName(nationName); // set ชื่อ (name) ให้ Object ชื่อ Employee
			// 	nationRepository.save(nation); // บันทึก Objcet ชื่อ Employee
			// });

			menuTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
			nationRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
		};
	}

}
