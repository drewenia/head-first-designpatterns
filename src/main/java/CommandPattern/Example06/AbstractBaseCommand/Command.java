package CommandPattern.Example06.AbstractBaseCommand;

import CommandPattern.Example06.Gui.Editor;

public abstract class Command {
    public Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup(){
        this.backup = editor.textField.getText();
    }

    public void undo(){
        editor.textField.setText(this.backup);
    }

    public abstract boolean execute();
}
