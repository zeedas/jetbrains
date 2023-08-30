/* ==========================================================
File:        CustomExecutionListener.java
Description: Logs time from compile and build events.
License:     BSD, see LICENSE for more details.
Website:     https://zeedas.com/
===========================================================*/

package com.zeedas.intellij.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.UUID;

public class CustomBuildManagerListener {
    public void buildStarted(@NotNull Project project, @NotNull UUID sessionId, boolean isAutomake) {
        // WakaTime.log.debug("buildStarted event");
        if (!WakaTime.isAppActive()) return;
        if (!WakaTime.isProjectInitialized(project)) return;
        EventQueue.invokeLater(() -> {
            VirtualFile file = WakaTime.getCurrentFile(project);
            if (file == null) return;
            WakaTime.isBuilding = true;
            WakaTime.appendHeartbeat(file, project, false, null);
        });
    }

    public void buildFinished(@NotNull Project project, @NotNull UUID sessionId, boolean isAutomake)  {
        // WakaTime.log.debug("buildFinished event");
        WakaTime.isBuilding = false;
    }

    public void compilationFinished(boolean aborted, int errors, int warnings) {
        // WakaTime.log.debug("compilationFinished event");
        WakaTime.isBuilding = false;
    }

    public void automakeCompilationFinished(int errors, int warnings) {
        // WakaTime.log.debug("automakeCompilationFinished event");
        WakaTime.isBuilding = false;
    }
}
