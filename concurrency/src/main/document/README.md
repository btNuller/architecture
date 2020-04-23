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

