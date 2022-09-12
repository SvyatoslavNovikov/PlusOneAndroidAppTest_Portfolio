package jcactus;

public class Device {

    private String device_name;
    private String udid;
    private String platform_name;
    private String platform_version;

    public Device (String name) {
        PropertyLoader prop = new PropertyLoader(name.concat(".properties"));
        this.device_name = prop.getProperty("DEVICE_NAME");
        this.udid = prop.getProperty("UDID");
        this.platform_name = prop.getProperty("PLATFORM_NAME");
        this.platform_version = prop.getProperty("PLATFORM_VERSION");
    }

    public String getDeviceName() {
        return device_name;
    }

    public String getUdid() {
        return udid;
    }

    public String getPlatformName() {
        return platform_name;
    }

    public String getPlatformVersion() {
        return platform_version;
    }
}
