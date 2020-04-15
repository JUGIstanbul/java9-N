package org.jugistanbul.process;

import java.io.IOException;
import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;

public class ProcessService
{
        public static void sortByDurationAndListAllProcesses()
        {
                ProcessHandle.allProcesses()
                                .map(ProcessHandle::info)
                                .sorted(Comparator.comparing(info -> info.totalCpuDuration().orElse(Duration.ZERO)))
                                .forEach(info -> info.command()
                                                .ifPresent(command -> info.totalCpuDuration()
                                                                        .ifPresent(duration -> System.out.println(command + " has been running for " + duration))));
        }

        public static void listOfMyProcesses()
        {
                final String userName = System.getProperty("user.name");
                ProcessHandle.allProcesses().map(ProcessHandle::info)
                                .filter(info -> info.user().filter(name -> name.contains(userName)).isPresent())
                                .forEach(info -> info.command()
                                                .ifPresent(command -> info.totalCpuDuration()
                                                                .ifPresent(duration -> System.out.println(command + " has been running for " + duration))));
        }

        public static void findProcesses(String text)
        {
                ProcessHandle.allProcesses()
                                .filter(p -> p.info().command()
                                        .filter(cmd -> cmd.contains(text)).isPresent())
                                .forEach(p -> p.info().command()
                                                .ifPresent(command -> System.out.printf("Found Process : %d %s\n", p.pid(), command)));
        }

        public static void killProcess(long pid, Runnable doSomething)
        {
                Optional<ProcessHandle> pho = ProcessHandle.of(pid);
                pho.ifPresent(ph -> {
                                Optional.of(doSomething).ifPresent( act -> ph.onExit().thenRunAsync(act));
                                ph.destroyForcibly();
                        }
                );
        }

        public static Process exec(String command) throws IOException
        {
                return Runtime.getRuntime().exec(command);
        }

        public static void main(String[] args) throws IOException, InterruptedException
        {
                System.out.println("************ LIST OF ALL PROCESSES ***********");
                ProcessService.sortByDurationAndListAllProcesses();

                System.out.println("************ LIST OF MY PROCESSES ***********");
                ProcessService.listOfMyProcesses();

                ProcessService.findProcesses("chrome");

                Process process = ProcessService.exec("sleep 1h");
                ProcessService.killProcess(process.pid(), () -> System.out.printf("Process{%d} killed!\n", process.pid()));

                Thread.sleep(1000);
        }

}