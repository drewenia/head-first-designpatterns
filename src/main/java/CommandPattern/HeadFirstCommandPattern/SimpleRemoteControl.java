package CommandPattern.HeadFirstCommandPattern;

import CommandPattern.HeadFirstCommandPattern.Command.Command;

public class SimpleRemoteControl {

    /* Bir command'i tutmak için bir slot bulunur ve bu command bir cihazı kontrol eder.*/
    Command slot;

    /* Slot tarafından kontrol edilecek command'i ayarlamak için bir setter methodumuz var. Bu kodun client'i,
    uzaktan kumanda düğmesinin davranışını değiştirmek istiyorsa bu methodu birden fazla kez çağırabilir.*/
    public void setCommand(Command command){
        this.slot = command;
    }

    /* Bu method, düğme basıldığında çağrılır. Tek yapmamız gereken, slot'a bağlı olan mevcut komutu almak ve onun
    execute() methodunu çağırmaktır.*/
    public void buttonPressed(){
        this.slot.execute();
    }
}
