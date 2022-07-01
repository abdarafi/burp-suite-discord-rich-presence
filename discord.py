from burp import IBurpExtender
from java.io import PrintWriter

class BurpExtender(IBurpExtender):
    def registerExtenderCallbacks(self, callbacks):
        self.__callbacks = callbacks
        self.__helpers = callbacks.getHelpers()
        callbacks.setExtensionName("Enable Discord Rich Presence")
        stdout = PrintWriter(callbacks.getStdout(), True)
        stdout.println("Successfully loaded.")