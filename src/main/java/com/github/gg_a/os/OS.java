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


/**
 * @author GG
 * @version 0.0.1
 */
public final class OS {
    public static final String OS_NAME = getProperty("os.name");
    private static final String os = OS_NAME.toLowerCase();
    public static final String OS_VERSION = getProperty("os.version");
    public static final String OS_ARCH = getProperty("os.arch");

    public static final String USER_HOME = getProperty("user.home");
    public static final String USER_LANGUAGE = getProperty("user.language");
    public static final String USER_TIMEZONE = getProperty("user.timezone");

    public static final String AWT_TOOLKIT_CLASSNAME = getProperty("awt.toolkit");

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

    public static final boolean IS_MAC = os.startsWith("mac os");
    public static final boolean IS_MACOS = IS_MACOS_SIERRA || IS_MACOS_HIGH_SIERRA || IS_MACOS_MOJAVE || IS_MACOS_CATALINA;
    public static final boolean IS_MAC_OS_X = IS_MAC_OS_X_CHEETAH || IS_MAC_OS_X_PUMA || IS_MAC_OS_X_JAGUAR || IS_MAC_OS_X_PANTHER
                                    || IS_MAC_OS_X_TIGER || IS_MAC_OS_X_LEOPARD || IS_MAC_OS_X_SNOW_LEOPARD || IS_MAC_OS_X_LION
                                    || IS_MAC_OS_X_MOUNTAIN_LION || IS_MAC_OS_X_MAVERICKS || IS_MAC_OS_X_YOSEMITE || IS_MAC_OS_X_EL_CAPITAN;


    /*
     * windows版本参考以下网址（windows version refer to the following website）：
     * https://en.wikipedia.org/wiki/List_of_Microsoft_Windows_versions
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
