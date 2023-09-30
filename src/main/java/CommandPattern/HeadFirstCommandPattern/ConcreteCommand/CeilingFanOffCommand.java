package CommandPattern.HeadFirstCommandPattern.ConcreteCommand;

import CommandPattern.HeadFirstCommandPattern.CeilingFan;
import CommandPattern.HeadFirstCommandPattern.Command.Command;

public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        /* Çalıştırmadan önce, vantilatörün hızını değiştirmeden önce, eylemlerimizi geri almak zorunda kalırsak
        previous speed state'ini kaydetmemiz gerekiyor*/
        this.prevSpeed = ceilingFan.getSpeed();
        this.ceilingFan.off();
    }

    @Override
    public void undo() {
        /* Undo işlemi için vantilatörün hızını önceki hızına geri ayarlıyoruz*/
        if (this.prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (this.prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
