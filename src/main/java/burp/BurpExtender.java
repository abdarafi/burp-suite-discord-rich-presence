package burp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BurpExtender implements IBurpExtender, ITab, IHttpListener, IContextMenuFactory {

    private static IBurpExtenderCallbacks callbacks;
    private static IExtensionHelpers helpers;
    private static JPanel rootPanel;
    private static DiscordBurp discordBurp;

    @Override
    public void registerExtenderCallbacks (final IBurpExtenderCallbacks callbacks) {
        BurpExtender.callbacks = callbacks;
        BurpExtender.helpers = callbacks.getHelpers();
        // Extension Name
        callbacks.setExtensionName("Discord Presence");
        discordBurp = new DiscordBurp();
        rootPanel = discordBurp.getUI();
        callbacks.customizeUiComponent(rootPanel);
        callbacks.addSuiteTab(BurpExtender.this);
        callbacks.registerHttpListener(BurpExtender.this);
        callbacks.registerContextMenuFactory(BurpExtender.this);
    }

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) { return null; }

    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
        if (messageIsRequest) {
            discordBurp.modifyRequest(messageInfo);
        }
    }
    public static IBurpExtenderCallbacks getCallbacks() {
        return callbacks;
    }

    @Override
    public String getTabCaption() {
        return "Discord Presence";
    }

    @Override
    public Component getUiComponent() {
        return rootPanel;
    }
}
