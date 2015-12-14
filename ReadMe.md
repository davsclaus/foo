Camel Addon IDEA bug
====================

To reproduce the issue open this project in IDEA 15. 

Install JBoss Forge in IDEA.

Install the Camel addon

    http://fabric8.io/guide/forge.html

Its the camel addon (not the commands), eg

    addon-install --coordinate io.fabric8.forge:camel,2.2.76

In the project activate forge `cmd + alt 4``
 
Select the `camel-edit-endpoint` command

select `seda:a` as the endpoint, and in the wizard, set `concurrentConsumers` to the value of `2` and click finish.
  The source code should be updated to:

          from("seda:a?concurrentConsumers=2")
              .to("seda:b")
              .to("seda:c");

Now run the same command again, `camel-edit-endpoint` and this time select `seda:b` when clicking Next you get an exception


```
Error while moving to the next wizard step
java.lang.IllegalStateException: Error while moving to the next wizard step
	at org.jboss.forge.addon.ui.impl.controller.WizardCommandControllerImpl.refreshFlow(WizardCommandControllerImpl.java:108)
	at org.jboss.forge.addon.ui.impl.controller.WizardCommandControllerImpl.canExecute(WizardCommandControllerImpl.java:320)
	at org.jboss.forge.addon.ui.impl.controller.NoUIWizardControllerDecorator.canExecute(NoUIWizardControllerDecorator.java:231)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.jboss.forge.furnace.proxy.ClassLoaderAdapterCallback$2.call(ClassLoaderAdapterCallback.java:123)
	at org.jboss.forge.furnace.util.ClassLoaders.executeIn(ClassLoaders.java:42)
	at org.jboss.forge.furnace.proxy.ClassLoaderAdapterCallback.invoke(ClassLoaderAdapterCallback.java:96)
	at org.jboss.forge.addon.ui.controller.CommandController_$$_javassist_97e36000-0c87-46f6-a4fa-e12b5d1e5f12.canExecute(CommandController_$$_javassist_97e36000-0c87-46f6-a4fa-e12b5d1e5f12.java)
	at org.jboss.forge.plugin.idea.ui.wizard.NavigationState.isFinishEnabled(NavigationState.java:72)
	at org.jboss.forge.plugin.idea.ui.wizard.NavigationState.refreshNavigationState(NavigationState.java:37)
	at org.jboss.forge.plugin.idea.ui.wizard.ForgeWizardStep.prepare(ForgeWizardStep.java:78)
	at com.intellij.ui.wizard.WizardModel.a(WizardModel.java:173)
	at com.intellij.ui.wizard.WizardModel.b(WizardModel.java:91)
	at com.intellij.ui.wizard.WizardModel.next(WizardModel.java:76)
	at com.intellij.ui.wizard.WizardAction$Next.actionPerformed(WizardAction.java:46)
	at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2022)
	at javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2348)
	at javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:402)
	at javax.swing.DefaultButtonModel.setPressed(DefaultButtonModel.java:259)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(BasicButtonListener.java:252)
	at java.awt.Component.processMouseEvent(Component.java:6535)
	at javax.swing.JComponent.processMouseEvent(JComponent.java:3324)
	at java.awt.Component.processEvent(Component.java:6300)
	at java.awt.Container.processEvent(Container.java:2236)
	at java.awt.Component.dispatchEventImpl(Component.java:4891)
	at java.awt.Container.dispatchEventImpl(Container.java:2294)
	at java.awt.Component.dispatchEvent(Component.java:4713)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4888)
	at java.awt.LightweightDispatcher.processMouseEvent(Container.java:4525)
	at java.awt.LightweightDispatcher.dispatchEvent(Container.java:4466)
	at java.awt.Container.dispatchEventImpl(Container.java:2280)
	at java.awt.Window.dispatchEventImpl(Window.java:2750)
	at java.awt.Component.dispatchEvent(Component.java:4713)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:758)
	at java.awt.EventQueue.access$500(EventQueue.java:97)
	at java.awt.EventQueue$3.run(EventQueue.java:709)
	at java.awt.EventQueue$3.run(EventQueue.java:703)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:76)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:86)
	at java.awt.EventQueue$4.run(EventQueue.java:731)
	at java.awt.EventQueue$4.run(EventQueue.java:729)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:76)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:728)
	at com.intellij.ide.IdeEventQueue.f(IdeEventQueue.java:866)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:650)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:381)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:109)
	at java.awt.WaitDispatchSupport$2.run(WaitDispatchSupport.java:184)
	at java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:229)
	at java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:227)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.awt.WaitDispatchSupport.enter(WaitDispatchSupport.java:227)
	at java.awt.Dialog.show(Dialog.java:1084)
	at com.intellij.openapi.ui.impl.DialogWrapperPeerImpl$MyDialog.show(DialogWrapperPeerImpl.java:792)
	at com.intellij.openapi.ui.impl.DialogWrapperPeerImpl.show(DialogWrapperPeerImpl.java:465)
	at com.intellij.openapi.ui.DialogWrapper.invokeShow(DialogWrapper.java:1638)
	at com.intellij.openapi.ui.DialogWrapper.show(DialogWrapper.java:1587)
	at org.jboss.forge.plugin.idea.ui.CommandListPopupBuilder.openWizard(CommandListPopupBuilder.java:224)
	at org.jboss.forge.plugin.idea.ui.CommandListPopupBuilder.access$300(CommandListPopupBuilder.java:54)
	at org.jboss.forge.plugin.idea.ui.CommandListPopupBuilder$3.run(CommandListPopupBuilder.java:173)
	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:311)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:756)
	at java.awt.EventQueue.access$500(EventQueue.java:97)
	at java.awt.EventQueue$3.run(EventQueue.java:709)
	at java.awt.EventQueue$3.run(EventQueue.java:703)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:76)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:726)
	at com.intellij.ide.IdeEventQueue.f(IdeEventQueue.java:866)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:654)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:381)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
	at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)
Caused by: java.lang.IllegalStateException: No next step found
	at org.jboss.forge.addon.ui.impl.controller.WizardCommandControllerImpl.addNextFlowStep(WizardCommandControllerImpl.java:446)
	at org.jboss.forge.addon.ui.impl.controller.WizardCommandControllerImpl.next(WizardCommandControllerImpl.java:358)
	at org.jboss.forge.addon.ui.impl.controller.WizardCommandControllerImpl.refreshFlow(WizardCommandControllerImpl.java:104)
	... 83 more
```

The UI only works for these endpoints in the list has `>=` number of steps as the 1st endpoint.
So if the first have 3 steps, then only if you have 3+ steps will also work. For example

        from("timer:foo")
            .to("seda:b")
            .to("log:c");

The 1st endpoint `timer:foo` has 2 steps. So the other works because they have 2 and 3 steps.


