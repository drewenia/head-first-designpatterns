package CommandPattern.Example06.Gui;

import CommandPattern.Example06.AbstractBaseCommand.Command;
import CommandPattern.Example06.ConcreteCommands.CommandHistory;
import CommandPattern.Example06.ConcreteCommands.CopyCommand;
import CommandPattern.Example06.ConcreteCommands.CutCommand;
import CommandPattern.Example06.ConcreteCommands.PasteCommand;

import javax.swing.*;
import java.awt.*;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory commandHistory;

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = getButtonsAndCommands();
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getButtonsAndCommands() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;

        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));

        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));

        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));

        ctrlZ.addActionListener(e -> undo());

        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        return buttons;
    }
    private void executeCommand(Command command){
        if (command.execute()){
            commandHistory.push(command);
        }
    }

    private void undo() {
        if (commandHistory.isEmpty()) return;

        Command command = commandHistory.pop();
        if (command != null){
            command.undo();
        }
    }
}
