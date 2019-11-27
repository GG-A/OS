/*
 * Copyright 2019 GG-A, <2018158885@qq.com, https://github.com/GG-A/OS>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.gg_a.os;


import java.io.File;

/**
 * OS util for getting system info. <br>
 * 获取操作系统信息类
 * @author GG
 * @version 0.0.1
 */
public final class OS {
    /**
     * Operating System name. <br>
     * 操作系统名称
     */
    public static final String OS_NAME = getProperty("os.name");
    private static final String os = OS_NAME == null ? "" : OS_NAME.toLowerCase();
    /**
     * Operating System version. <br>
     * 操作系统版本号
     */
    public static final String OS_VERSION = getProperty("os.version");
    /**
     * Operating System architecture. <br>
     * 操作系统架构
     */
    public static final String OS_ARCH = getProperty("os.arch");

    /**
     * User Home folder. <br>
     * 用户home目录
     */
    public static final String USER_HOME = getProperty("user.home");
    /**
     * User Language. <br>
     * 当前用户使用的语言
     */
    public static final String USER_LANGUAGE = getProperty("user.language");
    /**
     * User Timezone. <br>
     * 当前用户使用的时区
     */
    public static final String USER_TIMEZONE = getProperty("user.timezone");

    /**
     * The system-dependent Awt Toolkit class name. <br>
     * 当前操作系统Awt Toolkit类名
     */
    public static final String AWT_TOOLKIT_CLASSNAME = getProperty("awt.toolkit");

    /**
     * The system-dependent line separator string. <br>
     *
     * <p>On UNIX systems, it returns {@code "\n"};  <br>
     * on Microsoft Windows systems it returns {@code "\r\n"}.  <br> <br>
     * 当前系统行分隔符。在UNIX系统是"\n"；在Windows系统中是"\r\n"
     */
    public static final String LINE_SEPARATOR = System.lineSeparator();
    /**
     * The system-dependent default name-separator character.  <br>
     * <p>On UNIX systems the value of this field is <code>'/'</code>; <br>
     * on Microsoft Windows systems it is <code>'\\'</code>.  <br><br>
     * 当前系统路径中文件夹层级分隔符。在UNIX系统中是'/'；在Windows系统中是'\\'
     */
    public static final String FILE_SEPARATOR = File.separator;
    /**
     * The system-dependent path-separator character.  <br>
     * <p>On UNIX systems, this character is <code>':'</code>;   <br>
     * on Microsoft Windows systems it is <code>';'</code>.  <br><br>
     * 当前系统路径列表（路径与路径之间）的分隔符。在UNIX系统中是':'；在Windows系统中是';'
     */
    public static final String PATH_SEPARATOR = File.pathSeparator;


    /*
     * Mac操作系统版本参考以下网址 （Mac OS version refer to the following website）：
     * https://en.wikipedia.org/wiki/MacOS#Release_history
     */
    private static final boolean IS_PRE_MACOSX = os.startsWith("mac os x");
    public static final boolean IS_MACOS_CATALINA = IS_PRE_MACOSX && macOSVerCompare("10.15");
    public static final boolean IS_MACOS_MOJAVE = IS_PRE_MACOSX && macOSVerCompare("10.14");
    public static final boolean IS_MACOS_HIGH_SIERRA = IS_PRE_MACOSX && macOSVerCompare("10.13");
    public static final boolean IS_MACOS_SIERRA = IS_PRE_MACOSX && macOSVerCompare("10.12");
    public static final boolean IS_MAC_OS_X_EL_CAPITAN = IS_PRE_MACOSX && macOSVerCompare("10.11");
    public static final boolean IS_MAC_OS_X_YOSEMITE = IS_PRE_MACOSX && macOSVerCompare("10.10");
    public static final boolean IS_MAC_OS_X_MAVERICKS = IS_PRE_MACOSX && macOSVerCompare("10.9");
    public static final boolean IS_MAC_OS_X_MOUNTAIN_LION = IS_PRE_MACOSX && macOSVerCompare("10.8");
    public static final boolean IS_MAC_OS_X_LION = IS_PRE_MACOSX && macOSVerCompare("10.7");
    public static final boolean IS_MAC_OS_X_SNOW_LEOPARD = IS_PRE_MACOSX && macOSVerCompare("10.6");
    public static final boolean IS_MAC_OS_X_LEOPARD = IS_PRE_MACOSX && macOSVerCompare("10.5");
    public static final boolean IS_MAC_OS_X_TIGER = IS_PRE_MACOSX && macOSVerCompare("10.4");
    public static final boolean IS_MAC_OS_X_PANTHER = IS_PRE_MACOSX && macOSVerCompare("10.3");
    public static final boolean IS_MAC_OS_X_JAGUAR = IS_PRE_MACOSX && macOSVerCompare("10.2");
    public static final boolean IS_MAC_OS_X_PUMA = IS_PRE_MACOSX && macOSVerCompare("10.1");
    public static final boolean IS_MAC_OS_X_CHEETAH = IS_PRE_MACOSX && macOSVerCompare("10.0");
    /**
     * The value is {@code true} if current Operating System is Mac. <br>
     * 如果当前操作系统是Mac系统，那么值为true。
     */
    public static final boolean IS_MAC = os.startsWith("mac os");
    /**
     * The value is {@code true} if current Operating System is "macOS". <br>
     * 如果当前操作系统是macOS系统（2016年，"OS X"更名为"macOS"），那么值为true。
     */
    public static final boolean IS_MACOS = IS_MACOS_SIERRA || IS_MACOS_HIGH_SIERRA || IS_MACOS_MOJAVE || IS_MACOS_CATALINA;
    /**
     * The value is {@code true} if current Operating System is "Mac OS X" or "OS X". <br>
     * 如果当前操作系统是Mac OS X或OS X系统，那么值为true。
     */
    public static final boolean IS_MAC_OS_X = IS_MAC_OS_X_CHEETAH || IS_MAC_OS_X_PUMA || IS_MAC_OS_X_JAGUAR || IS_MAC_OS_X_PANTHER
                                    || IS_MAC_OS_X_TIGER || IS_MAC_OS_X_LEOPARD || IS_MAC_OS_X_SNOW_LEOPARD || IS_MAC_OS_X_LION
                                    || IS_MAC_OS_X_MOUNTAIN_LION || IS_MAC_OS_X_MAVERICKS || IS_MAC_OS_X_YOSEMITE || IS_MAC_OS_X_EL_CAPITAN;


    /*
     * windows版本参考以下网址（windows version refer to the following website）：
     * https://en.wikipedia.org/wiki/List_of_Microsoft_Windows_versions
     */
    /**
     * The value is {@code true} if current Operating System is Windows. <br>
     * 如果当前操作系统是Windows系统，那么值为true。
     */
    public final static boolean IS_WINDOWS = os.startsWith("windows");
    public static final boolean IS_WINDOWS_10 = os.startsWith("windows 10");
    public static final boolean IS_WINDOWS_8 = os.startsWith("windows 8");
    public static final boolean IS_WINDOWS_7 = os.startsWith("windows 7");
    public static final boolean IS_WINDOWS_VISTA = os.startsWith("windows vista");
    public static final boolean IS_WINDOWS_XP = os.startsWith("windows xp");
    public static final boolean IS_WINDOWS_ME = os.startsWith("windows me");
    public static final boolean IS_WINDOWS_2000 = os.startsWith("windows 2000");
    public static final boolean IS_WINDOWS_98 = os.startsWith("windows 98");
    public static final boolean IS_WINDOWS_95 = os.startsWith("windows 95");
    public static final boolean IS_WINDOWS_NT = os.startsWith("windows nt");
    public static final boolean IS_WINDOWS_SERVER_2019 = os.startsWith("windows server 2019");
    public static final boolean IS_WINDOWS_SERVER_2016 = os.startsWith("windows server 2016");
    public static final boolean IS_WINDOWS_SERVER_2012 = os.startsWith("windows server 2012");
    public static final boolean IS_WINDOWS_SERVER_2008 = os.startsWith("windows server 2008");
    public static final boolean IS_WINDOWS_SERVER_2003 = os.startsWith("windows server 2003");

    /*
     * 其他常用操作系统（other commonly used Operating System）
     */
    /**
     * The value is {@code true} if current Operating System is Linux. <br>
     * 如果当前操作系统是Linux系统，那么值为true。
     */
    public static final boolean IS_LINUX = os.startsWith("linux");
    public static final boolean IS_FREEBSD = os.startsWith("freebsd");
    public static final boolean IS_NETBSD = os.startsWith("netbsd");
    public static final boolean IS_FUCHSIA = os.startsWith("fuchsia");
    public static final boolean IS_SOLARIS = os.startsWith("solaris");
    public static final boolean IS_SUNOS = os.startsWith("sunos");
    public static final boolean IS_HP_UX = os.startsWith("hp-ux");
    public static final boolean IS_OS_400 = os.startsWith("os/400");
    public static final boolean IS_OS_2 = os.startsWith("os/2");
    public static final boolean IS_Z_OS = os.startsWith("z/os");


    private static boolean macOSVerCompare(String version){
        int secondIndex = OS_VERSION.indexOf(".", OS_VERSION.indexOf(".") + 1);
        return secondIndex == -1 ? OS_VERSION.equals(version) : OS_VERSION.substring(0, secondIndex).equals(version);
    }

    private static String getProperty(String propertyKey) {
        String prop = null;
        try {
            prop = System.getProperty(propertyKey);
        } catch (final SecurityException ex) {
            ex.printStackTrace();
        }
        return prop;
    }


}
