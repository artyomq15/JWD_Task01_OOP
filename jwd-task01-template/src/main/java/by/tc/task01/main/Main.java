package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;



public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();


		Criteria<Oven> criteriaOven = new Criteria<>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.HEIGHT, "45.5");
		criteriaOven.add(Oven.WIDTH, 59.5);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);


		Criteria<Laptop> criteriaLaptop = new Criteria<>();
		criteriaLaptop.setApplianceType("Laptop");
		criteriaLaptop.add(Laptop.BATTERY_CAPACITY, " 1");

		appliance = service.find(criteriaLaptop);

		PrintApplianceInfo.print(appliance);


		Criteria<Refrigerator> criteriaRefrigerator = new Criteria<>();
		criteriaRefrigerator.setApplianceType("Refrigerator");
		criteriaRefrigerator.add(Refrigerator.FREEZER_CAPACITY, "15");
		criteriaRefrigerator.add(Refrigerator.HEIGHT, 180);

		appliance = service.find(criteriaRefrigerator);

		PrintApplianceInfo.print(appliance);


		Criteria<Speakers> criteriaSpeakers = new Criteria<>();
		criteriaSpeakers.setApplianceType("Speakers");
		criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-3.5");

		appliance = service.find(criteriaSpeakers);

		PrintApplianceInfo.print(appliance);



		Criteria<TabletPC> criteriaTabletPC = new Criteria<>();
		criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.BATTERY_CAPACITY, "5");
		criteriaTabletPC.add(TabletPC.COLOR, "green");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 16);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, "16000");

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);


		Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<>();
		criteriaVacuumCleaner.setApplianceType("VacuumCleaner");
		criteriaVacuumCleaner.add(VacuumCleaner.POWER_CONSUMPTION, "110");
		criteriaVacuumCleaner.add(VacuumCleaner.FILTER_TYPE, "B");
		criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE, "all-in-one   ");

		appliance = service.find(criteriaVacuumCleaner);

		PrintApplianceInfo.print(appliance);




		Criteria<TabletPC> criteriaTabletPC1 = new Criteria<>();
		criteriaTabletPC1.setApplianceType("TabletPC");
		criteriaTabletPC1.add(TabletPC.COLOR, "blue");
		criteriaTabletPC1.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC1.add(TabletPC.MEMORY_ROM, 8000);

		appliance = service.find(criteriaTabletPC1);

		PrintApplianceInfo.print(appliance);

		Criteria<Speakers> speakersCriteria1 = new Criteria<>();
		speakersCriteria1.setApplianceType("Speakers");
		speakersCriteria1.add(Speakers.POWER_CONSUMPTION, "17");
		speakersCriteria1.add(Speakers.NUMBER_OF_SPEAKERS, 4);
		speakersCriteria1.add(Speakers.FREQUENCY_RANGE, "2-3.5");

		appliance = service.find(speakersCriteria1);

		PrintApplianceInfo.print(appliance);

		Criteria<VacuumCleaner> vacuumCleanerCriteria1 = new Criteria<>();
		vacuumCleanerCriteria1.setApplianceType("VacuumCleaner");
		vacuumCleanerCriteria1.add(VacuumCleaner.WAND_TYPE, "all-in-one");
		vacuumCleanerCriteria1.add(VacuumCleaner.FILTER_TYPE, "B");
		vacuumCleanerCriteria1.add(VacuumCleaner.BAG_TYPE, "AA-89");
		vacuumCleanerCriteria1.add(VacuumCleaner.MOTOR_SPEED_REGULATION, 2900);
		vacuumCleanerCriteria1.add(VacuumCleaner.POWER_CONSUMPTION, 110);

		appliance = service.find(vacuumCleanerCriteria1);

		PrintApplianceInfo.print(appliance);

		Criteria<VacuumCleaner> vacuumCleanerCriteria2 = new Criteria<>();
		vacuumCleanerCriteria2.setApplianceType("VacuumCleaner");
		vacuumCleanerCriteria2.add(VacuumCleaner.FILTER_TYPE, "A");

		appliance = service.find(vacuumCleanerCriteria2);

		PrintApplianceInfo.print(appliance);

		Criteria<Refrigerator> refrigeratorCriteria = new Criteria<>();
		refrigeratorCriteria.setApplianceType("Refrigerator");
		refrigeratorCriteria.add(Refrigerator.FREEZER_CAPACITY, "20");
		refrigeratorCriteria.add(Refrigerator.HEIGHT, 250);
		refrigeratorCriteria.add(Refrigerator.OVERALL_CAPACITY, 350.5);
		refrigeratorCriteria.add(Refrigerator.WEIGHT, "35");

		appliance = service.find(refrigeratorCriteria);

		PrintApplianceInfo.print(appliance);

		Criteria<Laptop> laptopCriteria = new Criteria<>();
		laptopCriteria.setApplianceType("Laptop");
		laptopCriteria.add(Laptop.BATTERY_CAPACITY, 1.5);
		laptopCriteria.add(Laptop.CPU, 2.2);
		laptopCriteria.add(Laptop.DISPLAY_INCHS, 19);
		laptopCriteria.add(Laptop.MEMORY_ROM, 8000);
		laptopCriteria.add(Laptop.OS, "Linux");

		appliance = service.find(laptopCriteria);

		PrintApplianceInfo.print(appliance);

	}

}
