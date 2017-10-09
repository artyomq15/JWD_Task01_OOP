package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creator.CreatorCommand;
import by.tc.task01.dao.director.ApplianceDirector;
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
        return getObjectFromFile(criteria);
    }

    private <E> Appliance getObjectFromFile(Criteria<E> criteria){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILEPATH)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isProperLine(line,criteria)) {
                    return getObject(line, criteria);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    private <E> boolean isProperLine(String line, Criteria<E> criteria){
        return  lineStartsWithProperClassName(line, criteria.getApplianceType())&& lineHasProperValues(line, criteria);
    }

    private boolean lineStartsWithProperClassName(String line, String className){
        return line.startsWith(className);
    }

    private <E> boolean lineHasProperValues(String line, Criteria<E> criteria) {
        List<String> criteriaAndValuesFromLine = parseCriteriaAndValues(line);

        for (E searchCriteria : criteria.getCriteria().keySet()) {
            Object value = criteria.getValue(searchCriteria);

            if (!criteriaPresentsInLine(criteriaAndValuesFromLine, searchCriteria, value)) {
                return false;
            }
        }
        return true;
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

    private <E> boolean criteriaPresentsInLine(List<String> criteriaAndValuesFromLine, E searchCriteria, Object value) {
        for (String criteriaAndValueFromLine: criteriaAndValuesFromLine){
            if (criteriaAndValueFromLine.equalsIgnoreCase(searchCriteria+"="+value.toString().trim())){
                return true;
            }
        }
        return false;
    }



    private <E> Appliance getObject(String line, Criteria<E> criteria){
        List<String> values = parseValues(line);

        ApplianceDirector applianceDirector = new ApplianceDirector();
        CreatorCommand creatorCommand = applianceDirector.getCreatorCommand(criteria.getApplianceType());

        Appliance appliance = creatorCommand.execute(values);

        return appliance;

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
