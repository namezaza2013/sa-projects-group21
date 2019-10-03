package com.cpe.backend;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;

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
	ApplicationRunner init(AppropriateRepository appropriateRepository,AppropriationRepository appropriationRepository, MenuRepository menuRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository) {
		return args -> {

			Object[][] data;
			data = new Object[][] { { "55" }, { "66" }, { "77" }, { "88" }, { "99" }, };
			for (int i = 0; i < data.length; i++) {
				Appropriate appropriate = new Appropriate();
				appropriate.setAppropriationName((String) data[i][0]);
				appropriateRepository.save(appropriate);
			}

			data = new Object[][] { { "ต้มยำกุ้ง", 70, 5 }, { "ข้าวผัด", 50, 5 }, { "ปลานิ่งมะนาว", 80, 2 },
					{ "ข้าวราดกระเพราหมู", 50, 2 }, { "ผัดไทย", 50, 2 }, };

			for (int i = 0; i < data.length; i++) {
				Menu menu = new Menu();
				menu.setMenuName((String) data[i][0]);
				menu.setMenuPrice((Integer) data[i][1]);
				menu.setMenuUnits((Integer) data[i][2]);
				menuRepository.save(menu);
			}

			data = new Object[][] { { "sada" }, { "asd" }, { "sad" }, { "sad" }, { "asd" }, };
			for (int i = 0; i < data.length; i++) {
				MenuType menuType = new MenuType();
				menuType.setTypeName((String) data[i][0]);
				menuTypeRepository.save(menuType);
			}

			data = new Object[][] { { "sada" }, { "asd" }, { "sad" }, { "sad" }, { "asd" }, };
			for (int i = 0; i < data.length; i++) {
				Nation nation = new Nation();
				nation.setNationName((String) data[i][0]);
				nationRepository.save(nation);
			}

		};
	}

}
