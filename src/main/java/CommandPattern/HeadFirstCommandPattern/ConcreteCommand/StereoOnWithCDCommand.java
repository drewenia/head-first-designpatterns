package CommandPattern.HeadFirstCommandPattern.ConcreteCommand;

import CommandPattern.HeadFirstCommandPattern.Command.Command;
import CommandPattern.HeadFirstCommandPattern.Stereo;

public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /* Bu isteği gerçekleştirmek için Stereo üzerinde üç methodu çağırmamız gerekiyor: İlk olarak, Stereo'yu açarız,
    ardından CD çalmak üzere ayarlarız ve son olarak ses seviyesini 11 olarak ayarlarız. */
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
