# 多线程高并发

## 线程与线程状态



## synchronized

### synchronized的底层实现

JDK早期, 即1.5版本之前,synchronized为OS重量级锁

后来改进为锁升级的概念:

synchronized (Object) 

markword记录这个线程ID (偏向锁), 如果线程争用:升级为自旋锁, 10次之后升级为重量级锁 OS

**当执行时间较长推荐用重量级OS锁,线程将挂起进入等待状态不占用CPU资源**

**当执行时间较短，加锁代码，线程数量少用自旋锁**



## volatile

### 1. 作用

1. 保证线程可见性
   - MESI
   - 缓存一致性协议
2. 禁止指令重排序(CPU)
   - DCL单例
   - Double Check Lock
   - Mgr06.java



## CAS（无锁优化 / 乐观锁 自旋）

1. Compare And Set

2. cas(V, Expected, NewValue)

   if V == E

   V = New

   otherwise try again or fail

   CPU原语支持

3. ABA问题

   - 加version
   - A 1.0
   - B 2.0
   - A 3.0
   - cas(version)
   - 如果基础类型
