package org.jugistanbul.switchexpressions;

import java.time.LocalDateTime;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 15.04.2020
 **/

public class SwitchExpressionsExample
{
    public static void main(String[] args){

        System.out.println(getWorkerDefinition(Worker.JOBWORKER));

        final var day = LocalDateTime.now().getDayOfWeek().getValue();
        System.out.println("The day type is " + getDayDype(day) + "\n");
        System.out.println("The day type is " + getDayDype(8) + "\n");
    }

    public static String getWorkerDefinition(final Worker worker) {
        var workerDefinition = switch (worker) {
            case JOBWORKER ->
                    "JOB Worker. This is the person who hates Mondays, lives for the weekends, and brings donuts in on Friday\n";
            case CAREERWORKER -> "Career Worker. They want career status\n";
            case MISSONWORKER -> "Mission Worker. They are on a mission to change something\n";
        };

        return workerDefinition;
    }

    public static DayType getDayDype(final int day){
        return switch (day) {
            case 1, 2, 3, 4, 5 -> DayType.WEEKDAY;
            case 6, 7 -> DayType.WEEKEND;
            default -> DayType.UNKNOWN;
        };
    }
}

enum Worker
{
    JOBWORKER, CAREERWORKER, MISSONWORKER
}

enum DayType
{
    WEEKDAY, WEEKEND, UNKNOWN
}