package burp;

import javax.swing.*;

public class DiscordBurp {
    public static final int textHeight = new JTextField().getPreferredSize().height;
    private JPanel mainPanel, gridPanel;
    private IExtensionHelpers helpers;
    private IBurpExtenderCallbacks callbacks;
    public DiscordBurp() {
        this.callbacks = BurpExtender.getCallbacks();
        helpers = callbacks.getHelpers();
        createUI();
    }

    private void createUI() {

    }

    public JPanel getUI() { return mainPanel; }

    public void modifyRequest(IHttpRequestResponse messageInfo) {

    }
}
