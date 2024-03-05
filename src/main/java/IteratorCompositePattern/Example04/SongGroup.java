package IteratorCompositePattern.Example04;

import java.util.ArrayList;

public class SongGroup extends SongComponent {
    ArrayList<SongComponent> songComponents = new ArrayList<>();
    String groupName;
    String groupDescription;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public void add(SongComponent songComponent) {
        songComponents.add(songComponent);
    }

    @Override
    public void remove(SongComponent songComponent) {
        songComponents.remove(songComponent);
    }

    public SongComponent getComponent(int componentIndex) {
        return songComponents.get(componentIndex);
    }

    public void displaySongInfo() {
        System.out.println(getGroupName() + " " + getGroupDescription() + "\n");
        for (SongComponent songInfo : songComponents) {
            songInfo.displaySongInfo();
        }
    }
}
