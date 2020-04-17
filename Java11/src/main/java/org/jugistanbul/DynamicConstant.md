class AlternativeDynamicConstant {
  // constant pool #1 = 10
  // constant pool #2 = 20
  // constant pool #3 = MethodHandle:Math.max(int,int)
  // constant pool #4 = constantdyamic:ConstantBootstraps.invoke/maximum/int.class/#3,#1,#2
  final int CONST_A = [constant #1], CONST_B = [constant #2];
  void hello() {
    System.out.print([constant #4]);
  }
}