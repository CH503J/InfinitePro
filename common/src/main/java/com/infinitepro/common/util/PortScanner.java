package com.infinitepro.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortScanner {

    public static void main(String[] args) {
        // 只检测的端口集合
        List<Integer> portsToCheck = Arrays.asList(22000, 22001, 22010, 21010, 3306);

        System.out.println("=== 检查指定端口占用情况 ===\n");

        try {
            // 获取系统端口占用情况
            Process process = Runtime.getRuntime().exec("netstat -ano");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            // 匹配 TCP 监听端口
            Pattern pattern = Pattern.compile("^\\s*TCP\\s+\\S+:(\\d+)\\s+\\S+\\s+LISTENING\\s+(\\d+)");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    int port = Integer.parseInt(matcher.group(1));
                    String pid = matcher.group(2);

                    if (portsToCheck.contains(port)) {
                        String processName = getProcessName(pid);
                        System.out.printf("端口: %d   PID: %s   服务: %s%n", port, pid, processName);
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n=== 检查完成 ===");
    }

    private static String getProcessName(String pid) {
        try {
            Process p = Runtime.getRuntime().exec("tasklist /FI \"PID eq " + pid + "\" /FO LIST");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
                // 正则匹配映像名称
                if (line.matches("映像名称\\s*:\\s*.*")) {
                    return line.replaceAll("映像名称\\s*:\\s*", "").trim();
                }
            }
        } catch (Exception e) {
            // 忽略异常
        }
        return "未知";
    }
}
