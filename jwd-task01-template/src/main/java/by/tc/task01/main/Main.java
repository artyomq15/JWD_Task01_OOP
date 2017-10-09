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
		criteriaTabletPC.add(TabletPC.COLOR, "gReen");
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




	}

}
