package CommandPattern.Example06.ConcreteCommands;

import CommandPattern.Example06.AbstractBaseCommand.Command;
import CommandPattern.Example06.Gui.Editor;

public class CopyCommand extends Command {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
