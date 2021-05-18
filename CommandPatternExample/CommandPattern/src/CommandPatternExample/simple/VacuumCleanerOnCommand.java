package CommandPatternExample.simple;

import model.VacuumCleaner;

public class VacuumCleanerOnCommand implements Command {
    VacuumCleaner vacuumCleaner;

    public VacuumCleanerOnCommand(VacuumCleaner vacuumCleaner) {
        this.vacuumCleaner = vacuumCleaner;
    }

    public void execute() {
        vacuumCleaner.on();
        System.out.println(this.vacuumCleaner.getName() + " vacuum cleaner on.");
    }

}
