/* ==========================================================
File:        PluginMenu.java
Description: Adds a Zeedas item to the File menu.
License:     BSD, see LICENSE for more details.
Website:     https://zeedas.com/
===========================================================*/

package com.zeedas.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class PluginMenu extends AnAction {
    public PluginMenu() {
        super("Zeedas Settings");
        // super("WakaTime Settings", "", IconLoader.getIcon("/Mypackage/icon.png"));
    }
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        Settings popup = new Settings(project);
        popup.show();
    }
}
