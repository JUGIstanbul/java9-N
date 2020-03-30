package org.jugistanbul.stackwalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.StackWalker.*;

public class StackWalker {

        public void stackWalk(){
                new StackWalker1().stackWalk1();
        }

        public void print(){
                System.out.println("Hello World.");
        }

        private class StackWalker1{
                public void stackWalk1(){
                        new StackWalker2().stackWalk2();
                }
        }

        private class StackWalker2{
                public void stackWalk2(){
                        new StackWalker3().stackWalk3();
                }
        }

        private class StackWalker3{
                public void stackWalk3(){
                        new StackWalker4().stackWalk4();
                }
        }

        private static List<String> walkAndFilterStackframe() {
                return java.lang.StackWalker.getInstance().walk(s ->
                                                              s.map( frame-> frame.getClassName()+"/"+frame.getMethodName())
                                                               //.filter(name -> name.contains("StackWalker"))
                                                               .limit(10)
                                                               .collect(Collectors.toList()));
        }

        private class StackWalker4{
                public void stackWalk4(){
                        System.out.println(walkAndFilterStackframe().toString());
                        List<StackFrame> stack =
                                java.lang.StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE).walk((s) -> s.collect(Collectors.toList()));


                        System.out.println("***** All frames *****");

                        for(StackFrame stackFrame : stack){
                                System.out.println(stackFrame.toString());
                        }

                        System.out.print("\n\n");

                        // Filter for interesting classes
                        final List<Class> interestingClasses = new ArrayList<>();
                        interestingClasses.add(StackWalker3.class);

                        Optional<StackFrame> framesWithInterestingClass = java.lang.StackWalker.getInstance(
                                java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE).walk((s) ->
                                                                                                                                                          s.filter(f -> interestingClasses.contains(f.getDeclaringClass())).findFirst()
                                                                                         );

                        System.out.println("Frame with interseting class : \n"+framesWithInterestingClass.toString());

                        System.out.print("\n\n");

                        // Frames with skip
                        List<StackFrame> framesAfterSkip = java.lang.StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE).walk((s) ->
                                                                                                                                           s.skip(2).collect(Collectors.toList())
                                                                                                                                                      );
                        System.out.println("Frames after skip");
                        for(StackFrame stackFrame : framesAfterSkip){
                                System.out.println(stackFrame.toString());
                        }
                }
        }

        public static void main(String args[]){
                System.out.println("StackWalkerExample...");
                new StackWalker().stackWalk();
        }
}