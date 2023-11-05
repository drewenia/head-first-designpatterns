package CommandPattern.Example06.ConcreteCommands;

import CommandPattern.Example06.AbstractBaseCommand.Command;
import CommandPattern.Example06.Gui.Editor;

public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard,editor.textField.getCaretPosition());
        return true;
    }
}
