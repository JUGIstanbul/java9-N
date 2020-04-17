**Java Flight Recorder**

- Open Sourced but not free.
- JFR is a tool for collecting diagnostic and profiling data about a running Java application.

To enable JFR for a JVM, you must add these parameters:

> -XX:+UnlockCommercialFeatures -XX:+FlightRecorder

Profiling

> java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=myrecording.jfr MyApp
> jcmd 5368 JFR.start duration=60s filename=myrecording.jfr

**JFR. Commands**

JFR.start

Start a recording.

JFR.check

Check the status of all recordings running for the specified process, including the recording identification number, file name, duration, and so on.

JFR.stop

Stop a recording with a specific identification number (by default, recording 1 is stopped).

JFR.dump

Dump the data collected so far by the recording with a specific identification number (by default, data from recording 1 is dumped).

> maxsize=size // size limit
> maxage=age // age limit
> delay=delay // put a delay before collecting is actually started
> compress=true
> -XX:FlightRecorderOptions=defaultrecording=true,dumponexit=true,dumponexitpath=path // Recording on exit

