package CommandPatternExample.complex;

import CommandPatternExample.simple.Command;
import model.VacuumCleaner;

public class VacuumCleanerOffCommand implements Command {
    VacuumCleaner vacuumCleaner;

    public VacuumCleanerOffCommand(VacuumCleaner vacuumCleaner) {
        this.vacuumCleaner = vacuumCleaner;
    }

    public void execute() {
        vacuumCleaner.off();
        System.out.println(this.vacuumCleaner.getName() + " vacuum cleaner off.");
    }

}
