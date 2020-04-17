mvn archetype:generate \
            -DinteractiveMode=false \
            -DarchetypeGroupId=org.openjdk.jmh \
            -DarchetypeArtifactId=jmh-java-benchmark-archetype \
            -DgroupId=org.sample \
            -DartifactId=your-benchmark \
            -Dversion=1.0
           
// Read the article : https://rieckpil.de/howto-java-benchmarking-with-jmh-java-microbenchmark-harness/