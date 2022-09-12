package addon;

import io.testproject.sdk.internal.addons.ActionProxy;
import io.testproject.sdk.internal.addons.ProxyDescriptor;
import java.lang.String;

/**
 * Proxy for Tap and Get Toast Message Addon */
public class TapandGetToastMessage {
  /**
   * Factory method for TapAndGetToast */
  public static TapAndGetToast getTapAndGetToast() {
    return new TapAndGetToast();
  }

  /**
   * Tap and Get Toast Message. Tapping on the element which triggers a toast message and retrieving it's text */
  public static class TapAndGetToast extends ActionProxy {
    /**
     * Toast Message (OUTPUT) */
    public String output;

    public TapAndGetToast() {
      this.setDescriptor(new ProxyDescriptor("26GUF78PoEyq5bkIdYAiYg", "TapAndGetToast"));
    }
  }
}
