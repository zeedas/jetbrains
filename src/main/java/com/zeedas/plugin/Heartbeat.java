/* ==========================================================
File:        Heartbeat.java
Description: Stores coding activity waiting to be sent to the api.
License:     BSD, see LICENSE for more details.
Website:     https://zeedas.com/
===========================================================*/

package com.zeedas.plugin;

import java.math.BigDecimal;

public class Heartbeat {
    public String entity;
    public Integer lineCount;
    public Integer lineNumber;
    public Integer cursorPosition;
    public BigDecimal timestamp;
    public Boolean isWrite;
    public Boolean isUnsavedFile;
    public String project;
    public String language;
    public Boolean isBuilding;
}
