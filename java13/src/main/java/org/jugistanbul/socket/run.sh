#!/usr/bin/env bash

java -XX:+TraceClassLoading --enable-preview --source 14 NioSocketImplExample.java  | grep 'NioSocketImpl'

#If you want to switch back to the old implementation PlainSocketImpl
# you can use jdk.net.usePlainSocketImpl system property setting
# java -Djdk.net.usePlainSocketImpl -XX:+TraceClassLoading --enable-preview --source 14 NioSocketImplExample.java  | grep 'NioSocketImpl'
