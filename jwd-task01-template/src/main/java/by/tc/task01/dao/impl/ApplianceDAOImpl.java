package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String FILEPATH = "D:\\Epam\\JWD_Task01_OOP\\jwd-task01-template\\src\\main\\resources\\appliances_db.txt";

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILEPATH)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(getCriteriaShortClassName(criteria.getSearchCriteriaClassName())) && isProperLine(line, criteria)) {

                    if (criteria.getSearchCriteriaClassName().contains("Oven")) {
                        return findOvenObject(line);
                    } else if (criteria.getSearchCriteriaClassName().contains("Laptop")) {
                        return findLaptopObject(line);
                    } else if (criteria.getSearchCriteriaClassName().contains("Refrigerator")) {
                        return findRefrigeratorObject(line);
                    } else if (criteria.getSearchCriteriaClassName().contains("Speakers")) {
                        return findSpeakersObject(line);
                    } else if (criteria.getSearchCriteriaClassName().contains("TabletPC")) {
                        return findTabletPCObject(line);
                    } else if (criteria.getSearchCriteriaClassName().contains("VacuumCleaner")) {
                        return findVacuumCleanerObject(line);
                    } else {
                        return null;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getCriteriaShortClassName(String longName){
        Pattern p = Pattern.compile("\\$(\\S)+");
        Matcher m = p.matcher(longName);
        String value = "";
        if (m.find()) {
            value = longName.substring(m.start()+1, m.end());
        }
        return value;
    }

    private <E> boolean isProperLine(String line, Criteria<E> criteria) {
        boolean result = false;
        for (E searchCriteria : criteria.getCriteria().keySet()) {
            Object value = criteria.getValue(searchCriteria);

            if (criteriaPresentsInLine(line, searchCriteria, value)) {
                result = true;
            } else {
                result = false;
            }
            if (!result) {
                return false;
            }
        }
        return result;
    }

    private <E> boolean criteriaPresentsInLine(String line, E searchCriteria, Object value) {
        List<String> criteriaAndValues = parseCriteriaAndValues(line);

        for (String criteriaAndValue: criteriaAndValues){
            if (criteriaAndValue.equalsIgnoreCase(searchCriteria+"="+value.toString().trim())){
                return true;
            }
        }
        return false;
    }

    private List<String> parseCriteriaAndValues(String line) {
        Pattern p = Pattern.compile("(\\S)+=(\\S)+");
        Matcher m = p.matcher(line);
        List<String> values = new ArrayList<>();
        while (m.find()) {
            values.add(line.substring(m.start(), m.end() - 1));
        }
        return values;
    }

    private Appliance findOvenObject(String line) {
        List<String> values = parseValues(line);
        Oven oven = new Oven();
        oven.setPowerConsumption(Integer.parseInt(values.get(0)));
        oven.setWeight(Double.parseDouble(values.get(1)));
        oven.setCapacity(Integer.parseInt(values.get(2)));
        oven.setDepth(Integer.parseInt(values.get(3)));
        oven.setHeight(Double.parseDouble(values.get(4)));
        oven.setWidth(Double.parseDouble(values.get(5)));
        return oven;
    }

    private Appliance findLaptopObject(String line) {
        List<String> values = parseValues(line);
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(Double.parseDouble(values.get(0)));
        laptop.setOperatingSystem(values.get(1));
        laptop.setMemoryRom(Integer.parseInt(values.get(2)));
        laptop.setSystemMemory(Integer.parseInt(values.get(3)));
        laptop.setCentralProcessorUnit(Double.parseDouble(values.get(4)));
        laptop.setDisplayInches(Integer.parseInt(values.get(5)));
        return laptop;
    }

    private Appliance findRefrigeratorObject(String line) {
        List<String> values = parseValues(line);
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(Integer.parseInt(values.get(0)));
        refrigerator.setWeight(Double.parseDouble(values.get(1)));
        refrigerator.setFreezerCapacity(Integer.parseInt(values.get(2)));
        refrigerator.setOverallCapacity(Double.parseDouble(values.get(3)));
        refrigerator.setHeight(Double.parseDouble(values.get(4)));
        refrigerator.setWidth(Double.parseDouble(values.get(5)));
        return refrigerator;
    }

    private Appliance findSpeakersObject(String line) {
        List<String> values = parseValues(line);
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(Integer.parseInt(values.get(0)));
        speakers.setNumberOfSpeakers(Integer.parseInt(values.get(1)));
        speakers.setFrequencyRange(values.get(2));
        speakers.setCordLength(Integer.parseInt(values.get(3)));

        return speakers;
    }

    private Appliance findTabletPCObject(String line) {
        List<String> values = parseValues(line);
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(Double.parseDouble(values.get(0)));
        tabletPC.setDisplayInches(Integer.parseInt(values.get(1)));
        tabletPC.setMemoryRom(Integer.parseInt(values.get(2)));
        tabletPC.setFlashMemoryCapacity(Integer.parseInt(values.get(3)));
        tabletPC.setColor(values.get(4));
        System.out.println(tabletPC.getColor());
        return tabletPC;
    }

    private Appliance findVacuumCleanerObject(String line) {
        List<String> values = parseValues(line);
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(Integer.parseInt(values.get(0)));
        vacuumCleaner.setFilterType(values.get(1));
        vacuumCleaner.setBagType(values.get(2));
        vacuumCleaner.setWandType(values.get(3));
        vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(values.get(4)));
        vacuumCleaner.setCleaningWidth(Integer.parseInt(values.get(5)));
        return vacuumCleaner;
    }


    private List<String> parseValues(String line) {
        Pattern p = Pattern.compile("=(\\S)+");
        Matcher m = p.matcher(line);
        List<String> values = new ArrayList<>();
        while (m.find()) {
            values.add(line.substring(m.start() + 1, m.end() - 1));
        }
        return values;
    }


}


//you may add your own new classes