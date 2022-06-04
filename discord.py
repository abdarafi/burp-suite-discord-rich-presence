from burp import IBurpExtender

class BurpExtender(IBurpExtender):
    def registerExtenderCallbacks(self, callbacks):
        self.__callbacks = callbacks
        self.__helpers = callbacks.getHelpers()
        callbacks.setExtensionName("Enable Discord Rich Presence")
        print("Successfully loaded.")