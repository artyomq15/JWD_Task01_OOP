package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;

import java.util.List;

public interface CreatorCommand {
    Appliance execute(List<String> values);
}
