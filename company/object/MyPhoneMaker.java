package company.object;

public class MyPhoneMaker {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.hasFigurePrintUnlocker = true;
        phone.price = 1999;
        phone.screen = new Screen();

        phone.screen.producer = "JDF";
        phone.screen.size = 8.8;

        CPU cpu = new CPU();
        cpu.producer = "Intel";
        cpu.speed = 3.5;

        Memory memory = new Memory();
        memory.capacity = 4;
        memory.producer = "SAM";

        Storage storage = new Storage();
        storage.capacity = 128;
        storage.producer = "amd";

        phone.mainboard = new Mainboard();

        phone.mainboard.cpu = cpu;
        phone.mainboard.memory = memory;
        phone.mainboard.storage = storage;

        phone.mainboard.model = "EA888";
        phone.mainboard.year = 2019;

        phone.prePhone = new Phone();


    }
}
