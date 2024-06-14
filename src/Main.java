interface Voltage220
{
    public void use220V();
}

class V220device implements Voltage220
{
    public void use220V()
    {
        System.out.println("220 вольт");
    }
}

interface Voltage380
{
    public void use380V();
}

class V380device implements Voltage380
{
    public void use380V()
    {
        System.out.println("380 вольт");
    }
}

class Device
{
    private Voltage220 voltage220;
    public Device(Voltage220 voltage220)
    {
        this.voltage220 = voltage220;
    }

    public void Charging()
    {
        voltage220.use220V();
    }
}

class Adapter implements Voltage220
{
    Voltage380 voltage380;
    public Adapter(Voltage380 voltage380)
    {
        this.voltage380 = voltage380;
    }

    public void use220V()
    {
        voltage380.use380V();
    }
}

public class Main {
    public static void main(String[] args)
    {

        Voltage220 voltage220 = new V220device();
        Device device = new Device(voltage220);
        device.Charging();
        V380device v380device = new V380device();
        Adapter adapter = new Adapter(v380device);
        Device ud380 = new Device(adapter);
        ud380.Charging();
    }
}