package com.kevin.jvm.simples;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 * ManagementFactory可以获取JVM进程、内存、编译等信息
 *
 * @author kevin
 */
public class ManagementFactorySimple {

  public static void main(String[] args) {

    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    Logger.getGlobal().info("ObjectName:" + threadMXBean.getObjectName());
    Logger.getGlobal().info("仍活动的线程总数:" + threadMXBean.getThreadCount());
    Logger.getGlobal().info("峰值=:" + threadMXBean.getPeakThreadCount());
    Logger.getGlobal().info("线程总数（被创建并执行过的线程总数）:" + threadMXBean.getTotalStartedThreadCount());
    Logger.getGlobal().info("当初仍活动的守护线程（daemonThread）总数:" + threadMXBean.getDaemonThreadCount());
    //检查是否有死锁的线程存在
    long[] deadlockedIds = threadMXBean.findDeadlockedThreads();
    if (ArrayUtils.isNotEmpty(deadlockedIds)) {
      ThreadInfo[] deadlockInfos = threadMXBean.getThreadInfo(deadlockedIds);
      Logger.getGlobal().info("线程信息:");
      Logger.getGlobal().info("\t\t线程名称\t\t状态\t\t");
      for (ThreadInfo deadlockInfo : deadlockInfos) {
        Logger.getGlobal().info("\t\t" + deadlockInfo.getThreadName() +
            "\t\t" + deadlockInfo.getThreadState() + "\t\t" +
            deadlockInfo.getBlockedTime() + "\t\t" + deadlockInfo.getWaitedTime() +
            "\t\t" + Arrays.toString(deadlockInfo.getStackTrace()));
      }
    } else {
      Logger.getGlobal().info("未检索到死锁线程");
    }
    long[] threadIds = threadMXBean.getAllThreadIds();
    if (ArrayUtils.isNotEmpty(threadIds)) {
      ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
      Logger.getGlobal().info("所有线程信息:");
      Logger.getGlobal().info("\t\t线程名称\t\t\t\t\t状态\t\t\t\t\t线程id");
      for (ThreadInfo threadInfo : threadInfos) {
        Logger.getGlobal().info("\t\t" + threadInfo.getThreadName() + "\t\t\t\t\t"
            + threadInfo.getThreadState() + "\t\t\t\t\t" + threadInfo.getThreadId());
      }
    }
  }
}
